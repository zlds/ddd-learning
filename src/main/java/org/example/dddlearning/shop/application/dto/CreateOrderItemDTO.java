package org.example.dddlearning.shop.application.dto;

import java.math.BigDecimal;

/**
 * @author: hanchaowei
 * @date 2024/10/21
 * @description:
 */

public class CreateOrderItemDTO {

	// 商品ID
	private Long productId;

	// 商品数量
	private int quantity;

	// 商品价格
	private BigDecimal price;

	// 商品名称
	private String productName;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
