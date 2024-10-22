package org.example.dddlearning.shop.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.dddlearning.shop.infrastructure.entity.OrderItemEntity;

/**
 * @author: hanchaowei
 * @date 2024/10/17
 * @description:
 */
@Mapper
public interface OrderItemMapper extends BaseMapper<OrderItemEntity> {

	@Select("SELECT * FROM order_item WHERE id = #{orderItemId}")
	OrderItemEntity findById(Long orderItemId);


}
