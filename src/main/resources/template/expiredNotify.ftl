<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="Content-Style-Type" content="text/css"/>
    <title>逾期未付款通知</title>
    <style type="text/css">
        body {
            margin: 0 auto;
            width: 98%;
            font-family: SimSun;
        }

        .div1 {
            width: 49%;
        }

        .width1 {
            width: 100%;
        }

        .m1 {
            margin-top: 20%;
        }

        .ml1 {
            margin-left: 5%;
        }

        .mt1 {
            margin-top: 11%;
        }

        .left {
            float: left;
        }

        .right {
            float: right;
        }

        .div2 {
            border: 2px solid black;
            height: auto;
            width: 100%;
            margin-top: 18%;
        }

        .clear {
            clear: both;
        }
    </style>
</head>
<body>
<img src="https://b2bvirtualcard.blob.core.chinacloudapi.cn/picturecard/28e60cff84a35372fe15ec3dcc6a4da3.jpg"
     style="width: 7%;;" class="left"/>
<div class="left div1 clear" style="margin-top: 10%;">
    <div style="font-weight: 700;">${customer.postCode!}</div>
    <div>${customer.customerName!}</div>
    <div style="width: 300px;word-wrap: break-word; word-break: normal;">${customer.contactAddress!}</div>
    <div>${customer.address!}</div>
    <div>
        <div class="left">统一社会信用代码</div>
        <div class="left ml1" style="font-weight: 700;">${customer.registerNumber!}</div>
    </div>

</div>
<div class="right div1" style="margin-top: 5%;">
    <div style="font-weight: 700;">${dept.deptName!}</div>
    <div>${dept.address!}</div>
    <div>${dept.tel!}</div>
    <!--  <div class="left" style="width: 100%;">
          <div class="left">统一社会信用代码</div>
          <div class="left" style="margin-left: 5%">91441900684487322B</div>
      </div>-->
    <div class="left" style="font-weight: 700;">如有任何疑问，请联系壳牌客服</div>

    <div class="left div2">
        <div style="font-weight: 700;">请参考以下信息付款</div>
        <div>
            <div class="left" style="font-weight: 700;">客户编码</div>
            <div class="right" style="font-weight: 700;">${accountCode!}</div>
        </div>
        <div class="clear">
            <div class="left" style="font-weight: 700;">结单编码</div>
            <div class="right" style="font-weight: 700;">${billId!}</div>
        </div>
    </div>
</div>
<div style="margin-bottom: 3%;" class="left clear">
    <div class="left">
        <label class="left" style="font-size: 24px;">事由：</label>
        <div class="left" style="line-height: 35px;">${title!}</div>
    </div>
    <div class="left clear">
        <div>尊敬的客户，</div>
        <div style="width: 550px;line-height:30px;word-wrap: break-word; word-break: normal;">${content!}</div>
    </div>
</div>
<p class="left" style="border: 1px solid black;width: 100%;margin: 8px 1px 0 1px"></p>
<div class="left width1" style="width: 100%;">
    <div class="left" style="width: 20%;text-align: center;">结单编号</div>
    <div class="left" style="width: 20%;text-align: center;">结单日期</div>
    <div class="left" style="width: 20%;text-align: center;">到期还款日</div>
    <div class="left" style="width: 20%;text-align: center;">金额</div>
    <div class="left" style="width: 20%;text-align: center;">币种</div>
</div>
<p class="left" style="border: 1px solid black;width: 100%;margin: 8px 1px 0 1px"></p>
<div class="left width1">
    <div class="left" style="width: 20%;text-align: center;">${billId!}</div>
    <div class="left" style="width: 20%;text-align: center;">${billDate!}</div>
    <div class="left" style="width: 20%;text-align: center;">${finalRepaymentDate!}</div>
    <div class="left" style="width: 20%;text-align: center;">${amount!}</div>
    <div class="left" style="width: 20%;text-align: center;">${currency!}</div>
</div>
<p class="left" style="border: 1px solid black;width: 40%;margin: 8px 1px 0 1px"></p>
<div class="left width1" style="width: 100%;">
    <div class="left" style="width: 20%;text-align: center;">超期天数</div>
    <div class="left" style="width: 20%;text-align: center;">逾期未付款含税总额（CNY）</div>
</div>
<p class="left" style="border: 1px solid black;width: 40%;margin: 8px 1px 0 1px"></p>
<div class="left width1">
    <div class="left" style="width: 20%;text-align: center;">${overdueDays!}</div>
    <div class="left" style="width: 20%;text-align: center;">${overdueAmount!}</div>
</div>
<div class="left width1" style="border: 1px solid black;margin-top: 4%;">
    <div style="text-align: center;font-weight: 700;">付款信息</div>
    <div>
        <div class="left" style="font-weight: 700;">账户信息：</div>
        <div class="left" style="font-weight: 700;">${dept.bankAcctFleetName!}</div>
    </div>
    <div class="clear">
        <div class="left" style="font-weight: 700;">银行及支行名称：</div>
        <div class="left" style="font-weight: 700;">${dept.bankFleet!}</div>
    </div>
    <div class="clear">
        <div class="left" style="font-weight: 700;">银行账号：</div>
        <div class="left" style="font-weight: 700;">${dept.bankAcctFleet!}</div>
    </div>
    <div class="left clear" style="margin-top: 3%;margin-bottom: 1%;width: 100%;text-align: center;">
        请按到期发票金额付款，并注明“加油款还款”，如有任何异议,请联系客服。
    </div>
</div>
</body>
</html>
