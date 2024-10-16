package org.example.dddlearning.infrastructure.repository.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;

/**
 * @author: hanchaowei
 * @date 2024/10/15
 * @description:
 */
@TableName("account")
public class AccountEntity {

	// id 自增
	@TableId(type = IdType.AUTO)
	private Long id;

	private BigDecimal balance;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
}
