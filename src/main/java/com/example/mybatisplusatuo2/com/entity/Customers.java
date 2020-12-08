package com.example.mybatisplusatuo2.com.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 客户数据
 * </p>
 *
 * @author yujie
 * @since 2020-12-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Customers implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 客户编号
     */
    @TableId("customerNumber")
    private Integer customerNumber;

    /**
     * 客户名
     */
    @TableField("customerName")
    private String customerName;

    /**
     * 联系人姓
     */
    @TableField("contactLastName")
    private String contactLastName;

    /**
     * 联系人名
     */
    @TableField("contactFirstName")
    private String contactFirstName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 地址1
     */
    @TableField("addressLine1")
    private String addressLine1;

    /**
     * 地址2
     */
    @TableField("addressLine2")
    private String addressLine2;

    /**
     * 城市
     */
    private String city;

    /**
     * 州
     */
    private String state;

    /**
     * 邮编
     */
    @TableField("postalCode")
    private String postalCode;

    /**
     * 国家
     */
    private String country;

    @TableField("salesRepEmployeeNumber")
    private Integer salesRepEmployeeNumber;

    @TableField("creditLimit")
    private BigDecimal creditLimit;


}
