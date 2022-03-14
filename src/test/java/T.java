import com.itextpdf.text.pdf.BaseFont;
import com.test.util.HtmlGenerator;
import com.test.util.PdfGenerator;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.Test;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
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

    private static final String resourcesDir = System.getProperty("user.dir") + "/src/main/resources";

    @Test
    public void aa() throws Exception {
        String outputFile = "D:\\QMDownload/test.html";
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

        String html = HtmlGenerator.generate("expiringNotify.ftl", variables, outputFile);

        /*Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(T.class, "/template");
        configuration.setDefaultEncoding("utf-8");
        Template template = configuration.getTemplate("expiringNotify.ftl", "utf-8");

        File file = new File(outputFile);
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        template.process(variables, fileWriter);
        String outputFile1 = "D:\\QMDownload/test.pdf";
        ITextRenderer renderer = new ITextRenderer();
        OutputStream os = new FileOutputStream(outputFile1);
        renderer.setDocument(new File(outputFile));
        ITextFontResolver resolver = renderer.getFontResolver();
        //添加字体，解决中文不显示的问题
//        resolver.addFont("C:\\Windows\\Fonts\\simsun.ttc", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        renderer.layout();
        renderer.createPDF(os);
        os.close();
*/
//        PdfGenerator.generatePlus(html, outputFile);
        OutputStream outputStream = new FileOutputStream("D:\\QMDownload/test.pdf");
        PdfGenerator.createPdf(html, outputStream);


    }

    @Test
    public void bb() {
        System.out.println(File.separator);
        System.out.println(File.pathSeparator);
    }


}
