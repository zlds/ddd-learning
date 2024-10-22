package org.example.dddlearning.shop.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.dddlearning.shop.infrastructure.entity.OrderEntity;

/**
 * @author: hanchaowei
 * @date 2024/10/17
 * @description:
 */
@Mapper
public interface OrderMapper extends BaseMapper<OrderEntity> {

	@Select("SELECT * FROM orders WHERE id = #{orderId}")
	OrderEntity findById(@Param("orderId") Long orderId);

}
