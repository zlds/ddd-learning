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
	// 客户姓名
	private String customerName;

	private List<OrderItemRequest> items;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public List<OrderItemRequest> getItems() {
		return items;
	}

	public void setItems(List<OrderItemRequest> items) {
		this.items = items;
	}
}
