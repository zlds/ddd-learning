package org.example.dddlearning.shop.domain.repository;

import org.example.dddlearning.shop.domain.model.product.Product;

/**
 * @author: hanchaowei
 * @date 2024/10/24
 * @description: 商品仓储
 */

public interface ProductRepository {

	void save(Product product);

	Product findById(Long productId);

}
