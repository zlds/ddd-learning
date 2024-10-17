package org.example.dddlearning.transfer.domain.service;


import org.example.dddlearning.transfer.domain.event.TransferCompletedEvent;
import org.example.dddlearning.transfer.domain.model.Account;
import org.example.dddlearning.transfer.domain.model.Money;
import org.example.dddlearning.transfer.domain.repository.AccountRepository;
import org.example.dddlearning.transfer.infrastructure.messaging.TransferEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author: hanchaowei
 * @date 2024/10/9
 * @description: 转账服务(封装业务逻辑的领域服务)
 */
@Service
public class TransferService {

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private TransferEventPublisher transferEventPublisher;

	public String addUser(Long accountId, Money balance) {
		Account account = new Account(accountId, balance);
		Optional<Account> accountOptional = accountRepository.findById(accountId);
		if (accountOptional.isPresent()) {
			return "用户已经存在";
		}
		accountRepository.save(account);
		return "创建成功";
	}

	@Transactional
	public void transfer(Long fromAccountId, Long toAccountId, Money amount) {
		Account fromAccount = accountRepository.findById(fromAccountId)
				.orElseThrow(() -> new IllegalArgumentException("Account not found: " + fromAccountId));
		Account toAccount = accountRepository.findById(toAccountId)
				.orElseThrow(() -> new IllegalArgumentException("Account not found: " + toAccountId));

		fromAccount.debit(amount);
		toAccount.credit(amount);

		accountRepository.update(fromAccount);
		accountRepository.update(toAccount);

		TransferCompletedEvent event = new TransferCompletedEvent(fromAccountId, toAccountId, amount.getAmount());
		transferEventPublisher.publish(event);
	}

	public Account getAccount(Long accountId) {
		return accountRepository.findById(accountId)
				.orElseThrow(() -> new IllegalArgumentException("Account not found: " + accountId));
	}
}
