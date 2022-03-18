package com.test.util;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.BufferedWriter;
import java.io.StringWriter;
import java.util.Map;

/**
 * ClassName : HtmlGenerator<br>
 * Description : HtmlGenerator<br>
 *
 * @author : sj
 * @date : 2022/3/11
 */
public class HtmlGenerator {

    /**
     * Generate html string.
     *
     * @param template  the name of freemarker template.
     * @param variables the data of template.
     * @return htmlStr
     * @throws Exception
     */
    public static String generate(String template, Map<String, Object> variables)
            throws Exception {
        Configuration config = new Configuration();
        config.setClassForTemplateLoading(HtmlGenerator.class, "/template");
        config.setDefaultEncoding("UTF-8");
        Template tp = config.getTemplate(template);
        StringWriter stringWriter = new StringWriter();
        BufferedWriter writer = new BufferedWriter(stringWriter);
        tp.setEncoding("UTF-8");
        tp.process(variables, writer);
        writer.flush();
        writer.close();
        return stringWriter.toString();
    }
}
