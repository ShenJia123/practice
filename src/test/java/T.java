import com.test.util.HtmlGenerator;
import com.test.util.PdfGenerator;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName : Test<br>
 * Description : Test<br>
 *
 * @author : sj
 * @date : 2021/9/24
 */
public class T {


    @Test
    public void aa() throws Exception {
        String outputFile = "/Users/shenjia/Desktop/未命名文件夹/test.pdf";
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

        String htmlStr = HtmlGenerator.generate("expiringNotify.ftl", variables);


        OutputStream out = new FileOutputStream(outputFile);
        PdfGenerator.generatePlus(htmlStr, out);
//        PdfUtil.generatePdf("test.html",out);
    }

    @Test
    public void bb() {
        System.out.println(File.separator);
        System.out.println(File.pathSeparator);
    }


}
