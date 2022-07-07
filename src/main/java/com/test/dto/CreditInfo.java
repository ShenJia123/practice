package com.test.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CreditInfo {
    //客户信息
    //账户号码
    private String accountCode;
    //账户名称
    private String accountName;
    //客户等级
    private Integer customerBand;
    //客户地址
    //邮编
    private String postCode;
    //城市地址 中国湖北省 荆门市 京山市
    private String locationName;
    //街道 新市镇城阪路 19号
    private String street;

    //账单编号
    private String rptCreditBillId;
    //账单日期
    private String billDate;

    //供应商
    //账户所属机构名称
    private String deptName;
    //地址
    private String address;
    //电话
    private String tel;
    //邮编
    private String deptPostCode;
    //银行及支行名称
    private String bankFleet;
    //银行账号
    private String bankAcctFleet;


    //金额信息
    //本期金额 当前总额 本期账单总计
    private BigDecimal billAmount;
    //到期付款日
    private String repaymentDate;
    //付款期限
    private String repaymentDays;

    //逾期总数
    private BigDecimal overdueAmount;
    //未逾期总数不包含本月
    private BigDecimal notOverdueAmount;
    //应还款总额
    private BigDecimal repaymentTotalAmount;

    //临时变量（和报告文件无关） 需要还的真实金额（可能为负数）
    private BigDecimal repaymentAmount;


}
