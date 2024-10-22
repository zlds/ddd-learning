package org.example.dddlearning.shop.application.dto;

/**
 * @author: hanchaowei
 * @date 2024/10/22
 * @description:
 */

public class OrderDetailDTO {
	// 订单id
	private Long orderId;
	// 客户id
	private String customerId;
	// 客户姓名
	private String customerName;
	// 状态
	private String status;
	// 总金额
	private String totalAmount;

	public Long getOrderId() {
		return orderId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getStatus() {
		return status;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
}
