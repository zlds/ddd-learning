package org.example.dddlearning.shop.converter;

import org.example.dddlearning.shop.application.dto.CreateOrderItemDTO;
import org.example.dddlearning.shop.application.dto.CreateOrderDTO;
import org.example.dddlearning.shop.application.dto.OrderDetailDTO;
import org.example.dddlearning.shop.interfaces.request.OrderRequest;
import org.example.dddlearning.shop.interfaces.vo.OrderDetailVO;
import org.example.dddlearning.shop.interfaces.request.OrderItemRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: hanchaowei
 * @date 2024/10/21
 * @description:
 */

public class OrderConverter {
	public static CreateOrderDTO toCreateOrderRequest(OrderRequest orderRequest) {
		CreateOrderDTO request = new CreateOrderDTO();
		request.setCustomerId(orderRequest.getCustomerId());
		request.setCustomerName(orderRequest.getCustomerName());
		request.setItems(toCreateOrderItemRequest(orderRequest.getItems()));
		return request;
	}


	public static List<CreateOrderItemDTO> toCreateOrderItemRequest(List<OrderItemRequest> items) {
		List<CreateOrderItemDTO> request = new ArrayList<>();
		for (OrderItemRequest item : items) {
			CreateOrderItemDTO r = new CreateOrderItemDTO();
			r.setPrice(item.getPrice());
			r.setProductId(item.getProductId());
			r.setQuantity(item.getQuantity());
			r.setProductName(item.getProductName());
			request.add(r);
		}
		return request;
	}

	public static OrderDetailVO toOrderDetailVO(OrderDetailDTO orderDetail) {
		OrderDetailVO vo = new OrderDetailVO();
		vo.setOrderId(orderDetail.getOrderId());
		vo.setCustomerId(orderDetail.getCustomerId());
		vo.setCustomerName(orderDetail.getCustomerName());
		vo.setStatus(orderDetail.getStatus());
		vo.setTotalAmount(orderDetail.getTotalAmount());
		return vo;
	}
}
