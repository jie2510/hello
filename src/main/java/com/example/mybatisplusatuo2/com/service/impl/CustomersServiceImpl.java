package com.example.mybatisplusatuo2.com.service.impl;

import com.example.mybatisplusatuo2.com.entity.Customers;
import com.example.mybatisplusatuo2.com.mapper.CustomersMapper;
import com.example.mybatisplusatuo2.com.service.ICustomersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 客户数据 服务实现类
 * </p>
 *
 * @author yujie
 * @since 2020-12-07
 */
@Service
public class CustomersServiceImpl extends ServiceImpl<CustomersMapper, Customers> implements ICustomersService {

    @Autowired
    private CustomersMapper customersMapper;
    @Override
    public int delete(int customerNumber) {
        return customersMapper.deleteById(customerNumber);
    }

    @Override
    public int insert(Customers customers) {
        return customersMapper.insert(customers);

    }

    @Override
    public int update(Customers customers) {
        Customers customers1 = customersMapper.selectById(customers);
        customers1.setCity("city");
        return customersMapper.updateById(customers);
    }

    @Override
    public List<Customers> selectAll() {
        return customersMapper.selectList(null);
    }

    @Override
    public Customers selectByID(int customerNumber) {
        Customers customers =customersMapper.selectById(customerNumber);
        return customers;
    }

//    @Override
//    public List<Customers> selectByID(int customerNumber) {
//
//        customersMapper.selectById(customerNumber);
//        return customersMapper.selectList(null);
//    }
}
