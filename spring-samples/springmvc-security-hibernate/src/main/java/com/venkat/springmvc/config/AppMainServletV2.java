package com.venkat.springmvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppMainServletV2 extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { AppMvcConfigV2.class };
    }

    @Override
    protected String getServletName() {
        return AppMainServletV2.class.getSimpleName();
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/v2/*" };
    }

}
