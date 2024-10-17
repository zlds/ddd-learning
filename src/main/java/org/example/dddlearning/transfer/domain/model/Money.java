package org.example.dddlearning.domain.model;

import java.math.BigDecimal;

/**
 * @author: hanchaowei
 * @date 2024/10/9
 * @description: 金额(值对象)
 */

public class Money {
	private final BigDecimal amount;

	public Money(BigDecimal amount) {
		if (amount.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("金额不能为负数");
		}
		this.amount = amount;
	}

	public Money add(Money other) {
		return new Money(this.amount.add(other.amount));
	}

	public Money subtract(Money other) {
		if (this.amount.compareTo(other.amount) < 0) {
			throw new IllegalArgumentException("金额不足");
		}
		return new Money(this.amount.subtract(other.amount));
	}

	public boolean isLessThan(Money other) {
		return this.amount.compareTo(other.amount) < 0;
	}

	public BigDecimal getAmount() {
		return amount;
	}
}

