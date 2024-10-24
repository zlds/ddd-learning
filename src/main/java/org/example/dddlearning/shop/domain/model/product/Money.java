package org.example.dddlearning.shop.domain.model.product;

import java.math.BigDecimal;

/**
 * @author: hanchaowei
 * @date 2024/10/24
 * @description: 金额
 */

public class Money {

	private final BigDecimal amount;

	public Money(BigDecimal amount) {
		if (amount == null) {
			throw new IllegalArgumentException("价格不能为空");
		}
		if (amount.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("价格不能为负数");
		}
		this.amount = amount;
	}

	// 获取金额
	public BigDecimal getAmount() {
		return amount;
	}

}
