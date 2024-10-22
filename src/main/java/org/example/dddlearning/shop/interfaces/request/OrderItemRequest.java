package org.example.dddlearning.shop.interfaces.request;

import java.math.BigDecimal;

/**
 * @author: hanchaowei
 * @date 2024/10/18
 * @description:
 */

public class OrderItemRequest {

	// 商品ID
	private Long productId;

	// 商品数量
	private Integer quantity;

	// 商品价格
	private BigDecimal price;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
