import com.alibaba.fastjson.JSONObject;
import com.test.dto.CreditDetail;
import com.test.dto.CreditInfo;
import com.test.util.HtmlGenerator;
import com.test.util.PdfGenerator;
import org.junit.Test;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

/**
 * ClassName : Test<br>
 * Description : Test<br>
 *
 * @author : sj
 * @date : 2021/9/24
 */
public class T {

    private static final String resourcesDir = System.getProperty("user.dir") + "/src/main/resources";

    @Test
    public void aa() throws Exception {
        String outputFile = "/Users/shenjia/Desktop/未命名文件夹";
        Map<String, Object> variables = new HashMap<String, Object>(3);
        variables.put("title", "ces");
        Map customer = new HashMap();
        customer.put("customerName", "11");
        customer.put("contactAddress", "contactAddress");
        customer.put("address", "11");
        customer.put("registerNumber", "11");
        variables.put("customer", customer);

        Map dept = new HashMap();
        dept.put("deptName", "1");
        dept.put("tel", "1");
        dept.put("address", "1");
        dept.put("bankAcctFleetName", "1231");
        dept.put("bankFleet", "fasdfsdaf");
        dept.put("bankAcctFleet", "11123");
        variables.put("dept", dept);

        variables.put("customerCode", "12312");
        variables.put("billId", "12312");
        variables.put("billDate", "12312");
        variables.put("finalRepaymentDate", "123123dfafd");
        variables.put("amount", "aaaa");
        variables.put("currency", "bbbb");

//        String html = HtmlGenerator.generate("expiringNotify.ftl", variables);

      /*  Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(T.class, "/template");
        configuration.setDefaultEncoding("utf-8");
        Template template = configuration.getTemplate("expiringNotify.ftl", "utf-8");
        String time = DateUtil.format(new Date(), "yyyyMMdd");

        outputFile = outputFile + File.separator + time;
        File file = new File(outputFile);
        if (!file.exists()) {
            file.mkdir();
        }

        String fileName = IdUtil.createSnowflake(1, 1).nextIdStr();

        String htmlUrl = outputFile + File.separator + fileName + ".html";
        file = new File(htmlUrl);
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        template.process(variables, fileWriter);
        String outputFile1 = outputFile + File.separator + fileName + ".pdf";
        ITextRenderer renderer = new ITextRenderer();
        OutputStream os = new FileOutputStream(outputFile1);
        renderer.setDocument(new File(htmlUrl));
        ITextFontResolver resolver = renderer.getFontResolver();
        //添加字体，解决中文不显示的问题
        resolver.addFont(resourcesDir + "/static/font/SIMSUN.TTC", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        renderer.layout();
        renderer.createPDF(os);
        os.close();*/
//        PdfGenerator.generatePlus(html, outputFile);
//        OutputStream outputStream = new FileOutputStream("/Users/shenjia/Desktop/未命名文件夹/expiringNotify.pdf");
//        PdfGenerator.generatePlus(html, outputStream);
        PdfGenerator.createPdf(resourcesDir, "expiringNotify.ftl", "/Users/shenjia/Desktop/未命名文件夹/", variables);


    }

    @Test
    public void bb() {
        System.out.println(File.separator);
        System.out.println(File.pathSeparator);
        System.out.println(File.pathSeparatorChar);
    }


    @Test
    public void ee() throws Exception {
        CreditInfo creditInfo = new CreditInfo();
        creditInfo.setAccountCode("12312312312312312");
        creditInfo.setAccountName("湖北壳牌能源有限公司");
        creditInfo.setAddress("武汉市江汉区中央商务区云霞路85号、187号、淮海路249号泛海国际中心办公A单元12层4、5号");
        creditInfo.setBillAmount(BigDecimal.ONE);
        creditInfo.setRptCreditBillId("WHX20210318000001");
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
        creditDetail.setSiteName("123");
        creditDetail.setProductName("asdasd");
        creditDetail.setProductUnit("asdas");
        creditDetail.setQuantity(BigDecimal.TEN);
        creditDetail.setTransAmount(BigDecimal.valueOf(20L));
        list.add(creditDetail);

        creditInfo.setList(list);

        Map map = JSONObject.parseObject(JSONObject.toJSONString(creditInfo), Map.class);
//        String html = HtmlGenerator.generate("accountBill.ftl", map);
//        OutputStream outputStream = new FileOutputStream("/Users/shenjia/Desktop/未命名文件夹/accountBill.pdf");
//        PdfGenerator.generatePlus(html, outputStream);
        PdfGenerator.createPdf(resourcesDir, "accountBill.ftl", "/Users/shenjia/Desktop/未命名文件夹/", map);


//        RptCreditBill rptCreditBill = new RptCreditBill();
//        rptCreditBillService.getFileId(creditInfo,rptCreditBill);
    }
}
