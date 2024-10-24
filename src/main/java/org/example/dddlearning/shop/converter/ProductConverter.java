package org.example.dddlearning.shop.converter;

import org.example.dddlearning.shop.application.dto.ProductDTO;
import org.example.dddlearning.shop.interfaces.request.ProductRequest;
import org.example.dddlearning.shop.interfaces.vo.ProductDetailVO;

import java.math.BigDecimal;

/**
 * @author: hanchaowei
 * @date 2024/10/24
 * @description:
 */

public class ProductConverter {

	public static ProductDTO toDTO(ProductRequest request) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductName(request.getProductName());
		productDTO.setDescription(request.getDescription());
		productDTO.setBasePrice(new BigDecimal(request.getBasePrice()));
		productDTO.setDiscountPrice(new BigDecimal(request.getDiscountPrice()));
		productDTO.setStock(Integer.parseInt(request.getStock()));
		productDTO.setCategory(request.getCategory());
		productDTO.setStatus(request.getStatus());
		return productDTO;
	}

	public static ProductDetailVO toVO(ProductDTO productDTO) {
		ProductDetailVO productDetailVO = new ProductDetailVO();
		productDetailVO.setProductId(productDTO.getId());
		productDetailVO.setProductName(productDTO.getProductName());
		productDetailVO.setDescription(productDTO.getDescription());
		productDetailVO.setBasePrice(String.valueOf(productDTO.getBasePrice()));
		productDetailVO.setDiscountPrice(String.valueOf(productDTO.getDiscountPrice()));
		productDetailVO.setStock(String.valueOf(productDTO.getStock()));
		productDetailVO.setCategory(productDTO.getCategory());
		productDetailVO.setStatus(productDTO.getStatus());
		return productDetailVO;
	}
}
