package org.example.dddlearning.transfer.domain.repository;


import org.example.dddlearning.transfer.domain.model.TransferAuditRecord;

/**
 * @author: hanchaowei
 * @date 2024/10/13
 * @description: 转账审计仓储接口
 */

public interface TransferAuditRepository {
	void save(TransferAuditRecord transferAuditRecord);
}
