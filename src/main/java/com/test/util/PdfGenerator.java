package com.test.util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.Pipeline;
import com.itextpdf.tool.xml.XMLWorker;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.itextpdf.tool.xml.html.CssAppliersImpl;
import com.itextpdf.tool.xml.html.Tags;
import com.itextpdf.tool.xml.net.FileRetrieve;
import com.itextpdf.tool.xml.net.ReadingProcessor;
import com.itextpdf.tool.xml.parser.XMLParser;
import com.itextpdf.tool.xml.pipeline.css.CSSResolver;
import com.itextpdf.tool.xml.pipeline.css.CssResolverPipeline;
import com.itextpdf.tool.xml.pipeline.end.PdfWriterPipeline;
import com.itextpdf.tool.xml.pipeline.html.*;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.SneakyThrows;
import org.springframework.util.StringUtils;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

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

    public static void generatePlus(String htmlStr, OutputStream out) throws DocumentException {
        com.itextpdf.text.Document document = new Document(PageSize.A4, 30, 30, 30, 30);
        document.setMargins(30, 30, 30, 30);
        PdfWriter writer = PdfWriter.getInstance(document, out);
        document.open();

        // html内容解析
        HtmlPipelineContext htmlContext = new HtmlPipelineContext(
                new CssAppliersImpl(new XMLWorkerFontProvider() {
                    @SneakyThrows
                    @Override
                    public Font getFont(String fontname, String encoding,
                                        float size, final int style) {
                        try {
                            BaseFont base = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
                            return new Font(base, size, style);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return super.getFont(fontname, encoding, size, style);
                    }
                })) {
            @Override
            public HtmlPipelineContext clone()
                    throws CloneNotSupportedException {
                HtmlPipelineContext context = super.clone();
                try {
                    ImageProvider imageProvider = this.getImageProvider();
                    context.setImageProvider(imageProvider);
                } catch (NoImageProviderException e) {
                    e.printStackTrace();
                }
                return context;
            }
        };

        // 图片解析
        htmlContext.setImageProvider(new AbstractImageProvider() {

            @Override
            public String getImageRootPath() {
                return null;
            }
        });
        htmlContext.setAcceptUnknown(true).autoBookmark(true).setTagFactory(Tags.getHtmlTagProcessorFactory());

        // css解析
        CSSResolver cssResolver = XMLWorkerHelper.getInstance().getDefaultCssResolver(true);
        cssResolver.setFileRetrieve(new FileRetrieve() {
            @Override
            public void processFromStream(InputStream in,
                                          ReadingProcessor processor) throws IOException {
                try (
                        InputStreamReader reader = new InputStreamReader(in, StandardCharsets.UTF_8)) {
                    int i = -1;
                    while (-1 != (i = reader.read())) {
                        processor.process(i);
                    }
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }

            // 解析href
            @Override
            public void processFromHref(String href, ReadingProcessor processor) throws IOException {
                InputStream is = PdfGenerator.class.getResourceAsStream("/" + href);
                try (InputStreamReader reader = new InputStreamReader(is, StandardCharsets.UTF_8)) {
                    int i = -1;
                    while (-1 != (i = reader.read())) {
                        processor.process(i);
                    }
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }
        });

        HtmlPipeline htmlPipeline = new HtmlPipeline(htmlContext, new PdfWriterPipeline(document, writer));
        Pipeline<?> pipeline = new CssResolverPipeline(cssResolver, htmlPipeline);
        XMLWorker worker = null;
        worker = new XMLWorker(pipeline, true);
        XMLParser parser = new XMLParser(true, worker, StandardCharsets.UTF_8);
        try (InputStream inputStream = new ByteArrayInputStream(htmlStr.getBytes())) {
            parser.parse(inputStream, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        document.close();
    }

   /* public static void createPdf(String content, OutputStream out) throws IOException, com.lowagie.text.DocumentException {
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
    }*/


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
