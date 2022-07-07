package com.test.controller;

import cn.hutool.core.io.resource.ResourceUtil;
import com.alibaba.fastjson.JSONObject;
import com.itextpdf.text.pdf.BaseFont;
import com.test.dto.CreditDetail;
import com.test.dto.CreditInfo;
import com.test.util.HtmlGenerator;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;


/**
 * ClassName : TestCtrl<br>
 * Description : TestCtrl<br>
 *
 * @author : sj
 * @date : 2022/4/8
 */
@Slf4j
@RestController
public class TestCtrl {


    @GetMapping("test")
    public void test() throws Exception {
        CreditInfo creditInfo = new CreditInfo();
        creditInfo.setAccountCode("12312312312312312");
        creditInfo.setAccountName("湖北壳牌能源有限公司");
        creditInfo.setAddress("武汉市江汉区中央商务区云霞路85号、187号、淮海路249号泛海国际中心办公A单元12层4、5号");
        creditInfo.setBillAmount(BigDecimal.ONE);
        creditInfo.setRptCreditBillId("WHX20210318000001");
        creditInfo.setBillDate("2022-01-01");
        creditInfo.setBillDate("2022-01-01");
        creditInfo.setBankAcctFleet("23434563456345");
        creditInfo.setBankFleet("中国银行武汉中央商务区支行");
        creditInfo.setCustomerBand(22);
        creditInfo.setTel("027-83609001");
        creditInfo.setStreet("新市镇盛饭路19号");
        creditInfo.setRepaymentTotalAmount(BigDecimal.TEN);
        creditInfo.setRepaymentDays("123");
        creditInfo.setRepaymentDate("2021-02-02");
        creditInfo.setRepaymentAmount(BigDecimal.valueOf(20L));
        creditInfo.setDeptPostCode("1000004");
        creditInfo.setPostCode("12312312");
        creditInfo.setOverdueAmount(BigDecimal.valueOf(200L));
        creditInfo.setNotOverdueAmount(BigDecimal.valueOf(100L));
        creditInfo.setLocationName("中国湖北省 荆门市 京山市");
        creditInfo.setDeptName("湖北壳牌能源有限公司");
        List<CreditDetail> list = new ArrayList<>();
        CreditDetail creditDetail = new CreditDetail();
        creditDetail.setDate("2022-02-11");
        creditDetail.setSiteName("湖北壳牌能源有限公司");
        creditDetail.setDay("2022-05-09");
        creditDetail.setTime("10:22:22");
        creditDetail.setProductName("湖北壳牌能源有限公司");
        creditDetail.setProductUnit("升");
        creditDetail.setQuantity(BigDecimal.valueOf(10000L));
        creditDetail.setTransAmount(BigDecimal.valueOf(10000L));
        list.add(creditDetail);

        String outFile = "/Users/shenjia/Desktop/未命名文件夹/" + UUID.randomUUID() + ".pdf";

        Map map = JSONObject.parseObject(JSONObject.toJSONString(creditInfo), Map.class);
        map.put("sumAmount", "200");
        map.put("billDate1", "2022-02-11");
        String htmlStr = HtmlGenerator.generate(ResourceUtil.getResource("").getPath() + "/template", "accountBill.ftl", map);

        OutputStream os = new FileOutputStream(outFile);    //生成PDF文件的路径
        ITextRenderer renderer = new ITextRenderer();
        ITextFontResolver font = renderer.getFontResolver();
        font.addFont(ResourceUtil.getResource("/static/font/SIMSUN.TTC").getPath(), BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);//添加中文识别，这里是设置的宋体，Linux下要换成对应的字体
        renderer.setDocumentFromString(htmlStr);

        renderer.layout();
        renderer.createPDF(os);
        renderer.finishPDF();
    }


}
