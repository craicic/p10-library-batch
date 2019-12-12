# Batch for the [library project](https://github.com/xxjokerx/p10-library)  
  
## Description  
  
Batch's mission is to call the web service to get all users that have a 
late loan, then send a reminder mail to each of those users.

## Technologies  
  
This application has been started via [Spring Initializr](https://start.spring.io/).  
  
To consume the WSDL it uses **JAX-B2 and Spring-WS** to connect the web service.
**Spring Batch** is added to create Jobs (we use the Tasklet approach).
Finally **Spring annotation processor** is included to manage custom properties in the application.properties.

## Execution

##### 1 - Configure the application

Create `src\main\resources\application.properties`. 

Write the following properties to configure Spring Mail :\
`spring.mail.host`\
`spring.mail.port`\
`spring.mail.username`\
`spring.mail.password`\
`spring.mail.properties.mail.smtp.auth=true`\
`spring.mail.properties.mail.smtp.starttls.enable=true`
 
 Then add the wsdl location `batch.webservice.uri`, depending the port you choose it should be `http://localhost:8080/{your-webservice-context-folder}/{webservice.location}`
 
##### 2 - Compile the application

Using the command with parameter `mvn -Dwsdl.base.location=http://localhost:8080/{your-webservice-context-folder}/{webservice.location} compile`

##### 3 - Run the app

With your IDE or with this command line : `java -jar ./library-batch-1.0.0.jar`

## Release notes

##### 1.0.0

Send a reminder to each user that have a late loan.
