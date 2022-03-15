package com.test.util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;
import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.w3c.dom.Document;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

/**
 * ClassName : PdfGenerator<br>
 * Description : PdfGenerator<br>
 *
 * @author : sj
 * @date : 2022/3/14
 */
public class PdfGenerator {

    private static final String resourcesDir = System.getProperty("user.dir") + "/src/main/resources";

    public static void generatePlus(String html, String outputFile) throws ParserConfigurationException, IOException, SAXException, DocumentException {
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse(new ByteArrayInputStream(html.getBytes(StandardCharsets.UTF_8)));
        ITextRenderer iTextRenderer = new ITextRenderer();
        iTextRenderer.getFontResolver().addFont("D:\\Sj\\practice\\src\\main\\resources\\static\\font/SIMSUN.TTC", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        iTextRenderer.setDocument(document, outputFile);
        iTextRenderer.layout();
        iTextRenderer.createPDF(byteArrayOutputStream);
        byte[] bytes = byteArrayOutputStream.toByteArray();
        FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
        fileOutputStream.write(bytes);
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    public static void createPdf(String content, OutputStream out) throws IOException, com.lowagie.text.DocumentException {
        ITextRenderer render = new ITextRenderer();

        ITextFontResolver fontResolver = render.getFontResolver();
        fontResolver.addFont(resourcesDir + "/static/font/SIMSUN.TTC", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

        // 解析html生成pdf
        render.setDocumentFromString(content);

        //解决图片相对路径的问题
        //render.getSharedContext().setBaseURL("");
        render.layout();
        render.createPDF(out);
        render.finishPDF();
    }


    /**
     * 生成pdf
     *
     * @param templatePath
     * @param templateName
     * @param outputUrl
     * @param variables
     * @throws IOException
     * @throws TemplateException
     */
    public static String createPdf(String templatePath, String templateName, String outputUrl, Map variables) throws IOException, TemplateException, com.itextpdf.text.DocumentException, com.lowagie.text.DocumentException {
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(PdfGenerator.class, "/template");
//        FileTemplateLoader fileTemplateLoader = new FileTemplateLoader(new File(templatePath));
//        configuration.setTemplateLoader(fileTemplateLoader);

        configuration.setDefaultEncoding("utf-8");
        Template template = configuration.getTemplate(templateName, "utf-8");
        String time = DateUtil.format(new Date(), "yyyyMMdd");
        outputUrl = outputUrl + File.separator + time;
        File file = new File(outputUrl);
        // 判断生成路径是否存在
        if (!file.exists()) {
            file.mkdir();
        }
        String fileName = IdUtil.createSnowflake(1, 1).nextIdStr();
        file = new File(outputUrl + File.separator + fileName + ".html");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file);
        template.process(variables, fileWriter);

        String outputFile = outputUrl + File.separator + fileName + ".pdf";
        ITextRenderer renderer = new ITextRenderer();
        OutputStream os = new FileOutputStream(outputFile);
        renderer.setDocument(new File(outputFile));
        ITextFontResolver resolver = renderer.getFontResolver();
        //添加字体，解决中文不显示的问题
        resolver.addFont(templatePath + "/font/SIMSUN.TTC", com.itextpdf.text.pdf.BaseFont.IDENTITY_H, com.itextpdf.text.pdf.BaseFont.NOT_EMBEDDED);
        renderer.layout();
        renderer.createPDF(os);
        os.close();
        return fileName;
    }
}
