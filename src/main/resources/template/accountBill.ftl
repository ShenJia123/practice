<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="Content-Style-Type" content="text/css"/>
    <title>账户账单</title>
    <style type="text/css">
        body {
            margin: 0 auto;
            width: 100%;
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
    <div class="left clear width">
        <div class="left div">金额货币</div>
        <div class="left ml">CNY</div>
    </div>
</div>
<div class="right" style="width: 35%;margin-right: 25%;">
    <div class="right div width1">供应商</div>
    <div class="right clear width1">
        <div class="left div">${deptName!}</div>
        <div class="left clear" style="word-wrap: break-word; word-break: normal;width: 200%;">
            ${address!}
        </div>
        <div class="left clear">${tel!}</div>
    </div>
    <#--  <div class="right clear width1">
          <div class="left div">社会统一信用代码</div>
          <div class="left ml">12312312321</div>
      </div>-->
    <div class="right clear div width1" style="margin-top: 6%;">如有任何疑问，请联系壳牌销售团队</div>
</div>
<div class="left clear" style="width: 100%;margin-top: 1%;">
    <p class="left" style="border: 1px solid black;width: 85%;margin: 8px 1px 0 1px"></p>
    <div class="left width1" style="width: 100%;">
        <div class="left" style="width: 20%;text-align: center;">本期金额</div>
        <div class="left" style="width: 20%;text-align: center;">到期付款日</div>
        <div class="left" style="width: 20%;text-align: center;">付款期限</div>
        <div class="left" style="width: 20%;text-align: center;">付款方式</div>
    </div>
    <div class="left width1" style="width: 100%;">
        <div class="left" style="width: 20%;text-align: center;">${billAmount!}</div>
        <div class="left" style="width: 20%;text-align: center;">${repaymentDate!}</div>
        <div class="left" style="width: 20%;text-align: center;">${repaymentDays!}</div>
        <div class="left" style="width: 20%;text-align: center;">电汇/其他</div>
    </div>
    <p class="left" style="border: 1px solid black;width: 85%;margin: 0 1px 8px 1px"></p>
</div>
<div class="clear left width">
    <p class="left" style="border: 1px solid black;margin: 8px 1px 0 1px;width: 60%;"></p>
    <div class="left clear width">
        <div class="left" style="width: 30%;text-align: center;margin-left: 5%;">当前总额</div>
        <div class="left" style="width: 30%;text-align: center;">CNY</div>
        <div class="left" style="width: 30%;text-align: center;">${billAmount!}</div>
    </div>
    <p class="left width clear" style="border: 1px solid black;margin: 0 1px 8px 1px;width: 60%;"></p>
</div>
<div class="left clear" style="margin-top: 2%;width: 30%;">
    <p class="left clear" style="border: 1px solid black;margin: 8px 1px 0 1px;width: 100%;"></p>
    <div class="left clear div" style="text-align: center;width: 100%;">本期账单总计</div>
    <p class="left clear" style="border: 1px solid #ababab;margin: 0 1px 0 1px;width: 100%;"></p>
    <div class="left clear" style="text-align: center;width: 100%;">${billAmount!}</div>
    <p class="left clear" style="border: 1px solid black;margin: 0 1px 8px 1px;width: 100%;"></p>
    <p class="left clear" style="border: 1px solid black;margin: 8px 1px 0 1px;width: 100%;"></p>
    <div class="left clear div " style="text-align: center;width: 100%;">逾期总计</div>
    <p class="left clear " style="border: 1px solid #ababab;margin: 0 1px 0 1px;width: 100%;"></p>
    <div class="left clear " style="text-align: center;width: 100%;">${overdueAmount!}</div>
    <p class="left clear " style="border: 1px solid black;margin: 0 1px 8px 1px;width: 100%;"></p>
    <p class="left clear " style="border: 1px solid black;margin: 8px 1px 0 1px;width: 100%;"></p>
    <div class="left clear div " style="text-align: center;width: 100%;">未逾期总计（不含本月）</div>
    <p class="left clear " style="border: 1px solid #ababab;margin: 0 1px 0 1px;width: 100%;"></p>
    <div class="left clear " style="text-align: center;width: 100%;">${notOverdueAmount!}</div>
    <p class="left clear " style="border: 1px solid black;margin: 0 1px 8px 1px;width: 100%;"></p>
    <p class="left clear " style="border: 1px solid black;margin: 8px 1px 0 1px;width: 100%;"></p>
    <div class="left clear div " style="text-align: center;width: 100%;">应还款总额</div>
    <p class="left clear " style="border: 1px solid #ababab;margin: 0 1px 0 1px;width: 100%;"></p>
    <div class="left clear " style="text-align: center;width: 100%;">${repaymentTotalAmount!}</div>
    <p class="left clear " style="border: 1px solid black;margin: 0 1px 8px 1px;width: 100%;"></p>
</div>
<div class="right" style="margin-right: 8%;width: 60%;">
    <div class="div" style="border: 2px solid black;height: 4%;width: 90%;text-align: center;">付款信息</div>
    <div style="border: 2px solid black;height: 240px;width: 90%;text-align: center;">
        <div class="left div" style="text-align: left;">请在<label style="color:red;">${billDate1!}</label>之前按上述付款方式付款
        </div>
        <div class="left clear" style="margin-top: 3%;width: 90%;">
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
            <div class="left" style="word-wrap: break-word; word-break: normal;width: 200%;">${address!}</div>
        </div>
        <div class="left clear width">
            <div class="left">邮编 ${deptPostCode!}</div>
        </div>
        <div class="left width clear">
            <div class="left" style="margin-top: 30%;">备注请注明，加油款还款</div>
        </div>
    </div>
</div>
<div class="left clear" style="margin-top: 2%;width: 100%;">
    <div class="div" style="font-size: 20px;">本期账单详情:</div>
    <p class="left clear" style="border: 1px solid black;margin: 8px 1px 0 1px;width: 90%"></p>
    <table style="width: 90%;margin-top: 2%;">
        <thead>
        <tr>
            <th>日期</th>
            <th>时间</th>
            <th>油站名称/代码</th>
            <th>产品</th>
            <th>数量</th>
            <th>单位</th>
            <th>总金额</th>
        </tr>
        </thead>
        <tbody>
        <#list list as item>
            <tr>
                <td>${item.date!}</td>
                <td>${item.date!}</td>
                <td>${item.siteName!}</td>
                <td>${item.productName!}</td>
                <td>${item.quantity!}</td>
                <td>${item.productUnit!}</td>
                <td>${item.transAmount!}</td>
            </tr>
        </#list>
        </tbody>
    </table>
    <p class="left clear" style="border: 1px solid #ababab;margin: 0 1px 0 1px;width: 90%;"></p>
    <div class="left clear" style="width: 90%;">
        <div class="left" style="text-align: right;width: 40%;">总金额</div>
        <div class="left width" style="text-align: right;">${sumAmount}</div>
    </div>
    <p class="left clear" style="border: 1px solid black;margin: 0 1px 8px 1px;width: 90%;"></p>
</div>
</body>
</html>