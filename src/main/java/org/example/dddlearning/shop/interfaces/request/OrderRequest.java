package org.example.dddlearning.shop.interfaces.request;

import java.util.List;

/**
 * @author: hanchaowei
 * @date 2024/10/18
 * @description:
 */

public class OrderRequest {

	// 客户ID
	private String customerId;

	private List<OrderItemRequest> items;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public List<OrderItemRequest> getItems() {
		return items;
	}

	public void setItems(List<OrderItemRequest> items) {
		this.items = items;
	}
}
