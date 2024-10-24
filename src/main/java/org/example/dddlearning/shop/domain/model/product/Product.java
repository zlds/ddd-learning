package org.example.dddlearning.shop.domain.model.product;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: hanchaowei
 * @date 2024/10/24
 * @description: 商品
 */

public class Product {

	// 商品id
	private Long id;
	// 商品名称
	private String name;
	// 商品描述
	private String description;
	// 商品分类
	private Category category;
	// 商品价格
	private Price price;
	// 商品状态
	private ProductStatus productStatus;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;

	public Product(String name, String description, Category category, Price price,ProductStatus productStatus) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("商品名称不能为空");
		}
		this.name = name;
		this.description = description;
		this.category = category;
		this.price = price;
		this.productStatus = productStatus;
		this.createTime = new Date();
		this.updateTime = new Date();
	}

	public Product(Long id,String name, String description, Category category, Price price,ProductStatus productStatus) {
		if (id == null) {
			throw new IllegalArgumentException("商品ID不能为空");
		}
		this.id = id;
		this.name = name;
		this.description = description;
		this.category = category;
		this.price = price;
		this.productStatus = productStatus;
		this.createTime = new Date();
		this.updateTime = new Date();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Category getCategory() {
		return category;
	}

	public BigDecimal getBasePrice() {
		return price != null && price.getBasePrice() != null ? price.getBasePrice().getAmount() : null;
	}

	public BigDecimal getDiscountPrice() {
		return price != null && price.getDiscountPrice() != null ? price.getDiscountPrice().getAmount() : null;
	}

	public ProductStatus getProductStatus() {
		return productStatus;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}
}
