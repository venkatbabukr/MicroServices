package com.venkat.springmvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppMainServletV1 extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { AppHibernateConfig.class, AppOtherConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { AppMvcConfigV1.class };
    }

    @Override
    protected String getServletName() {
        return AppMainServletV1.class.getSimpleName();
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/v1/*" };
    }

}
