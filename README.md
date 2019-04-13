# Batch for the library project  
  
## Description  
  
TODO
  
## Technologies  
  
This application has been started via [Spring Initializr](https://start.spring.io/).  
  
TODO

## Execution

##### 1 - Configure the application

Create `src\main\resources\application.properties`. 

Write the following properties to configure Spring Mail :\
`spring.mail.host`
`spring.mail.port`
`spring.mail.username`
`spring.mail.password`
`spring.mail.properties.mail.smtp.auth=true`
`spring.mail.properties.mail.smtp.starttls.enable=true`\
 
 Then add the wsdl location `batch.webservice.uri`, depending the port you choose it should be `http://localhost:8080/{your-webservice-context-folder}/ws`
 
##### 2 - Compile the application

Using the command with parameter `mvn -Dwsdl.base.location=http://localhost:8080/{your-webservice-context-folder}/ws compile`

##### 3 - Run the app

With your IDE or with this command line : `java -jar ./library-batch-0.0.1-SNAPSHOT.jar`