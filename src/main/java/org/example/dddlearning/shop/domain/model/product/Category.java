package org.example.dddlearning.shop.domain.model.product;

/**
 * @author: hanchaowei
 * @date 2024/10/24
 * @description: 商品类别
 */

public class Category {

	private String categoryName;

	public Category(String categoryName) {
		if (categoryName == null || categoryName.isEmpty()) {
			throw  new IllegalArgumentException("商品类别不能为空");
		}
		this.categoryName = categoryName;
	}

	public String getCategoryName() {
		return categoryName;
	}
}
