import cn.hutool.core.date.StopWatch;
import cn.hutool.core.lang.Assert;
import com.alibaba.fastjson.JSONObject;
import com.itextpdf.text.pdf.BaseFont;
import com.spire.pdf.FileFormat;
import com.spire.pdf.PdfDocument;
import com.test.dto.CreditInfo;
import com.test.util.HtmlGenerator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.*;

/**
 * ClassName : T<br>
 * Description : T<br>
 *
 * @author : sj
 * @date : 2022/5/7
 */
@Slf4j
public class T {

    @Test
    public void aa() throws Exception {
        CreditInfo creditInfo = new CreditInfo();
        creditInfo.setAccountCode("12312312312312312");
        creditInfo.setAccountName("湖北壳牌能源有限公司");
        creditInfo.setAddress("武汉市江汉区中央商务区云霞路85号、187号、淮海路249号泛海国际中心办公A单元12层4、5号");
        creditInfo.setBillAmount(new BigDecimal("22222221000000"));
        creditInfo.setRptCreditBillId("WHX20210318000001");
        creditInfo.setBillDate("2022-01-01");
        creditInfo.setBankAcctFleet("23434563456345");
        creditInfo.setBankFleet("中国银行武汉中央商务区支行");
        creditInfo.setCustomerBand(22);
        creditInfo.setTel("027-83609001");
        creditInfo.setStreet("新市镇盛饭路19号");
        creditInfo.setRepaymentTotalAmount(BigDecimal.TEN);
        creditInfo.setRepaymentDays("123");
        creditInfo.setRepaymentDate("06/27/2022");
        creditInfo.setRepaymentAmount(BigDecimal.valueOf(20L));
        creditInfo.setDeptPostCode("1000004");
        creditInfo.setPostCode("12312312");
        creditInfo.setOverdueAmount(BigDecimal.valueOf(200L));
        creditInfo.setNotOverdueAmount(BigDecimal.valueOf(100L));
        creditInfo.setLocationName("中国湖北省 荆门市 京山市");
        creditInfo.setDeptName("湖北壳牌能源有限公司");

        String outFile = "/Users/shenjia/Desktop/未命名文件夹/11/" + UUID.randomUUID();

        Map map = JSONObject.parseObject(JSONObject.toJSONString(creditInfo), Map.class);
        map.put("registerNumber", "1231231231231232");
        map.put("registerNumberTitle", "社会统一信用代码");
        map.put("sumAmount", "200");
        map.put("billDate1", "2022年06月27日");
        map.put("rebateAmount", "100000");
        map.put("purchaseAmount", "100000000000");
        map.put("discountAmount", "100000000000");
        map.put("invoiceAmount", "100000000000");
        map.put("preRepaymentTotalAmount", "100000000000");
        Map purchaseDetailList = new HashMap();
        purchaseDetailList.put("id", "111111111111111111111111");
        purchaseDetailList.put("license", "111111111111111111111111");
        purchaseDetailList.put("holder", "111111111111111111");
        purchaseDetailList.put("time", "111111111111111111111111");
        purchaseDetailList.put("productName", "1111111111111111111");
        purchaseDetailList.put("productPrice", "111111111111111111");
        purchaseDetailList.put("quantity", "111111111111111111");
        purchaseDetailList.put("payAmount", "111111111111111111");
        purchaseDetailList.put("purchaseDiscount", "111111111111111111111111");
        purchaseDetailList.put("actualAmount", "111111111111111111");
        purchaseDetailList.put("preferential", "111111");
        purchaseDetailList.put("invoiceAmount", "1111111111111111111111");
        purchaseDetailList.put("siteName", "111111111111111111111111");
        purchaseDetailList.put("cardRemark", "1111111111111111111111111111111");
        purchaseDetailList.put("status", "正常");
        List list = new ArrayList();
        list.add(purchaseDetailList);
        list.add(purchaseDetailList);
        map.put("purchaseDetailList", list);
        Map purchaseGroup = new HashMap();
        purchaseGroup.put("siteName", "2222");
        purchaseGroup.put("productName", "123123123333333333333");
        purchaseGroup.put("quantity", "12312312312312312");
        purchaseGroup.put("actualAmount", "12312312312312");
        list = new ArrayList();
        list.add(purchaseGroup);
        list.add(purchaseGroup);
        map.put("purchaseGroup", list);
        Map otherDetailList = new HashMap();
        otherDetailList.put("id", "1111111");
        otherDetailList.put("time", "2022-11-11");
        otherDetailList.put("transType", "返利");
        otherDetailList.put("amount", "11.222");
        otherDetailList.put("remark", "12312312312");
        list = new ArrayList();
        list.add(otherDetailList);
        list.add(otherDetailList);
        map.put("otherDetailList", list);
        Map repaymentDetailList = new HashMap();
        repaymentDetailList.put("id", "22222222222");
        repaymentDetailList.put("repaymentTime", "3333333");
        repaymentDetailList.put("repaymentTransType", "44444444");
        repaymentDetailList.put("repaymentChannel", "1111111");
        repaymentDetailList.put("repaymentAmount", "22222222");
        repaymentDetailList.put("status", "正常");
        list = new ArrayList();
        list.add(repaymentDetailList);
        list.add(repaymentDetailList);
        map.put("repaymentDetailList", list);


        String htmlStr = HtmlGenerator.generate("/Users/shenjia/Sj/pro/practice/src/main/resources/template", "accountBill.ftl", map);

        OutputStream os = new FileOutputStream(outFile + ".pdf");
        ITextRenderer renderer = new ITextRenderer();
        ITextFontResolver font = renderer.getFontResolver();
        font.addFont("/Users/shenjia/Sj/pro/practice/src/main/resources/static/font/SIMSUN.TTC", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);//添加中文识别，这里是设置的宋体，Linux下要换成对应的字体
        renderer.setDocumentFromString(htmlStr);

        renderer.layout();
        renderer.createPDF(os);
        renderer.finishPDF();
        PdfDocument pdfDocument = new PdfDocument();
        pdfDocument.loadFromFile(outFile + ".pdf");
        pdfDocument.saveToFile(outFile + ".xlsx", FileFormat.XLSX);
        pdfDocument.dispose();
    }

    @Test
    public void aca() throws Exception {
        CreditInfo creditInfo = new CreditInfo();
        creditInfo.setAccountCode("12312312312312312");
        creditInfo.setAccountName("湖北壳牌能源有限公司");
        creditInfo.setAddress("武汉市江汉区中央商务区云霞路85号、187号、淮海路249号泛海国际中心办公A单元12层4、5号");
        creditInfo.setBillAmount(new BigDecimal("22222221000000"));
        creditInfo.setRptCreditBillId("WHX20210318000001");
        creditInfo.setBillDate("2022-01-01");
        creditInfo.setBankAcctFleet("23434563456345");
        creditInfo.setBankFleet("中国银行武汉中央商务区支行");
        creditInfo.setCustomerBand(22);
        creditInfo.setTel("027-83609001");
        creditInfo.setStreet("新市镇盛饭路19号");
        creditInfo.setRepaymentTotalAmount(BigDecimal.TEN);
        creditInfo.setRepaymentDays("123");
        creditInfo.setRepaymentDate("06/27/2022");
        creditInfo.setRepaymentAmount(BigDecimal.valueOf(20L));
        creditInfo.setDeptPostCode("1000004");
        creditInfo.setPostCode("12312312");
        creditInfo.setOverdueAmount(BigDecimal.valueOf(200L));
        creditInfo.setNotOverdueAmount(BigDecimal.valueOf(100L));
        creditInfo.setLocationName("中国湖北省 荆门市 京山市");
        creditInfo.setDeptName("湖北壳牌能源有限公司");

        String outFile = "/Users/shenjia/Desktop/未命名文件夹/11/" + UUID.randomUUID();

        Map map = JSONObject.parseObject(JSONObject.toJSONString(creditInfo), Map.class);
        map.put("registerNumber", "1231231231231232");
        map.put("registerNumberTitle", "社会统一信用代码");
        map.put("sumAmount", "200");
        map.put("billDate1", "2022年06月27日");
        map.put("rebateAmount", "100000");
        map.put("purchaseAmount", "100000000000");
        map.put("discountAmount", "100000000000");
        map.put("invoiceAmount", "100000000000");
        map.put("preRepaymentTotalAmount", "100000000000");
        Map purchaseDetailList = new HashMap();
        purchaseDetailList.put("pan", "7077904410000002926");
        purchaseDetailList.put("license", "");
        purchaseDetailList.put("holder", "");
        purchaseDetailList.put("time", "2022-01-02");
        purchaseDetailList.put("productName", "非酒精饮料");
        purchaseDetailList.put("productPrice", "5.0000");
        purchaseDetailList.put("quantity", "10.0000");
        purchaseDetailList.put("payAmount", "50.00");
        purchaseDetailList.put("purchaseDiscount", "0.00");
        purchaseDetailList.put("actualAmount", "50.00");
        purchaseDetailList.put("preferential", "0");
        purchaseDetailList.put("siteName", "新塘加油站");
        purchaseDetailList.put("status", "被冲正");
        List list = new ArrayList();
        list.add(purchaseDetailList);
        list.add(purchaseDetailList);
        map.put("purchaseDetailList", list);
        Map purchaseGroup = new HashMap();
        purchaseGroup.put("siteName", "2222");
        purchaseGroup.put("productName", "123123123333333333333");
        purchaseGroup.put("quantity", "12312312312312312");
        purchaseGroup.put("actualAmount", "12312312312312");
        list = new ArrayList();
        list.add(purchaseGroup);
        purchaseGroup = new HashMap();
        purchaseGroup.put("siteName", "2222");
        purchaseGroup.put("productName", "123123123333333333333");
        purchaseGroup.put("quantity", "12312312312312312");
        purchaseGroup.put("actualAmount", "12312312312312");
        list.add(purchaseGroup);
        map.put("purchaseGroup", list);
        Map otherDetailList = new HashMap();
        otherDetailList.put("id", "1111111");
        otherDetailList.put("time", "2022-11-11");
        otherDetailList.put("transType", "返利");
        otherDetailList.put("amount", "11.222");
        otherDetailList.put("remark", "12312312312");
        list = new ArrayList();
        list.add(otherDetailList);
        list.add(otherDetailList);
        map.put("otherDetailList", list);
        Map repaymentDetailList = new HashMap();
        repaymentDetailList.put("id", "22222222222");
        repaymentDetailList.put("repaymentTime", "3333333");
        repaymentDetailList.put("repaymentTransType", "44444444");
        repaymentDetailList.put("repaymentChannel", "1111111");
        repaymentDetailList.put("repaymentAmount", "22222222");
        repaymentDetailList.put("status", "正常");
        list = new ArrayList();
        list.add(repaymentDetailList);
        list.add(repaymentDetailList);
        map.put("repaymentDetailList", list);


        String htmlStr = HtmlGenerator.generate("/Users/shenjia/Sj/pro/practice/src/main/resources/template", "accountBill.ftl", map);

        OutputStream os = new FileOutputStream(outFile + ".pdf");
        ITextRenderer renderer = new ITextRenderer();
        ITextFontResolver font = renderer.getFontResolver();
        font.addFont("/Users/shenjia/Sj/pro/practice/src/main/resources/static/font/SIMSUN.TTC", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);//添加中文识别，这里是设置的宋体，Linux下要换成对应的字体
        renderer.setDocumentFromString(htmlStr);

        renderer.layout();
        renderer.createPDF(os);
        renderer.finishPDF();
        /*PdfDocument pdfDocument = new PdfDocument();
        pdfDocument.loadFromFile(outFile + ".pdf");
        pdfDocument.saveToFile(outFile + ".xlsx", FileFormat.XLSX);
        pdfDocument.dispose();*/
    }


    @Test
    public void aaa() {
        Map map = new HashMap(1);
        map.put("1", "1");
        map.put("12", "1");
        log.info("{}", map.size());
    }
}
