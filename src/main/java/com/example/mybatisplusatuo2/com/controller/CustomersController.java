package com.example.mybatisplusatuo2.com.controller;


import com.example.mybatisplusatuo2.com.entity.Customers;
import com.example.mybatisplusatuo2.com.mapper.CustomersMapper;
import com.example.mybatisplusatuo2.com.service.impl.CustomersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.element.VariableElement;
import java.util.List;

/**
 * <p>
 * 客户数据 前端控制器
 * </p>
 *
 * @author yujie
 * @since 2020-12-07
 */
@RestController
@RequestMapping("/com/customers")
public class CustomersController {
    @Autowired
    private CustomersServiceImpl customersServiceImpl;

    @GetMapping("/delete/{customerNumber}")
    public List<Customers> delete(@PathVariable int customerNumber){
        customersServiceImpl.delete(customerNumber);
        return customersServiceImpl.selectAll();
    }



    @PostMapping("/insert")
    public  List<Customers> insert(Customers customers){
        customersServiceImpl.insert(customers);
        return customersServiceImpl.selectAll();
    }

    @PostMapping("/update")
    public List<Customers> update(Customers customers){
        customersServiceImpl.updateById(customers);
        return customersServiceImpl.selectAll();

    }




    @GetMapping("/selectAll")
    public List<Customers> selectAll(){
        return customersServiceImpl.selectAll();
    }



    @RequestMapping(value = {"/selectByID/{customerNumber}"}, method = RequestMethod.GET)
    public Customers selectByID(@PathVariable int customerNumber) {
        return customersServiceImpl.selectByID(customerNumber);
    }





}
