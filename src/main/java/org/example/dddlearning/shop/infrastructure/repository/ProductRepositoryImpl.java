package org.example.dddlearning.shop.infrastructure.repository;

import org.example.dddlearning.shop.domain.model.product.*;
import org.example.dddlearning.shop.domain.repository.ProductRepository;
import org.example.dddlearning.shop.infrastructure.entity.ProductEntity;
import org.example.dddlearning.shop.infrastructure.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author: hanchaowei
 * @date 2024/10/24
 * @description:
 */
@Component
public class ProductRepositoryImpl implements ProductRepository {

	@Autowired
	private ProductMapper productMapper;

	@Override
	public void save(Product product) {
		ProductEntity productEntity = convertToEntity(product);
		productMapper.insert(productEntity);
	}

	@Override
	public Product findById(Long productId) {
		ProductEntity productEntity = productMapper.selectById(productId);
		return convertToDomain(productEntity);
	}

	/**
	 * 领域对象转换实体类对象
	 * @param product
	 * @return
	 */
	private ProductEntity convertToEntity(Product product) {
		ProductEntity productEntity = new ProductEntity();
		productEntity.setId(product.getId());
		productEntity.setName(product.getName());
		productEntity.setDescription(product.getDescription());
		productEntity.setCategory(product.getCategory().getCategoryName());
		productEntity.setBasePrice(product.getBasePrice());
		productEntity.setDiscountPrice(product.getDiscountPrice());
		productEntity.setStatus(product.getProductStatus().name());
		productEntity.setCreateTime(new Date());
		productEntity.setUpdateTime(new Date());
		return productEntity;
	}

	/**
	 * 实体类对象转换领域对象
	 * @param productEntity
	 * @return
	 */
	private Product convertToDomain(ProductEntity productEntity) {
		Category category = new Category(productEntity.getCategory());
		Price price = new Price(new Money(productEntity.getBasePrice()), new Money(productEntity.getDiscountPrice()));
		Product product = new Product(productEntity.getId(),productEntity.getName(), productEntity.getDescription(), category, price,ProductStatus.valueOf(productEntity.getStatus()));
		return product;
	}


}
