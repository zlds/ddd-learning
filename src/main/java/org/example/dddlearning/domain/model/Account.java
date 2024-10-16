package org.example.dddlearning.domain.model;

/**
 * @author: hanchaowei
 * @date 2024/10/9
 * @description: 账户领域模型
 */

public class Account {

	/**
	 * 账户ID
	 */
	private  Long accountId;
	/**
	 * 余额
	 */
	private Money balance;

	public Account(Long accountId, Money balance) {
		this.accountId = accountId;
		this.balance = balance;
	}

	public Long getAccountId() {
		return accountId;
	}

	public Money getBalance() {
		return balance;
	}

	/**
	 * 从账户中取款
	 * @param amount
	 */
	public void debit(Money amount) {
		if (balance.isLessThan(amount)) {
			throw new IllegalArgumentException("余额不足");
		}
		balance = balance.subtract(amount);
	}

	/**
	 * 向账户中存款
	 * @param amount
	 */
	public void credit(Money amount) {
		balance = balance.add(amount);
	}
}
