package org.example.dddlearning.shop.domain.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author: hanchaowei
 * @date 2024/10/23
 * @description:
 */
@Service
public class PromotionService {

	// 是否是促销客户
	public boolean isSupportPromotion(String customerId) {
		return true;
	}

	// 模拟折扣
	public BigDecimal applyDiscount(BigDecimal price) {
		return price.multiply(new BigDecimal("0.8"));
	}
}
