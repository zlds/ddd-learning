package org.example.dddlearning.shop.application.dto;


import java.util.List;

/**
 * @author: hanchaowei
 * @date 2024/10/21
 * @description:
 */

public class CreateOrderDTO {
	private String customerId;

	private String customerName;

	private List<CreateOrderItemDTO> items;

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

	public List<CreateOrderItemDTO> getItems() {
		return items;
	}

	public void setItems(List<CreateOrderItemDTO> items) {
		this.items = items;
	}
}
