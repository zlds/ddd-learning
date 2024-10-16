package org.example.dddlearning.infrastructure.repository;

import org.example.dddlearning.domain.model.TransferAuditRecord;
import org.example.dddlearning.domain.repository.TransferAuditRepository;
import org.example.dddlearning.infrastructure.repository.entity.TransferAuditEntity;
import org.example.dddlearning.infrastructure.repository.mapper.TransferAuditMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author: hanchaowei
 * @date 2024/10/13
 * @description:
 */
@Component
public class TransferAuditRepositoryImpl implements TransferAuditRepository {

	@Autowired
	private TransferAuditMapper transferAuditMapper;

	@Override
	public void save(TransferAuditRecord transferAuditRecord) {
		transferAuditMapper.insert(mapToEntity(transferAuditRecord));
	}

	// 实体转换
	private TransferAuditEntity mapToEntity(TransferAuditRecord entity) {
		TransferAuditEntity transferAuditEntity = new TransferAuditEntity();
		transferAuditEntity.setId(entity.getId());
		transferAuditEntity.setFromAccountId(entity.getFromAccountId());
		transferAuditEntity.setToAccountId(entity.getToAccountId());
		transferAuditEntity.setAmount(entity.getAmount().getAmount());
		transferAuditEntity.setCreateTime(new Date());
		return transferAuditEntity;
	}
}
