<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="Content-Style-Type" content="text/css"/>
    <title>账户账单</title>
    <style type="text/css">
        @page {
            size: A4;
        }

        body {
            margin: 0 auto;
            width: 100%;
            font-size: 10px;
            font-family: SimSun;
        }

        .left {
            float: left;
        }

        .right {
            float: right;
        }

        .div {
            font-weight: 700;
        }

        .ml {
            margin-left: 6%;
        }

        .clear {
            clear: both;
        }

        .width {
            width: 50%
        }

        .width1 {
            width: 40%
        }
    </style>
</head>
<body>
<img src="https://b2bvirtualcard.blob.core.chinacloudapi.cn/picturecard/28e60cff84a35372fe15ec3dcc6a4da3.jpg"
     style="width: 5%;margin-left: 3%;"/>
<div class="div" style="width: 100%;text-align: center;">账户账单</div>
<div class="left" style="width: 38%;">
    <div class="left div">客户信息</div>
    <div class="left clear" style="width: 100%;">
        <div class="left div">账户号码</div>
        <div class="left ml" style="width: auto;">${accountCode!}</div>
    </div>
    <div class="left clear" style="width: 100%;">
        <div class="left div">账户名称</div>
        <div class="left ml" style="width: auto;">${accountName!}</div>
    </div>
    <div class="left clear width">
        <div class="left div">客户地址</div>
        <div class="left" style="clear: both;">${postCode!}</div>
        <div class="left" style="clear: both;">${accountName!}</div>
        <div class="left" style="word-wrap: break-word; word-break: normal;clear: both;">${locationName!}</div>
        <div class="left" style="word-wrap: break-word; word-break: normal;clear: both;">${street!}</div>
    </div>
    <div class="left clear" style="margin-top: 4%;width: 100%;">
        <div class="left div">账单编号</div>
        <div class="left ml">${rptCreditBillId!}</div>
    </div>
    <div class="left clear" style="width: 100%;">
        <div class="left div">账单日期</div>
        <div class="left ml">${billDate!}</div>
    </div>
    <div class="left clear width" style="width: 100%;">
        <div class="left div">金额货币</div>
        <div class="left ml">CNY</div>
    </div>
</div>
<div class="right" style="width: 35%;margin-right: 25%;">
    <div class="right div width1">供应商</div>
    <div class="right clear width1">
        <div class="left div" style="word-wrap: break-word; word-break: normal;width: 200%;">${deptName!}</div>
        <div class="left clear" style="word-wrap: break-word; word-break: normal;width: 200%;">
            ${address!}
        </div>
        <div class="left clear">
            <div>Tel:${tel!}</div>
        </div>
    </div>
    <div class="right clear width1">
        <!-- 社会统一信用代码 -->
        <div class="left div">${registerNumberTitle!}</div>
        <div class="left ml">${registerNumber!}</div>
    </div>
    <div class="right clear div width1" style="margin-top: 6%;">如有任何疑问，请联系壳牌销售团队</div>
</div>
<div class="left clear" style="width: 100%;margin-top: 1%;">
    <p class="left" style="border: 1px solid black;width: 100%;margin: 8px 1px 0 1px"></p>
    <div class="left width1" style="width: 100%;">
        <div class="left" style="width: 10%;text-align: center;word-wrap: break-word; word-break: normal;">本期账单金额</div>
        <div class="left" style="width: 10%;text-align: center;word-wrap: break-word; word-break: normal;">到期付款日</div>
        <div class="left" style="width: 10%;text-align: center;word-wrap: break-word; word-break: normal;">付款期限</div>
        <div class="left" style="width: 10%;text-align: center;word-wrap: break-word; word-break: normal;">付款方式</div>
        <div class="left" style="width: 9%;text-align: center;word-wrap: break-word; word-break: normal;">本期还款</div>
        <div class="left" style="width: 11%;text-align: center;word-wrap: break-word; word-break: normal;">本期返利</div>
        <div class="left" style="width: 9%;text-align: center;word-wrap: break-word; word-break: normal;">本期消费实付</div>
        <div class="left" style="width: 11%;text-align: center;word-wrap: break-word; word-break: normal;">本期优惠分摊金额
        </div>
        <div class="left" style="width: 9%;text-align: center;word-wrap: break-word; word-break: normal;">本期可开票金额</div>
        <div class="left" style="width: 11%;text-align: center;word-wrap: break-word; word-break: normal;">上期应还款总额</div>
    </div>
    <div class="left width1" style="width: 100%;">
        <div class="left"
             style="width: 10%;text-align: center;word-wrap: break-word; word-break: normal;border-top: 0.1px solid;">${billAmount!}</div>
        <div class="left"
             style="width: 10%;text-align: center;word-wrap: break-word; word-break: normal;border-top: 0.1px solid;">${repaymentDate!}</div>
        <div class="left"
             style="width: 10%;text-align: center;word-wrap: break-word; word-break: normal;border-top: 0.1px solid;">${repaymentDays!}</div>
        <div class="left"
             style="width: 10%;text-align: center;word-wrap: break-word; word-break: normal;border-top: 0.1px solid;">
            电汇/其他
        </div>
        <div class="left"
             style="width: 9%;text-align: center;word-wrap: break-word; word-break: normal;border-top: 0.1px solid;">${repaymentAmount!}</div>
        <div class="left"
             style="width: 11%;text-align: center;word-wrap: break-word; word-break: normal;border-top: 0.1px solid;">${rebateAmount!}</div>
        <div class="left"
             style="width: 9%;text-align: center;word-wrap: break-word; word-break: normal;border-top: 0.1px solid;">${purchaseAmount!}</div>
        <div class="left"
             style="width: 11%;text-align: center;word-wrap: break-word; word-break: normal;border-top: 0.1px solid;">${discountAmount!}</div>
        <div class="left"
             style="width: 9%;text-align: center;word-wrap: break-word; word-break: normal;border-top: 0.1px solid;">${invoiceAmount!}</div>
        <div class="left"
             style="width: 11%;text-align: center;word-wrap: break-word; word-break: normal;border-top: 0.1px solid;">${preRepaymentTotalAmount!}</div>
    </div>
    <p class="left" style="border: 1px solid black;width: 100%;margin: 0 1px 8px 1px"></p>
</div>
<div class="left clear" style="margin-top: 2%;width: 30%;margin-right: 5%;">
    <p class="left clear" style="border: 1px solid black;margin: 8px 1px 0 1px;width: 100%;"></p>
    <div class="left clear div" style="text-align: center;width: 100%;">本期账单总计</div>
    <p class="left clear" style="border: 1px solid #ababab;margin: 0 1px 0 1px;width: 100%;"></p>
    <div class="left clear div" style="text-align: center;width: 100%;">${billAmount!}</div>
    <p class="left clear" style="border: 1px solid black;margin: 0 1px 8px 1px;width: 100%;"></p>
    <p class="left clear" style="border: 1px solid black;margin: 8px 1px 0 1px;width: 100%;"></p>
    <div class="left clear div " style="text-align: center;width: 100%;">逾期总计</div>
    <p class="left clear " style="border: 1px solid #ababab;margin: 0 1px 0 1px;width: 100%;"></p>
    <div class="left clear div" style="text-align: center;width: 100%;">${overdueAmount!}</div>
    <p class="left clear " style="border: 1px solid black;margin: 0 1px 8px 1px;width: 100%;"></p>
    <p class="left clear " style="border: 1px solid black;margin: 8px 1px 0 1px;width: 100%;"></p>
    <div class="left clear div " style="text-align: center;width: 100%;">未逾期总计（不含本期）</div>
    <p class="left clear " style="border: 1px solid #ababab;margin: 0 1px 0 1px;width: 100%;"></p>
    <div class="left clear div" style="text-align: center;width: 100%;">${notOverdueAmount!}</div>
    <p class="left clear " style="border: 1px solid black;margin: 0 1px 8px 1px;width: 100%;"></p>
    <p class="left clear " style="border: 1px solid black;margin: 8px 1px 0 1px;width: 100%;"></p>
    <div class="left clear div " style="text-align: center;width: 100%;">应还款总额</div>
    <p class="left clear " style="border: 1px solid #ababab;margin: 0 1px 0 1px;width: 100%;"></p>
    <div class="left clear div" style="text-align: center;width: 100%;">${repaymentTotalAmount!}</div>
    <p class="left clear " style="border: 1px solid black;margin: 0 1px 8px 1px;width: 100%;"></p>
</div>

<div class="right" style="width: 65%;margin-top: 3%;">
    <div class="div" style="border: 2px solid black;height: 4%;width: 95%;text-align: center;font-weight: 700;">付款信息
    </div>
    <div style="border: 2px solid black;height: 180px;width: 95%;text-align: center;">
        <div class="left div" style="text-align: left;float: left;">请在</div>
        <div style="color: red !important;float: left;">${billDate1!}</div>
        <div class="left div" style="float: left;">之前按上述付款方式付款</div>
        <div class="left clear" style="margin-top: 3%;width: 95%;">
            <div class="left">请付款至</div>
            <div class="left clear div" style="text-align: left;">${deptName!}</div>
        </div>
        <div class="left clear" style="width: 100%;">
            <div class="left clear" style="text-align: left;">银行及支行名称</div>
            <div class="left" style="text-align: center;margin-left: 5%;">${bankFleet!}</div>
        </div>
        <div class="left clear" style="width: 100%;">
            <div class="left clear" style="text-align: left;">银行账户</div>
            <div class="left" style="text-align: center;margin-left: 5%;">${bankAcctFleet!}</div>
        </div>
        <div class="left clear width">
            <div class="left"
                 style="word-wrap: break-word; word-break: normal;width: 200%;text-align: left">${address!}</div>
        </div>
        <div class="left clear width">
            <div class="left">邮编 ${deptPostCode!}</div>
        </div>
        <div class="left clear" style="width: 100%">
            <div style="text-align: center">${remark!}</div>
        </div>
    </div>
</div>
<div class="left clear" style="margin-top: 2%;width: 110%;">
    <div class="div" style="font-size: 20px;">本期账单详情:</div>
    <div class="clear" style="width: 100%;font-weight: 700;text-align: center">还款明细</div>
    <p class="left clear" style="border: 1px solid black;margin: 0px 1px 0 1px;width: 100%"></p>
    <div class="clear" style="width: 100%">
        <div class="left" style="width: 10%;text-align: center;font-weight: 700;">序号</div>
        <div class="left" style="width: 18%;text-align: center;font-weight: 700;">还款日期</div>
        <div class="left" style="width: 16%;text-align: center;font-weight: 700;">付款类型</div>
        <div class="left" style="width: 18%;text-align: center;font-weight: 700;">还款渠道</div>
        <div class="left" style="width: 18%;text-align: center;font-weight: 700;">还款金额</div>
        <div class="left" style="width: 12%;text-align: center;font-weight: 700;">状态</div>
    </div>
    <div class="clear" style="width: 100%">
        <#list repaymentDetailList! as item>
            <div class="clear" style="width: 100%;">
                <div class="left" style="width: 10%;text-align: center;border-top: 0.1px solid;">${item.id!}</div>
                <div class="left"
                     style="width: 18%;text-align: center;border-top: 0.1px solid;">${item.repaymentTime!}</div>
                <div class="left"
                     style="width: 16%;word-wrap: break-word; word-break: normal;text-align: center;border-top: 0.1px solid;">${item.repaymentTransType!}</div>
                <div class="left"
                     style="width: 18%;word-wrap: break-word; word-break: normal;text-align: center;border-top: 0.1px solid;">${item.repaymentChannel!}</div>
                <div class="left"
                     style="width: 18%;text-align: center;border-top: 0.1px solid;">${item.repaymentAmount!}</div>
                <div class="left" style="width: 12%;text-align: center;border-top: 0.1px solid;">${item.status!}</div>
            </div>
        </#list>
    </div>
    <div class="clear" style="border: 1px solid black;margin: 0px 1px 0 1px;width: 100%"></div>
    <div class="clear" style="width: 100%;font-weight: 700;text-align: center;margin-top: 8px">消费明细</div>
    <p class="left clear" style="border: 1px solid black;margin: 0px 1px 0 1px;width: 100%"></p>
    <div class="clear" style="width: 100%">
        <div class="left"
             style="width: 8%;text-align: center;font-weight: 500;word-wrap: break-word; word-break: normal;">卡号
        </div>
        <div class="left"
             style="width: 5%;text-align: center;font-weight: 500;word-wrap: break-word; word-break: normal;">车牌
        </div>
        <div class="left"
             style="width: 6%;text-align: center;font-weight: 500;word-wrap: break-word; word-break: normal;">持卡人
        </div>
        <div class="left"
             style="width: 8%;text-align: center;font-weight: 500;word-wrap: break-word; word-break: normal;">时间
        </div>
        <div class="left"
             style="width: 6%;text-align: center;font-weight: 500;word-wrap: break-word; word-break: normal;">产品
        </div>
        <div class="left"
             style="width: 8%;text-align: center;font-weight: 500;word-wrap: break-word; word-break: normal;">单价
        </div>
        <div class="left"
             style="width: 8%;text-align: center;font-weight: 500;word-wrap: break-word; word-break: normal;">数量
        </div>
        <div class="left"
             style="width: 8%;text-align: center;font-weight: 500;word-wrap: break-word; word-break: normal;">应付金额
        </div>
        <div class="left"
             style="width: 7%;text-align: center;font-weight: 500;word-wrap: break-word; word-break: normal;">消费折扣
        </div>
        <div class="left"
             style="width: 8%;text-align: center;font-weight: 500;word-wrap: break-word; word-break: normal;">实付金额
        </div>
        <div class="left"
             style="width: 7%;text-align: center;font-weight: 500;word-wrap: break-word; word-break: normal;">优惠分摊
        </div>
        <div class="left"
             style="width: 7%;text-align: center;font-weight: 500;word-wrap: break-word; word-break: normal;">油站
        </div>
        <div class="left"
             style="width: 6%;text-align: center;font-weight: 500;word-wrap: break-word; word-break: normal;">状态
        </div>
    </div>
    <div class="clear" style="width: 100%">
        <#list purchaseDetailList! as item>
            <div class="clear" style="width: 100%;">
                <div class="left"
                     style="width: 8%;text-align: center;border-top: 0.1px solid;word-wrap: break-word; word-break: normal;">${item.pan!}</div>
                <div class="left"
                     style="width: 5%;text-align: center;border-top: 0.1px solid;word-wrap: break-word; word-break: normal;">${item.license!}</div>
                <div class="left"
                     style="width: 6%;text-align: center;border-top: 0.1px solid;word-wrap: break-word; word-break: normal;">${item.holder!}</div>
                <div class="left"
                     style="width: 8%;text-align: center;border-top: 0.1px solid;word-wrap: break-word; word-break: normal;">${item.time!}</div>
                <div class="left"
                     style="width: 6%;text-align: center;border-top: 0.1px solid;word-wrap: break-word; word-break: normal;">${item.productName!}</div>
                <div class="left"
                     style="width: 8%;text-align: center;border-top: 0.1px solid;word-wrap: break-word; word-break: normal;">${item.productPrice!}</div>
                <div class="left"
                     style="width: 8%;text-align: center;border-top: 0.1px solid;word-wrap: break-word; word-break: normal;">${item.quantity!}</div>
                <div class="left"
                     style="width: 8%;text-align: center;border-top: 0.1px solid;word-wrap: break-word; word-break: normal;">${item.payAmount!}</div>
                <div class="left"
                     style="width: 7%;text-align: center;border-top: 0.1px solid;word-wrap: break-word; word-break: normal;">${item.purchaseDiscount!}</div>
                <div class="left"
                     style="width: 8%;text-align: center;border-top: 0.1px solid;word-wrap: break-word; word-break: normal;">${item.actualAmount!}</div>
                <div class="left"
                     style="width: 7%;text-align: center;border-top: 0.1px solid;word-wrap: break-word; word-break: normal;">${item.preferential!}</div>
                <div class="left"
                     style="width: 7%;text-align: center;border-top: 0.1px solid;word-wrap: break-word; word-break: normal;">${item.siteName!}</div>
                <div class="left"
                     style="width: 6%;text-align: center;border-top: 0.1px solid;word-wrap: break-word; word-break: normal;">${item.status!}</div>
            </div>
        </#list>
    </div>
    <div class="clear" style="border: 1px solid black;margin: 0px 1px 0 1px;width: 100%"></div>
    <div class="clear" style="width: 65.5%;font-weight: 700;text-align: center;margin-top: 8px">消费汇总</div>
    <p class="left clear" style="border: 1px solid black;margin: 0px 1px 0 1px;width: 65.5%"></p>
    <div class="clear" style="width: 80%">
        <div class="left" style="width: 20%;text-align: center;font-weight: 500;">油站</div>
        <div class="left" style="width: 25%;text-align: center;font-weight: 500;">产品</div>
        <div class="left" style="width: 15%;text-align: center;font-weight: 500;">数量</div>
        <div class="left" style="width: 22%;text-align: center;font-weight: 500;">实付金额</div>
    </div>
    <div class="clear" style="width: 80%">
        <#list purchaseGroup! as item>
            <div class="clear" style="width: 100%;">
                <div class="left"
                     style="width: 20%;text-align: center;border-top: 0.1px solid;word-wrap: break-word; word-break: normal;">${item.siteName!}</div>
                <div class="left"
                     style="width: 25%;text-align: center;border-top: 0.1px solid;word-wrap: break-word; word-break: normal;">${item.productName!}</div>
                <div class="left"
                     style="width: 15%;text-align: center;border-top: 0.1px solid;word-wrap: break-word; word-break: normal;">${item.quantity!}</div>
                <div class="left"
                     style="width: 22%;text-align: center;border-top: 0.1px solid;word-wrap: break-word; word-break: normal;">${item.actualAmount!}</div>
            </div>
        </#list>
    </div>
    <div class="clear" style="border: 1px solid black;margin: 0px 1px 0 1px;width: 65.5%"></div>
    <div class="clear" style="width: 100%;font-weight: 700;text-align: center;margin-top: 8px">其它类型明细</div>
    <p class="left clear" style="border: 1px solid black;margin: 0px 1px 0 1px;width: 100%"></p>
    <div class="clear" style="width: 100%">
        <div class="left" style="width: 18%;text-align: center;font-weight: 500;">序号</div>
        <div class="left" style="width: 18%;text-align: center;font-weight: 500;">时间</div>
        <div class="left" style="width: 15%;text-align: center;font-weight: 500;">交易类型</div>
        <div class="left" style="width: 20%;text-align: center;font-weight: 500;">金额</div>
        <div class="left" style="width: 22%;text-align: center;font-weight: 500;">备注</div>
    </div>
    <div class="clear" style="width: 100%">
        <#list otherDetailList! as item>
            <div class="clear" style="width: 100%;">
                <div class="left"
                     style="width: 18%;text-align: center;border-top: 0.1px solid;word-wrap: break-word; word-break: normal;">${item.id!}</div>
                <div class="left"
                     style="width: 18%;text-align: center;border-top: 0.1px solid;word-wrap: break-word; word-break: normal;">${item.time!}</div>
                <div class="left"
                     style="width: 15%;text-align: center;border-top: 0.1px solid;word-wrap: break-word; word-break: normal;">${item.transType!}</div>
                <div class="left"
                     style="width: 20%;text-align: center;border-top: 0.1px solid;word-wrap: break-word; word-break: normal;">${item.amount!}</div>
                <div class="left"
                     style="width: 20%;text-align: center;border-top: 0.1px solid;word-wrap: break-word; word-break: normal;">${item.remark!}</div>
            </div>
        </#list>
    </div>
    <div class="clear" style="border: 1px solid black;margin: 0px 1px 0 1px;width: 100%"></div>
</div>
</body>
</html>