package com.venkat.rest.simple.app;

import org.glassfish.jersey.server.ResourceConfig;

import com.venkat.rest.simple.services.ServicesBase;

public class JerseySimpleRestServicesApplication extends ResourceConfig {
    
    public JerseySimpleRestServicesApplication() {
        packages(ServicesBase.class.getPackage().getName());
    }

}
