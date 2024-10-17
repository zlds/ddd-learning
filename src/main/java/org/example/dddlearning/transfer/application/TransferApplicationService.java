package org.example.dddlearning.transfer.application;


import org.example.dddlearning.transfer.domain.model.Account;
import org.example.dddlearning.transfer.domain.model.Money;
import org.example.dddlearning.transfer.domain.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author: hanchaowei
 * @date 2024/10/11
 * @description:
 */
@Service
public class TransferApplicationService {

	@Autowired
	private TransferService transferService;

	public String addUser(Long accountId, BigDecimal balance) {
		return transferService.addUser(accountId, new Money(balance));
	}

	public void transfer(Long fromAccountId, Long toAccountId, BigDecimal amount) {
		// 将 BigDecimal 转换为 Money 对象
		Money money = new Money(amount);
		transferService.transfer(fromAccountId, toAccountId, money);
	}

	public Account getUser(Long accountId) {
		return transferService.getAccount(accountId);
	}
}
