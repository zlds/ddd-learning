package org.example.dddlearning.shop.domain.model;

import java.math.BigDecimal;

/**
 * @author: hanchaowei
 * @date 2024/10/23
 * @description:
 */

public class Money {

	private final BigDecimal amount;

	public Money(BigDecimal amount) {
		if (amount == null) {
			throw new IllegalArgumentException("金额不能为空");
		}
		if (amount.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("金额不能为负数");
		}
		this.amount = amount;
	}

	// 获取金额
	public BigDecimal getAmount() {
		return amount;
	}

	// 加
	public Money add(Money other) {
		if (other == null) {
			throw new IllegalArgumentException("传入的金额不能为空");
		}
		return new Money(this.amount.add(other.amount));
	}

	// 减
	public Money subtract(Money other) {
		if (other == null) {
			throw new IllegalArgumentException("传入的金额不能为空");
		}
		BigDecimal result = this.amount.subtract(other.amount);
		if (result.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("金额不足");
		}
		return new Money(result);
	}

	// 乘
	public Money multiply(BigDecimal multiplier) {
		if (multiplier == null) {
			throw new IllegalArgumentException("传入的乘数不能为空");
		}
		return new Money(this.amount.multiply(multiplier));
	}
}
