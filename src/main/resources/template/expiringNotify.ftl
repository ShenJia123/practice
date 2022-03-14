<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>即将到期应付款通知</title>
</head>
<style>
    .left {
        float: left;
    }

    .right {
        float: right;
    }
</style>
<body style="margin: 0 auto;width: 55%;">
<div class="left" style="width: 40%;margin-top: 20%;">
    <div>${customer.customerName}</div>
    <div>${customer.contactAddress}</div>
    <div>${customer.address}</div>
    <div>
        <div class="left">统一社会信用代码</div>
        <div class="left" style="margin-left: 5%">${customer.registerNumber}</div>
    </div>
</div>
<div class="right" style="width: 40%;margin-top: 11%;">
    <div>${dept.deptName}</div>
    <div>${dept.address}</div>
    <div>${dept.tel}</div>
    <!--  <div class="left" style="width: 100%;">
          <div class="left">统一社会信用代码</div>
          <div class="left" style="margin-left: 5%">91441900684487322B</div>
      </div>-->
    <div class="left">如有任何疑问，请联系壳牌客服</div>

    <div class="left" style="border: 2px solid black;height: auto;width: 100%;margin-top: 18%;">
        <div>请参考以下信息付款</div>
        <div>
            <div class="left">客户编码</div>
            <div class="right">${customerCode}</div>
        </div>
        <div style="clear: both;">
            <div class="left">月结单编码</div>
            <div class="right">${billId}</div>
        </div>
    </div>
</div>
<div style="clear: both;margin-bottom: 3%;" class="left">
    <div class="left">
        <label class="left" style="font-size: 24px;">事由：</label>
        <div class="left" style="line-height: 35px;">${title}</div>
    </div>
    <div class="left" style="clear: both;">
        <p>尊敬的客户，</p>
        <p>贵公司的账户中有如下表所列的账款即将到期。</p>
        <p>请您核对您的客户编码、账单号和未付款金额等信息后在到期日前付款。</p>
        <p>如果贵公司对本通知书或者付款信息有任何疑问,请与我公司客服联系。</p>
    </div>
</div>
<hr style="border: 1px solid black;width: 100%;margin: 8px 1px 0 1px"/>
<div class="left" style="width: 100%;">
    <div class="left" style="width: 20%;text-align: center;">月结单编号</div>
    <div class="left" style="width: 20%;text-align: center;">月结单日期</div>
    <div class="left" style="width: 20%;text-align: center;">到期还款日</div>
    <div class="left" style="width: 20%;text-align: center;">金额</div>
    <div class="left" style="width: 20%;text-align: center;">币种</div>
</div>
<hr style="border: 1px solid black;width: 100%;;margin: 8px 1px 0 1px"/>
<div class="left" style="width: 100%;">
    <div class="left" style="width: 20%;text-align: center;">${billId}</div>
    <div class="left" style="width: 20%;text-align: center;">${billDate}</div>
    <div class="left" style="width: 20%;text-align: center;">${finalRepaymentDate}</div>
    <div class="left" style="width: 20%;text-align: center;">${amount}</div>
    <div class="left" style="width: 20%;text-align: center;">${currency}</div>
</div>
<div class="left" style="width: 100%;border: 1px solid black;margin-top: 4%;">
    <div style="text-align: center;font-weight: 700;">付款信息</div>
    <div>
        <div class="left" style="font-weight: 700;">账户信息：</div>
        <div class="left" style="font-weight: 700;">${dept.bankAcctFleetName}</div>
    </div>
    <div style="clear: both;">
        <div class="left" style="font-weight: 700;">银行及支行名称：</div>
        <div class="left" style="font-weight: 700;">${dept.bankFleet}</div>
    </div>
    <div style="clear: both;">
        <div class="left" style="font-weight: 700;">银行账号：</div>
        <div class="left" style="font-weight: 700;">${dept.bankAcctFleet}</div>
    </div>
    <div class="left" style="clear: both;margin-top: 3%;margin-bottom: 1%;width: 100%;text-align: center;">
        请按到期发票金额付款，并注明“加油款还款”，如有任何异议,请联系客服。
    </div>
</div>
</body>
</html>