package org.example.dddlearning.shop.domain.model.product;

/**
 * @author: hanchaowei
 * @date 2024/10/24
 * @description: 价格
 */

public class Price {

	// 基础价格
	private Money basePrice;
	// 折扣价格
	private Money discountPrice;

	public Price(Money basePrice, Money discountPrice) {
		if (basePrice == null) {
			throw new IllegalArgumentException("基础价格不能为空");
		}
		this.basePrice = basePrice;
		this.discountPrice = discountPrice;
	}

	// 获取当前价格(如果有折扣返回折扣价，否则返回原价)
	public Money getFinalPrice() {
		return discountPrice != null ? discountPrice : basePrice;
	}

	// 获取原价
	public Money getBasePrice() {
		return basePrice;
	}

	public Money getDiscountPrice() {
		return discountPrice;
	}
}
