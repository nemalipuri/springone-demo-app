#  springone-demo-app
---------------------

## Modernizing The Legacy
This repository contains source code and examples from the _SpringOne Platform 2016_ presentation, 
"_Modernizing the Legacy - How Dish is Adapting its SOA Services for a Cloud First Future_" presented by Rob Bennett, Laxmikant Rastogi and [Chandra Nemalipuri](https://github.com/nemalipuri).


## Introduction
This app is for demonstrating the technologies and processes we use at Dish to build Cloud Native applications.


## Implementation
Demo app covers following implementations/configurations:
- Spring Boot application
- Gradle
- Exposing a SOAP and REST service(providers)
- Connecting multiple Relational Databases(Oracle JDBC Driver)
- Swagger
- Manifest file(s) for deploying the app into Pivotal Cloud Foundry
- Spring Cloud Config
- Spring Cloud Sleuth and Zipkin
- CI/CD pipelines and deploying app into PCF
- Simulator using Ruby([adapter-api-simulator](https://github.com/nemalipuri/adapter-api-simulator) for simulating dependency app)
- And runthrough Dish development cycle(12 Factor App --> Gitlab --> Jenkins CI --> Artifactory --> Jenkins CD --> App is live in PCF --> Query and visualize data using ELKK Stack and Zipkin)


## Build
1. If you are building in Dish update build.gradle to use internal artifacts repo before build.

    ```
    $ gradle clean build
    ```

## Running locally:
1. Run either adapter-api-app(Dish internal) or [adapter-api-simulator](https://github.com/nemalipuri/adapter-api-simulator)(public project in Github)
2. Update adapter uri accordingly in application.yml
3. Create a run configuration with the following environment variable: spring.profiles.active=dev-local

    ```
    $ gradle bootRun -Dspring.profiles.active=dev-local
    ```
4. SOAP endpoint: http://localhost:8084/ws/Demo.v1_0:demoWS


## Sample Request/Response:
The app takes a SOAP request like this:
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:demo="http://www.dish.com/wsdl/Demo/Demo-v1.0">
   <soapenv:Header/>
   <soapenv:Body>
      <demo:getTaxQuoteRequest>
         <demo:serviceRequestContext>
            <serviceInteraction>
               <interactionId>i192351734</interactionId>
               <interactionProcessName>demo_request</interactionProcessName>
               <requestId>r9514990</requestId>
               <interactionStep>test</interactionStep>
               <customerFacingTool>SOAPUI</customerFacingTool>
            </serviceInteraction>
            <serviceClientDetails>
               <clientAppHost>localhost</clientAppHost>
               <clientAppTimestamp>2016-07-20T14:25:39.959 MDT</clientAppTimestamp>
               <!--Optional:-->
               <endUserIPAddress>?</endUserIPAddress>
            </serviceClientDetails>
            <!--Optional:-->
            <requestReceivedTimestamp>?</requestReceivedTimestamp>
         </demo:serviceRequestContext>
         <demo:getTaxQuoteInput>
            <location>
               <geographical>
                  <vertexCode>391110000</vertexCode>
               </geographical>
            </location>
            <itemList>
               <count>1</count>
               <!--1 or more repetitions:-->
               <item>
                  <identifier>!+</identifier>
                  <billing>
                     <charge>99.00</charge>
                     <!--Optional:-->
                     <taxGroup>?</taxGroup>
                  </billing>
               </item>
            </itemList>
         </demo:getTaxQuoteInput>
      </demo:getTaxQuoteRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

and will return a SOAP response like this:
```xml
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header/>
   <SOAP-ENV:Body>
      <ns3:getTaxQuoteResponse xmlns:ns3="http://www.dish.com/wsdl/Demo/Demo-v1.0">
         <ns3:serviceResponseContext>
            <interactionId>i192351734</interactionId>
            <requestId>r9514990</requestId>
            <requestReceivedTimestamp>2016-07-20T15:05:55.309 MDT</requestReceivedTimestamp>
            <responseGeneratedTimestamp>2016-07-20T15:05:55.697 MDT</responseGeneratedTimestamp>
            <serverHostPort>localhost</serverHostPort>
            <serviceDuration>388</serviceDuration>
            <statusCode>0</statusCode>
            <statusMessage/>
            <displayMessage/>
         </ns3:serviceResponseContext>
         <ns3:getTaxQuoteOutput>
            <taxQuote>5.94</taxQuote>
            <itemList>
               <count>1</count>
               <item>
                  <identifier>!+</identifier>
                  <billing>
                     <charge>99.00</charge>
                     <taxGroup>10</taxGroup>
                  </billing>
               </item>
            </itemList>
         </ns3:getTaxQuoteOutput>
      </ns3:getTaxQuoteResponse>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```
