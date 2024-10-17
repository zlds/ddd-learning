package org.example.dddlearning.transfer.infrastructure.repository.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.example.dddlearning.transfer.infrastructure.repository.entity.TransferAuditEntity;

/**
 * @author: hanchaowei
 * @date 2024/10/16
 * @description:
 */
@Mapper
public interface TransferAuditMapper {

	@Insert("INSERT INTO transfer_audit (from_account_id,to_account_id,amount,create_time) VALUES (#{fromAccountId},#{toAccountId},#{amount},#{createTime})")
	void insert(TransferAuditEntity transferAuditEntity);
}
