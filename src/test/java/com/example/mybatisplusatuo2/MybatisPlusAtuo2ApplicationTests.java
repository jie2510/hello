package com.example.mybatisplusatuo2;

import com.example.mybatisplusatuo2.com.controller.CustomersController;
import com.example.mybatisplusatuo2.com.entity.Customers;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import sun.awt.geom.AreaOp;

import java.net.URL;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MybatisPlusAtuo2ApplicationTests {

//    /** 获取随机端口 */
//    @LocalServerPort
//    private int port;
//    private URL base;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CustomersController customersController;

    @Before
    public void Before() {
        System.out.println("=========before=========");

    }

    @After
    public void After() {
        System.out.println("--------after-----------");
    }

    @Test
    public void selectAll() {
        List<Customers> customers = customersController.selectAll();
//        customers.forEach(customers1 -> System.out.println("customer="+customers));

    }

}
