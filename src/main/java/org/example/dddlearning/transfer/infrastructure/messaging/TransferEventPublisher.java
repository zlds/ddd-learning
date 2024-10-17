package org.example.dddlearning.transfer.infrastructure.messaging;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dddlearning.transfer.domain.event.TransferCompletedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author: hanchaowei
 * @date 2024/10/11
 * @description:
 */
@Component
public class TransferEventPublisher {

	@Autowired
	private KafkaTemplate<String,String> kafkaTemplate;

	public void publish(TransferCompletedEvent event) {
		try {
			String jsonString = new ObjectMapper().writeValueAsString(event);
			kafkaTemplate.send("transfer-completed-topic",jsonString);
		} catch (Exception e) {
			System.out.println("发送消息失败,主题：transfer-completed-topic, 数据：" + event.toString());
			e.printStackTrace();
		}
	}
}
