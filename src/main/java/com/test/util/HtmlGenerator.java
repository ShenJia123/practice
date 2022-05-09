package com.test.util;

import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.BufferedWriter;
import java.io.File;
import java.io.StringWriter;
import java.util.Map;

/**
 * ClassName : HtmlGenerator<br>
 * Description : HtmlGenerator<br>
 *
 * @author : sj
 * @date : 2022/4/30
 */
public class HtmlGenerator {

    /**
     * Generate html string.
     *
     * @param templatePath the path of template
     * @param templateName the name of freemarker template.
     * @param variables    the data of template.
     * @return htmlStr
     * @throws Exception
     */
    public static String generate(String templatePath, String templateName, Map<String, Object> variables)
            throws Exception {
        Configuration config = new Configuration();
        FileTemplateLoader fileTemplateLoader = new FileTemplateLoader(new File(templatePath));
        config.setTemplateLoader(fileTemplateLoader);
        Template template = config.getTemplate(templateName, "utf-8");
        StringWriter stringWriter = new StringWriter();
        BufferedWriter writer = new BufferedWriter(stringWriter);
        template.setEncoding("UTF-8");
        template.process(variables, writer);
        String htmlStr = stringWriter.toString();
        writer.flush();
        writer.close();
        return htmlStr;
    }
}
