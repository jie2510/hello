package com.example.mybatisplusatuo2.com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisplusatuo2.com.entity.Customers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static javafx.scene.input.KeyCode.M;
import static org.junit.jupiter.api.Assertions.*;

// 获取启动类，加载配置，确定装载 Spring 程序的装载方法，它回去寻找 主配置启动类（被 @SpringBootApplication 注解的）
@SpringBootTest
// 让 JUnit 运行 Spring 的测试环境， 获得 Spring 环境的上下文的支持
@RunWith(SpringRunner.class)
class CustomersServiceImplTest {

    @Autowired
    private CustomersServiceImpl customersServiceImpl;

    @BeforeEach
    void setUp() {
        System.out.println("=========before=========");

    }

    @AfterEach
    void tearDown() {
        System.out.println("--------after-----------");
    }



    @Test
    void delete() {
        int rows = customersServiceImpl.delete(1002);
        System.out.println("删除的条数为:" + rows);
    }

    @Test
    void insert() {
        Customers customers=new Customers();
        customers.setCity("fvd");
        customers.setAddressLine1("vSpiker ");
        customers.setAddressLine2("dfsdf");
        customers.setContactFirstName("ujisdo");
        customers.setCustomerName("jfk");
        customers.setCustomerNumber(1326);
        customers.setContactLastName("fdvv");
        customers.setPhone("5255555");
        customers.setCity("英德");
        customers.setState("vds");
        customers.setPostalCode("jkfsdsd");
        customers.setCountry("dfdsf");
        customers.setSalesRepEmployeeNumber(1188);
        customers.setCreditLimit(new BigDecimal(123));


        int rows = customersServiceImpl.insert(customers);
        System.out.println("插入的条数为:" + rows);

    }

    @Test
    void update() {

        Customers customers=new Customers();
        customers.setCustomerNumber(103);
        customers.setCity("清远");
        int rows = customersServiceImpl.update(customers);
        System.out.println("更改的条数为:" + rows);
    }

    @Test
    void selectAll() {
        List<Customers> customersList = customersServiceImpl.selectAll();
        System.out.println(customersList);


    }

    @Test
    void selectByID() {
        Customers customers = customersServiceImpl.selectByID(103);
        System.out.println(customers);
    }
}