package com.example.mybatisplusatuo2.com.mapper;

import com.example.mybatisplusatuo2.com.entity.Customers;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 客户数据 Mapper 接口
 * </p>
 *
 * @author yujie
 * @since 2020-12-07
 */
@Mapper
@Component
public interface CustomersMapper extends BaseMapper<Customers> {

}
