package org.example.dddlearning.transfer.interfaces;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: hanchaowei
 * @date 2024/10/15
 * @description:
 */
@Data
public class AccountDTO {

	private Long accountId;
	private BigDecimal balance;

	public AccountDTO(Long accountId, BigDecimal balance) {
		this.accountId = accountId;
		this.balance = balance;
	}
}
