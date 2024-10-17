package org.example.dddlearning.transfer.domain.repository;


import org.example.dddlearning.transfer.domain.model.Account;

import java.util.Optional;

/**
 * @author: hanchaowei
 * @date 2024/10/11
 * @description: 账户仓储接口
 */

public interface AccountRepository {

	Optional<Account> findById(Long accountId);

	void save(Account account);

	void update(Account account);
}
