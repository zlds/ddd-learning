package org.example.dddlearning.transfer.infrastructure.messaging;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.example.dddlearning.transfer.domain.event.TransferCompletedEvent;
import org.example.dddlearning.transfer.domain.model.Money;
import org.example.dddlearning.transfer.domain.model.TransferAuditRecord;
import org.example.dddlearning.transfer.domain.repository.TransferAuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

/**
 * @author: hanchaowei
 * @date 2024/10/11
 * @description: 转账事件消费者
 */
@Component
public class TransferEventConsumer {

	@Autowired
	private TransferAuditRepository transferAuditRepository;


	@KafkaListener(topics = "transfer-completed-topic")
	public void handleTransferCompletedEvent(String message, Acknowledgment ack) {
		try {
			TransferCompletedEvent event = new ObjectMapper().readValue(message,
					TransferCompletedEvent.class);
			TransferAuditRecord transferAuditRecord = new TransferAuditRecord(event.getFromAccountId(),
					event.getToAccountId(), new Money(event.getAmount()));
			transferAuditRepository.save(transferAuditRecord);
			ack.acknowledge();
		} catch (Exception e) {
			System.out.println("消费消息失败,主题：transfer-completed-topic, 数据：" + message);
			e.printStackTrace();
		}

	}

}
