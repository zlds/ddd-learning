package org.example.dddlearning.shop.domain.service;

import org.example.dddlearning.shop.domain.model.product.Product;
import org.example.dddlearning.shop.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: hanchaowei
 * @date 2024/10/24
 * @description:
 */
@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public void saveProduct(Product product) {
		productRepository.save(product);
	}

	public Product findProductById(Long productId) {
		return productRepository.findById(productId);
	}


}
