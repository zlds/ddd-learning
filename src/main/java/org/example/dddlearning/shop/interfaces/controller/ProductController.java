package org.example.dddlearning.shop.interfaces.controller;

import org.example.dddlearning.shop.application.dto.ProductDTO;
import org.example.dddlearning.shop.application.service.ProductApplicationService;
import org.example.dddlearning.shop.converter.ProductConverter;
import org.example.dddlearning.shop.interfaces.request.ProductRequest;
import org.example.dddlearning.shop.interfaces.vo.ProductDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: hanchaowei
 * @date 2024/10/24
 * @description:
 */
@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductApplicationService productApplicationService;


	/**
	 * 创建商品
	 * @param productRequest
	 * @return
	 */
	@PostMapping("/create")
	public String createProduct(@RequestBody ProductRequest productRequest) {
		ProductDTO productDTO = ProductConverter.toDTO(productRequest);
		productApplicationService.createProduct(productDTO);
		return "商品创建成功";
	}

	/**
	 * 商品详情
	 * @param productId
	 * @return
	 */
	@RequestMapping("/detail")
	public ProductDetailVO detail(Long productId) {
		ProductDTO productDTO = productApplicationService.detail(productId);
		return ProductConverter.toVO(productDTO);
	}


}
