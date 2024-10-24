package org.example.dddlearning.shop.interfaces.vo;

import lombok.Data;

/**
 * @author: hanchaowei
 * @date 2024/10/24
 * @description:
 */
@Data
public class ProductDetailVO {

	private Long productId;
	// 商品名称
	private String productName;
	// 商品描述
	private String description;
	// 商品价格
	private String basePrice;
	// 折扣价格
	private String discountPrice;
	// 商品库存
	private String stock;
	// 商品分类
	private String category;
	// 商品状态
	private String status;
}
