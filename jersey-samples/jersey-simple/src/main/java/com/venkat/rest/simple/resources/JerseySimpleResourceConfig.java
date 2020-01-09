package com.venkat.rest.simple.resources;

import javax.inject.Singleton;
import javax.ws.rs.ApplicationPath;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

import com.venkat.rest.simple.services.UsersServiceV1;
import com.venkat.rest.simple.services.UsersServiceV2;

// TODO: Need to see why this is still not working ...
@ApplicationPath(JerseySimpleResourceConfig.APPLICATION_BASE_PATH)
public class JerseySimpleResourceConfig extends ResourceConfig {

    public static final String APPLICATION_BASE_PATH = "/rest";
    
    public JerseySimpleResourceConfig() {
        packages(JerseySimpleResourceConfig.class.getPackage().getName());

        register(UsersServiceV1.class);
        register(UsersServiceV2.class);

        register(new AbstractBinder() {
            
            @Override
            protected void configure() {
                bindAsContract(UsersServiceV1.class).in(Singleton.class);
                bindAsContract(UsersServiceV2.class).in(Singleton.class);
            }
        });
    }

}
