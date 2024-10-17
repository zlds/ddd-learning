package org.example.dddlearning.transfer.domain.event;

import java.math.BigDecimal;


/**
 * @author: hanchaowei
 * @date 2024/10/11
 * @description: 转账完成事件
 */

public class TransferCompletedEvent {

	// 源用户id
	private Long fromAccountId;
	// 目标用户id
	private Long toAccountId;
	// 金额
	private BigDecimal amount;

	public TransferCompletedEvent() {
	}

	public TransferCompletedEvent(Long fromAccountId, Long toAccountId, BigDecimal amount) {
		this.fromAccountId = fromAccountId;
		this.toAccountId = toAccountId;
		this.amount = amount;
	}

	public Long getFromAccountId() {
		return fromAccountId;
	}

	public Long getToAccountId() {
		return toAccountId;
	}

	public BigDecimal getAmount() {
		return amount;
	}
}
