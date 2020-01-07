# Overview
All Jersey sample apps are available here

# Simple Application
Quick links for following:

1. Deployment Descriptor
    * [web.xml](jersey-simple/src/main/webapp/WEB-INF/web.xml)
    * [Servlet configuration](jersey-simple/src/main/webapp/WEB-INF/web.xml#L9-L25)
2. Core Java Code
    * [Extending ResourceConfig](jersey-simple/src/main/java/com/venkat/rest/simple/app/JerseySimpleRestServicesApplication.java)
2. Jackson integration
    * [POM changes](jersey-simple/pom.xml#L32-L35)
    * [org.glassfish.jersey.jackson.JacksonFeature](http://javadox.com/org.glassfish.jersey.media/jersey-media-json-jackson/2.8/org/glassfish/jersey/jackson/JacksonFeature.html) gets registered as a [javax.ws.rs.core.Feature](https://docs.oracle.com/javaee/7/api/javax/ws/rs/core/Feature.html)
3. Grizzly integration
    * [POM changes](jersey-simple/pom.xml#L28-L31)
    * [Java main program](jersey-simple/src/main/java/com/venkat/rest/simple/app/JerseySimpleMain.java)
      * Create a [org.glassfish.jersey.server.ResourceConfig](http://javadox.com/org.glassfish.jersey.bundles/apidocs/2.11/org/glassfish/jersey/server/ResourceConfig.html)
      * Create ```org.glassfish.grizzly.http.server.HttpServer``` using [org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory](http://javadox.com/org.glassfish.jersey.bundles/apidocs/2.11/org/glassfish/jersey/grizzly2/httpserver/GrizzlyHttpServerFactory.html)
5. Versioning support:
    * [Nested paths example](jersey-simple/src/main/java/com/venkat/rest/simple/services/ServicesV2.java#L12-L15)
    * [Services V1](jersey-simple/src/main/java/com/venkat/rest/simple/services/ServicesV1.java)
    * [Services V2](jersey-simple/src/main/java/com/venkat/rest/simple/services/ServicesV2.java)
6. Validations
7. Exception handling
