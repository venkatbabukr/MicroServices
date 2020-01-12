# Overview
All Jersey sample apps are available here

# Simple Application
Quick links for following:

1. Deployment Descriptor
    * [web.xml](jersey-simple/src/main/webapp/WEB-INF/web.xml)
    * [Servlet configuration](jersey-simple/src/main/webapp/WEB-INF/web.xml#L9-L25):
      * [org.glassfish.jersey.servlet.ServletContainer](http://javadox.com/org.glassfish.jersey.containers/jersey-container-servlet-core/2.7/org/glassfish/jersey/servlet/ServletContainer.html) should be used
      * One of the two &lt;init-params&gt; can be used
        * javax.ws.rs.Application
        * jersey.config.server.provider.packages
2. Core Java Code
    * Extending ResourceConfig: [JerseySimpleResourceConfig](jersey-simple/src/main/java/com/venkat/rest/simple/resources/JerseySimpleResourceConfig.java)
    * Resources & annotations: [UsersResourceTemplate](jersey-simple/src/main/java/com/venkat/rest/simple/resources/UsersResourceTemplate.java), [ResourcesV1](jersey-simple/src/main/java/com/venkat/rest/simple/resources/ResourcesV1.java), [ResourcesV2](jersey-simple/src/main/java/com/venkat/rest/simple/resources/ResourcesV2.java)
      * APIs created
        * [GET /users](jersey-simple/src/main/java/com/venkat/rest/simple/resources/UsersResourceTemplate.java#L31-35)
        * [GET /users/{id}](jersey-simple/src/main/java/com/venkat/rest/simple/resources/UsersResourceTemplate.java#L37-42)
        * [GET /users/search](jersey-simple/src/main/java/com/venkat/rest/simple/resources/v1/UsersResource.java#L27-33)
        * [POST /users](jersey-simple/src/main/java/com/venkat/rest/simple/resources/UsersResourceTemplate.java#L44-51)
      * Annotations used: [@Path](jersey-simple/src/main/java/com/venkat/rest/simple/resources/UsersResourceTemplate.java#L38), [@GET](jersey-simple/src/main/java/com/venkat/rest/simple/resources/UsersResourceTemplate.java#L37), [@POST](jersey-simple/src/main/java/com/venkat/rest/simple/resources/UsersResourceTemplate.java#L44), [@PathParam](jersey-simple/src/main/java/com/venkat/rest/simple/resources/UsersResourceTemplate.java#L40), [@QueryParam](), [@BeanParam](jersey-simple/src/main/java/com/venkat/rest/simple/resources/v1/UsersResource.java#L31)
3. Jackson integration
    * [POM changes](jersey-simple/pom.xml#L32-L35): Use one of the following -
      * Use [jersey-media-moxy](https://mvnrepository.com/artifact/org.glassfish.jersey.media/jersey-media-moxy) - default recommended
      * Use [jersey-media-json-jackson](https://mvnrepository.com/artifact/org.glassfish.jersey.media/jersey-media-json-jackson)
    * [org.glassfish.jersey.jackson.JacksonFeature](http://javadox.com/org.glassfish.jersey.media/jersey-media-json-jackson/2.8/org/glassfish/jersey/jackson/JacksonFeature.html) gets registered as a [javax.ws.rs.core.Feature](https://docs.oracle.com/javaee/7/api/javax/ws/rs/core/Feature.html)
      * See [org.glassfish.jersey.jackson.internal.JacksonAutoDiscoverable](http://javadox.com/org.glassfish.jersey.media/jersey-media-json-jackson/2.12/org/glassfish/jersey/jackson/internal/JacksonAutoDiscoverable.html) for more details
4. Grizzly integration
    * [POM changes](jersey-simple/pom.xml#L28-L31)
    * Java main program: [JerseySimpleMain](jersey-simple/src/main/java/com/venkat/rest/simple/app/JerseySimpleMain.java#L17-L28)
      * Create instance of [JerseySimpleResourceConfig](jersey-simple/src/main/java/com/venkat/rest/simple/resources/JerseySimpleResourceConfig.java) that extends [org.glassfish.jersey.server.ResourceConfig](http://javadox.com/org.glassfish.jersey.bundles/apidocs/2.11/org/glassfish/jersey/server/ResourceConfig.html)
      * Create ```org.glassfish.grizzly.http.server.HttpServer``` using [org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory](http://javadox.com/org.glassfish.jersey.bundles/apidocs/2.11/org/glassfish/jersey/grizzly2/httpserver/GrizzlyHttpServerFactory.html)
5. Dependency Injection using HK2
    * Use @Inject annotation: See [ResourcesV1](jersey-simple/src/main/java/com/venkat/rest/simple/resources/ResourcesV1.java#L14-15)
    * Register Injectables
      * Create and register a [Binder](jersey-simple/src/main/java/com/venkat/rest/simple/resources/JerseySimpleResourceConfig.java#L24-31) that extends ```org.glassfish.hk2.utilities.binding.AbstractBinder```
      * Register all bindings in the overridden [configure()](jersey-simple/src/main/java/com/venkat/rest/simple/resources/JerseySimpleResourceConfig.java#L27-L30) function
    * Binding scopes
      * org.glassfish.hk2.api.PerLookup
      * org.glassfish.hk2.api.PerThread
      * org.glassfish.jersey.process.internal.RequestScoped
      * javax.inject.Singleton
      * org.glassfish.hk2.api.Immediate
6. Versioning support:
    * [Nested paths example](jersey-simple/src/main/java/com/venkat/rest/simple/resources/ResourcesV1.java#L17-L20)
    * [Resources V1](jersey-simple/src/main/java/com/venkat/rest/simple/resources/ResourcesV1.java)
    * [Resources V2](jersey-simple/src/main/java/com/venkat/rest/simple/resources/ResourcesV2.java)
7. Validations
8. Exception handling
    * Create [ServiceErrorCode](jersey-simple/src/main/java/com/venkat/rest/simple/exceptions/ServiceErrorCode.java) - an enum of all codes of service errors possible
    * Create [JSONWebApplicationException](jersey-simple/src/main/java/com/venkat/rest/simple/exceptions/JSONWebApplicationException.java) that extends [javax.ws.rs.WebApplicationException](https://docs.oracle.com/javaee/7/api/javax/ws/rs/WebApplicationException.html)
    * When exception has to be thrown, throw a new instance of JSONWebApplicationException with suitable ServiceErrorCode. Examples:
      * [UsersServiceTemplate#getUserById](jersey-simple/src/main/java/com/venkat/rest/simple/services/UsersServiceTemplate.java#L35-L38)
    * [Constructor](jersey-simple/src/main/java/com/venkat/rest/simple/exceptions/JSONWebApplicationException.java#L12-L17) in JSONWebApplicationException will convert ServiceErrorCode into suitable [javax.ws.rs.core.Response](https://docs.oracle.com/javaee/7/api/javax/ws/rs/core/Response.html) object...
    * [javax.ws.rs.WebApplicationException](https://docs.oracle.com/javaee/7/api/javax/ws/rs/WebApplicationException.html) hierarchy:
      * [javax.ws.rs.ClientErrorException](https://docs.oracle.com/javaee/7/api/javax/ws/rs/ClientErrorException.html)
      * [javax.ws.rs.ServerErrorException](https://docs.oracle.com/javaee/7/api/javax/ws/rs/ServerErrorException.html)
9. Testing
10. Internationalization
