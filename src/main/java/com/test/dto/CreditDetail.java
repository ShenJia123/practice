package com.test.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreditDetail {
    //日期 //时间
    private String date;
    //油站名称代码
    private String siteName;
    //产品
    private String productName;
    //数量
    private BigDecimal quantity;
    //单位
    private String productUnit;
    //总金额
    private BigDecimal transAmount;

    private String day;

    private String time;


}
