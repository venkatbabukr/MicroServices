# Overview
All Jersey sample apps are available here

# Simple Application
Quick links for following:

1. Deployment Descriptor [web.xml](jersey-simple/src/main/webapp/WEB-INF/web.xml)
    * [Servlet configuration](jersey-simple/src/main/webapp/WEB-INF/web.xml#L9-L25)
2. Core Java Code
    * [Extending ResourceConfig](jersey-simple/src/main/java/com/venkat/rest/simple/app/JerseySimpleRestServicesApplication.java)
2. [Jackson integration](jersey-simple/pom.xml#L32-L35)
3. Grizzly integration
    * [POM changes](jersey-simple/pom.xml#L28-L31)
    * [Java main program](jersey-simple/src/main/java/com/venkat/rest/simple/app/JerseySimpleMain.java)
5. Versioning support:
    * [Nested paths example](jersey-simple/src/main/java/com/venkat/rest/simple/services/ServicesV2.java#L12-L15)
    * [Services V1](jersey-simple/src/main/java/com/venkat/rest/simple/services/ServicesV1.java)
    * [Services V2](jersey-simple/src/main/java/com/venkat/rest/simple/services/ServicesV2.java)
6. Validations
