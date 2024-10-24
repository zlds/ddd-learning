package org.example.dddlearning.shop.application.service;

import org.example.dddlearning.shop.application.dto.ProductDTO;
import org.example.dddlearning.shop.domain.model.product.*;
import org.example.dddlearning.shop.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: hanchaowei
 * @date 2024/10/24
 * @description:
 */
@Service
public class ProductApplicationService {

	@Autowired
	private ProductService productService;


	/**
	 * 创建商品
	 * @param productDTO
	 */
	public void createProduct(ProductDTO productDTO) {
		Product product = toProduct(productDTO);
		productService.saveProduct(product);
	}

	/**
	 * 商品详情
	 * @param productId
	 * @return
	 */
	public ProductDTO detail(Long productId) {
		Product product = productService.findProductById(productId);
		return toProductDTO(product);
	}

	// DTO 转换领域对象
	private Product toProduct(ProductDTO productDTO) {
		Category category = new Category(productDTO.getCategory());
		Price price = new Price(new Money(productDTO.getBasePrice()),new Money(productDTO.getDiscountPrice()));
		return new Product(productDTO.getProductName(), productDTO.getDescription(), category,price, ProductStatus.valueOf(productDTO.getStatus()));
	}

	// 领域对象转换DTO
	private ProductDTO toProductDTO(Product product) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setProductName(product.getName());
		productDTO.setDescription(product.getDescription());
		productDTO.setCategory(product.getCategory().getCategoryName());
		productDTO.setBasePrice(product.getBasePrice());
		productDTO.setDiscountPrice(product.getDiscountPrice());
		productDTO.setStatus(product.getProductStatus().name());
		return productDTO;
	}


}
