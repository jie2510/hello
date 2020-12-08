package com.example.mybatisplusatuo2.com.service;

import com.example.mybatisplusatuo2.com.entity.Customers;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisplusatuo2.com.mapper.CustomersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * <p>
 * 客户数据 服务类
 * </p>
 *
 * @author yujie
 * @since 2020-12-07
 */
public interface ICustomersService extends IService<Customers> {



    public int delete(@PathVariable int customerNumber);
    public int insert(Customers customers);
    public int update(Customers customers);
    public List<Customers> selectAll();
//    public List<Customers> selectByID(@PathVariable int customerNumber);
    public Customers selectByID(@PathVariable int customerNumber);
}
