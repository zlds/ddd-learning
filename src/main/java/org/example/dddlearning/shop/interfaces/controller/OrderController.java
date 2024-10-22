package org.example.dddlearning.shop.interfaces.controller;

import org.example.dddlearning.shop.application.dto.CreateOrderDTO;
import org.example.dddlearning.shop.application.service.OrderApplicationService;
import org.example.dddlearning.shop.application.dto.OrderDetailDTO;
import org.example.dddlearning.shop.converter.OrderConverter;
import org.example.dddlearning.shop.interfaces.request.OrderRequest;
import org.example.dddlearning.shop.interfaces.vo.OrderDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: hanchaowei
 * @date 2024/10/18
 * @description:
 */
@RestController
@RequestMapping("/api/order")
public class OrderController {

	@Autowired
	private OrderApplicationService orderApplicationService;


	@PostMapping("/create")
	public String createOrder(@RequestBody OrderRequest orderRequest) {
		CreateOrderDTO createOrderDTO = OrderConverter.toCreateOrderRequest(orderRequest);
		orderApplicationService.createOrder(createOrderDTO);
		return "订单创建成功";
	}

	@RequestMapping("/detail")
	public OrderDetailVO orderDetail(@RequestParam Long orderId) {
		OrderDetailDTO orderDetail = orderApplicationService.getOrderDetail(orderId);
		OrderDetailVO orderDetailVO = OrderConverter.toOrderDetailVO(orderDetail);
		return orderDetailVO;
	}


}
