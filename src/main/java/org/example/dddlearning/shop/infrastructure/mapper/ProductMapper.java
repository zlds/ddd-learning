package org.example.dddlearning.shop.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.dddlearning.shop.infrastructure.entity.ProductEntity;

/**
 * @author: hanchaowei
 * @date 2024/10/24
 * @description:
 */
@Mapper
public interface ProductMapper extends BaseMapper<ProductEntity> {
}
