package com.example.entity;

import lombok.Data;

/**
 * 商家
 */
@Data
public class Business extends Account {

    /**
     * 主键
     */
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    private String password;
    private String name;
    private String avatar;
    private String role;
    private String phone;
    private String info;
    private String address;
    private String license;
    private String status;
    private String timeRange;
    private String type;
    private Double score;
    private Boolean isCollect;

    private String weeklyDeliveryTime;
    private String deliveryTimeWindow;
    // 总销售数量
    private Integer nums;


}
