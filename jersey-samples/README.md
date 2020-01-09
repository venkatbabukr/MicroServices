# Overview
All Jersey sample apps are available here

# Simple Application
Quick links for following:

1. Deployment Descriptor
    * [web.xml](jersey-simple/src/main/webapp/WEB-INF/web.xml)
    * [Servlet configuration](jersey-simple/src/main/webapp/WEB-INF/web.xml#L9-L25): One of the two init-params can be used
      * javax.ws.rs.Application
      * jersey.config.server.provider.packages
2. Core Java Code
    * [Extending ResourceConfig: JerseySimpleResourceConfig](jersey-simple/src/main/java/com/venkat/rest/simple/resources/JerseySimpleResourceConfig.java)
2. Jackson integration
    * [POM changes](jersey-simple/pom.xml#L32-L35)
    * [org.glassfish.jersey.jackson.JacksonFeature](http://javadox.com/org.glassfish.jersey.media/jersey-media-json-jackson/2.8/org/glassfish/jersey/jackson/JacksonFeature.html) gets registered as a [javax.ws.rs.core.Feature](https://docs.oracle.com/javaee/7/api/javax/ws/rs/core/Feature.html)
      * See [org.glassfish.jersey.jackson.internal.JacksonAutoDiscoverable](http://javadox.com/org.glassfish.jersey.media/jersey-media-json-jackson/2.12/org/glassfish/jersey/jackson/internal/JacksonAutoDiscoverable.html) for more details
3. Grizzly integration
    * [POM changes](jersey-simple/pom.xml#L28-L31)
    * [Java main program: JerseySimpleMain](jersey-simple/src/main/java/com/venkat/rest/simple/app/JerseySimpleMain.java#L17-L28)
      * Create a [org.glassfish.jersey.server.ResourceConfig](http://javadox.com/org.glassfish.jersey.bundles/apidocs/2.11/org/glassfish/jersey/server/ResourceConfig.html)
      * Create ```org.glassfish.grizzly.http.server.HttpServer``` using [org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory](http://javadox.com/org.glassfish.jersey.bundles/apidocs/2.11/org/glassfish/jersey/grizzly2/httpserver/GrizzlyHttpServerFactory.html)
5. Dependency Injection using HK2
    * Use @Inject annotation: See [ResourcesV1](jersey-simple/src/main/java/com/venkat/rest/simple/resources/ResourcesV1.java#L14-15)
    * Register Injectables
      * Create and register an [Binder](jersey-simple/src/main/java/com/venkat/rest/simple/resources/JerseySimpleResourceConfig.java#L24-31) that extends ```org.glassfish.hk2.utilities.binding.AbstractBinder```
      * Register all bindings in the overridden configure() function
    * Binding scopes
      * Singleton
6. Versioning support:
    * [Nested paths example](jersey-simple/src/main/java/com/venkat/rest/simple/resources/ResourcesV1.java#L17-L20)
    * [Resources V1](jersey-simple/src/main/java/com/venkat/rest/simple/resources/ResourcesV1.java)
    * [Resources V2](jersey-simple/src/main/java/com/venkat/rest/simple/resources/ResourcesV2.java)
7. Validations
8. Exception handling
