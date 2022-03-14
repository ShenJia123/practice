package com.test.domain;

import freemarker.template.Configuration;

/**
 * ClassName : FreemarkerConfiguration<br>
 * Description : FreemarkerConfiguration<br>
 *
 * @author : sj
 * @date : 2022/3/11
 */
public class FreemarkerConfiguration {

    private static Configuration config = null;

    /**
     * Static initialization.
     *
     * Initialize the configuration of Freemarker.
     */
    static {
        config = new Configuration();
        config.setClassForTemplateLoading(FreemarkerConfiguration.class,
                "/template");
    }

    public static Configuration getConfiguration() {
        return config;
    }
}
