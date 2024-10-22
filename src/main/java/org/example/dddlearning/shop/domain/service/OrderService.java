package org.example.dddlearning.shop.domain.service;

import org.example.dddlearning.shop.domain.model.Order;
import org.example.dddlearning.shop.domain.model.OrderItem;
import org.example.dddlearning.shop.domain.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: hanchaowei
 * @date 2024/10/22
 * @description:
 */
@Service
public class OrderService {


	@Autowired
	private OrderRepository orderRepository;


	public void createOrder(Order orderReq) {
		Order order = new Order(orderReq.getCustomerId(),orderReq.getCustomerName());
		for (OrderItem orderItem : orderReq.getItems()) {
			order.addItem(orderItem);
		}
		orderRepository.save(order);
	}

	public Order getOrder(Long orderId) {
		Order order = orderRepository.findById(orderId)
				.orElseThrow(() -> new IllegalArgumentException("订单不存在: " + orderId));
		// 计算总金额
		List<OrderItem> items = order.getItems();
		for (OrderItem item : items) {
			order.setTotalAmount(item.getPrice().multiply(new BigDecimal(item.getQuantity())));
		}
		return order;
	}


}
