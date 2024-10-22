package org.example.dddlearning.shop.infrastructure.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.dddlearning.shop.domain.model.*;
import org.example.dddlearning.shop.domain.repository.OrderRepository;
import org.example.dddlearning.shop.infrastructure.entity.OrderEntity;
import org.example.dddlearning.shop.infrastructure.entity.OrderItemEntity;
import org.example.dddlearning.shop.infrastructure.mapper.OrderItemMapper;
import org.example.dddlearning.shop.infrastructure.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author: hanchaowei
 * @date 2024/10/17
 * @description:
 */
@Component
public class OrderRepositoryImpl implements OrderRepository {

	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private OrderItemMapper orderItemMapper;


	@Override
	@Transactional
	public void save(Order order) {
		OrderEntity entity = toEntity(order);
		orderMapper.insert(entity);
		// 保存订单明细
		List<OrderItem> items = order.getItems();
		List<OrderItemEntity> orderItemEntityList = new ArrayList<>();
		for (OrderItem item : items) {
			OrderItemEntity orderItemEntity = toEntity(item, entity.getId());
			orderItemEntityList.add(orderItemEntity);
		}
		orderItemMapper.insert(orderItemEntityList);
	}

	@Override
	public Optional<Order> findById(Long orderId) {
		OrderEntity orderEntity = orderMapper.findById(orderId);
		if (orderEntity == null) {
			return Optional.empty();
		}
		QueryWrapper<OrderItemEntity> queryWrapper = new QueryWrapper();
		queryWrapper.eq("order_id", orderId);
		List<OrderItemEntity> orderItemEntities = orderItemMapper.selectList(queryWrapper);
		Order order = toDomain(orderEntity, orderItemEntities);
		return Optional.of(order);
	}


	@Override
	public void update(Order order) {
		OrderEntity entity = toEntity(order);
		orderMapper.updateById(entity);
	}


	// 领域层转换为持久化实体
	private OrderEntity toEntity(Order order) {
		OrderEntity entity = new OrderEntity();
		entity.setCustomerId(order.getCustomerId());
		entity.setStatus(order.getStatus().name());
		return entity;
	}

	private OrderItemEntity toEntity(OrderItem orderItem, Long orderId) {
		OrderItemEntity entity = new OrderItemEntity();
		entity.setOrderId(orderId);
		entity.setProductId(orderItem.getProductId());
		entity.setPrice(orderItem.getPrice());
		entity.setQuantity(orderItem.getQuantity());
		return entity;
	}


	// 持久化实体转换为领域对象
	private Order toDomain(OrderEntity entity, List<OrderItemEntity> itemEntities) {
		List<OrderItem> items = itemEntities.stream().map(this::toDomain).collect(Collectors.toList());
		Order order = new Order(entity.getCustomerId(), entity.getCustomerName());
		order.setId(entity.getId());
		order.setCustomerId(entity.getCustomerId());
		order.setStatus(OrderStatus.valueOf(entity.getStatus()));
		for (OrderItem item : items) {
			order.addItem(item);
		}
		return order;
	}

	private OrderItem toDomain(OrderItemEntity entity) {
		return new OrderItem(entity.getProductId(), entity.getProductName(),entity.getQuantity(), entity.getPrice());
	}

}
