package org.example.dddlearning.shop.application.service;

import org.example.dddlearning.shop.application.dto.CreateOrderDTO;
import org.example.dddlearning.shop.application.dto.CreateOrderItemDTO;
import org.example.dddlearning.shop.application.dto.OrderDetailDTO;
import org.example.dddlearning.shop.domain.model.Order;
import org.example.dddlearning.shop.domain.model.OrderItem;
import org.example.dddlearning.shop.domain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: hanchaowei
 * @date 2024/10/18
 * @description:
 */
@Service
public class OrderApplicationService {

	@Autowired
	private OrderService orderService;

	/**
	 * 创建订单
	 * @param createOrderDTO
	 */
	public void createOrder(CreateOrderDTO createOrderDTO) {
		// 创建订单
		List<OrderItem> createOrderItemList = toCreateOrderItemList(createOrderDTO.getItems());
		Order order = new Order(createOrderDTO.getCustomerId(), createOrderDTO.getCustomerName());
		order.setCustomerId(createOrderDTO.getCustomerId());
		for (OrderItem orderItem : createOrderItemList) {
			order.addItem(orderItem);
		}
		orderService.createOrder(order);
	}

	/**
	 * 确认订单
	 * @param orderId
	 */
	public void confirmOrder(Long orderId) {
//		Order order = orderRepository.findById(orderId)
//				.orElseThrow(() -> new IllegalArgumentException("订单不存在: " + orderId));
//		order.confirm();
//		orderRepository.update(order);
	}

	/**
	 * 取消订单
	 * @param orderId
	 */
	public void cancelOrder(Long orderId) {
//		Order order = orderRepository.findById(orderId)
//				.orElseThrow(() -> new IllegalArgumentException("订单不存在: " + orderId));
//		order.cancel();
//		orderRepository.update(order);
	}

	public OrderDetailDTO getOrderDetail(Long orderId) {
		Order orderDetail = orderService.getOrder(orderId);
		return toOrderDetailDTO(orderDetail);
	}



	private List<OrderItem> toCreateOrderItemList(List<CreateOrderItemDTO> itemRequests) {
		return itemRequests.stream().map(s -> new OrderItem(s.getProductId(), s.getProductName(),s.getQuantity(), s.getPrice())).collect(
				Collectors.toList());
	}

	private OrderDetailDTO toOrderDetailDTO(Order order) {
		OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
		orderDetailDTO.setOrderId(order.getId());
		orderDetailDTO.setCustomerId(order.getCustomerId());
		orderDetailDTO.setCustomerName(order.getCustomerName());
		orderDetailDTO.setStatus(order.getStatus().name());
		orderDetailDTO.setTotalAmount(order.getTotalAmount().toString());
		return orderDetailDTO;
	}

}
