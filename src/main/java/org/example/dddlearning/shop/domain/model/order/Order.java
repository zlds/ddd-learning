package org.example.dddlearning.shop.domain.model.order;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: hanchaowei
 * @date 2024/10/17
 * @description:
 */

public class Order {

	// 订单id
	private Long id;
	// 客户id
	private String customerId;
	// 客户姓名
	private String customerName;
	// 订单明细列表
	private List<OrderItem> items;
	// 订单状态
	private OrderStatus status;
	// 订单总金额
	private Money totalAmount;
	// 创建时间
	private Date createTime;

	public Order(String customerId,String customerName) {
		if (customerId == null || customerId.isEmpty()) {
			throw new IllegalArgumentException("客户id不能为空");
		}
		if (customerName == null || customerName.isEmpty()) {
			throw new IllegalArgumentException("客户姓名不能为空");
		}
		this.customerId = customerId;
		this.customerName = customerName;
		this.items = new ArrayList<>();
		this.status = OrderStatus.CREATED;
		this.totalAmount = new Money(BigDecimal.ZERO);
		this.createTime = new Date();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public List<OrderItem> getItems() {
		return items;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Money getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Money totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	// 添加订单明细
	public void addItem(OrderItem item) {
		if (item == null) {
			throw new IllegalArgumentException("订单明细不能为空");
		}
		items.add(item);
		calculateTotalAmount();
	}

	// 删除订单明细
	public void removeItem(OrderItem item) {
		if (item == null) {
			throw new IllegalArgumentException("订单明细不能为空");
		}
		items.remove(item);
	}

	// 确认订单
	public void confirm() {
		if (items.isEmpty()) {
			throw new IllegalStateException("订单必须至少有一个订单明细");
		}
		this.status = OrderStatus.CONFIRMED;
	}

	// 取消订单
	public void cancel() {
		if (status == OrderStatus.SHIPPED) {
			throw new IllegalStateException("已发货的订单无法取消");
		}
		this.status = OrderStatus.CANCELLED;
	}


	// 计算订单总金额
	private void calculateTotalAmount() {
		BigDecimal totalAmount = BigDecimal.ZERO;
		for (OrderItem item : items) {
			totalAmount = totalAmount.add(item.getPrice().multiply(new BigDecimal(item.getQuantity())));
		}
		this.totalAmount = new Money(totalAmount);
	}

}