package org.example.dddlearning.shop.domain.model;

import java.math.BigDecimal;

/**
 * @author: hanchaowei
 * @date 2024/10/17
 * @description:
 */

public class OrderItem {

	// 商品ID
	private Long productId;
	// 商品数量
	private int quantity;
	// 商品单价
	private BigDecimal price;
	// 商品名称
	private String productName;

	public OrderItem(Long productId, String productName,int quantity, BigDecimal price) {
		if (quantity <= 0) {
			throw  new IllegalArgumentException("商品数量必须大于0");
		}
		if (price.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("商品单价不能为负");
		}
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
	}

	public Long getProductId() {
		return productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
}
