package org.example.dddlearning.infrastructure.repository.mapper;

import org.apache.ibatis.annotations.*;
import org.example.dddlearning.infrastructure.repository.entity.AccountEntity;

/**
 * @author: hanchaowei
 * @date 2024/10/15
 * @description:
 */
@Mapper
public interface  AccountMapper {

	@Select("SELECT * FROM account WHERE id = #{accountId}")
	AccountEntity findById(@Param("accountId") Long accountId);

	@Insert("INSERT INTO account (id,balance) VALUES (#{id},#{balance})")
	void insert(AccountEntity accountEntity);

	@Update("UPDATE account SET balance = #{balance} WHERE id = #{id}")
	void update(AccountEntity accountEntity);

}
