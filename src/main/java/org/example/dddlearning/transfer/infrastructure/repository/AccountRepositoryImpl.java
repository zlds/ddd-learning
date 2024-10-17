package org.example.dddlearning.transfer.infrastructure.repository;

import org.example.dddlearning.domain.model.Account;
import org.example.dddlearning.domain.model.Money;
import org.example.dddlearning.domain.repository.AccountRepository;
import org.example.dddlearning.transfer.infrastructure.repository.entity.AccountEntity;
import org.example.dddlearning.transfer.infrastructure.repository.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.Optional;

/**
 * @author: hanchaowei
 * @date 2024/10/11
 * @description:
 */
@Component
public class AccountRepositoryImpl implements AccountRepository {

	@Autowired
	private AccountMapper accountMapper;


	@Override
	public Optional<Account> findById(Long accountId) {
		AccountEntity entity = accountMapper.findById(accountId);
		return Optional.ofNullable(entity).map(this::mapToDomain);
	}

	@Override
	public void save(Account account) {
		AccountEntity entity = mapToEntity(account);
		accountMapper.insert(entity);
	}

	@Override
	public void update(Account account) {
		AccountEntity entity = mapToEntity(account);
		accountMapper.update(entity);
	}

	private Account mapToDomain(AccountEntity entity) {
		return new Account(entity.getId(),new Money(entity.getBalance()));
	}

	private AccountEntity mapToEntity(Account account) {
		AccountEntity entity = new AccountEntity();
		entity.setId(account.getAccountId());
		entity.setBalance(account.getBalance().getAmount());
		return entity;
	}
}
