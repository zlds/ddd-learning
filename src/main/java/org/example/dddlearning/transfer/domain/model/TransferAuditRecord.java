package org.example.dddlearning.domain.model;


import lombok.Data;
import java.time.LocalDateTime;

/**
 * @author: hanchaowei
 * @date 2024/10/11
 * @description: 转账记录
 */
@Data
public class TransferAuditRecord {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 转出账户ID
	 */
	private Long fromAccountId;
	/**
	 * 转入账户ID
	 */
	private Long toAccountId;
	/**
	 * 转账金额
	 */
	private Money amount;
	/**
	 * 转账时间
	 */
	private LocalDateTime timestamp;


	public TransferAuditRecord(Long fromAccountId, Long toAccountId, Money amount) {
		this.fromAccountId = fromAccountId;
		this.toAccountId = toAccountId;
		this.amount = amount;
	}

	public TransferAuditRecord() {

	}

	public Long getId() {
		return id;
	}

	public Long getFromAccountId() {
		return fromAccountId;
	}

	public Long getToAccountId() {
		return toAccountId;
	}

	public Money getAmount() {
		return amount;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}
}
