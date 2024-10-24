package org.example.dddlearning.shop.application.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: hanchaowei
 * @date 2024/10/24
 * @description:
 */
@Data
public class ProductDTO {
	// 商品id
	private Long id;
	// 商品名称
	private String productName;
	// 商品描述
	private String description;
	// 商品价格
	private BigDecimal basePrice;
	// 折扣价格
	private BigDecimal discountPrice;
	// 商品库存
	private int stock;
	// 商品分类
	private String category;
	// 商品状态
	private String status;


}
