package com.test.util;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;
import org.w3c.dom.Document;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * ClassName : PdfGenerator<br>
 * Description : PdfGenerator<br>
 *
 * @author : sj
 * @date : 2022/3/14
 */
public class PdfGenerator {

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
        fontResolver.addFont("C:/Windows/Fonts/simsun.ttc", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

        // 解析html生成pdf
        render.setDocumentFromString(content);

        //解决图片相对路径的问题
        //render.getSharedContext().setBaseURL("");
        render.layout();
        render.createPDF(out);
        render.finishPDF();
    }

}
