package org.example.dddlearning.shop.domain.facory;

import org.example.dddlearning.shop.domain.model.Order;
import org.example.dddlearning.shop.domain.model.OrderItem;
import org.example.dddlearning.shop.domain.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: hanchaowei
 * @date 2024/10/23
 * @description: 订单工厂
 */
@Component
public class OrderFactory {

	@Autowired
	private PromotionService promotionService;

	public  Order createOrder(String customerId, String customerName,List<OrderItem> itemList) {
		// 模拟获取客户类型
		boolean isSupportPromotion = promotionService.isSupportPromotion(customerId);
		Order order = new Order(customerId, customerName);
		for (OrderItem orderItem : itemList) {
			// 如果是VIP用户进行折扣计算
			if (isSupportPromotion) {
				orderItem.setPrice(promotionService.applyDiscount(orderItem.getPrice()));
			}
			order.addItem(orderItem);
		}

		return order;
	}
}
