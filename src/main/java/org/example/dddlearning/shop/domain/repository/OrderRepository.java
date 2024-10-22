package org.example.dddlearning.shop.domain.repository;

import org.example.dddlearning.shop.domain.model.Order;

import java.util.Optional;

/**
 * @author: hanchaowei
 * @date 2024/10/17
 * @description:
 */

public interface OrderRepository {

	void save(Order order);

	Optional<Order> findById(Long orderId);

	void update(Order order);

}
