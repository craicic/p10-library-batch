package com.gg.proj.config;

import com.gg.proj.consumer.ProfileConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
@EnableConfigurationProperties
public class ConsumerConfiguration {

    private ConsumerProperties consumerProperties;

    @Autowired
    public ConsumerConfiguration(ConsumerProperties consumerProperties) {
        this.consumerProperties = consumerProperties;
    }

    @Bean
    public Jaxb2Marshaller profileMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("com.gg.proj.consumer.wsdl.profiles");
        return marshaller;
    }

    @Bean
    public ProfileConnector profileConnector(@Autowired Jaxb2Marshaller profileMarshaller) {
        ProfileConnector client = new ProfileConnector();
        client.setDefaultUri(consumerProperties.getUri());
        client.setMarshaller(profileMarshaller);
        client.setUnmarshaller(profileMarshaller);
        return client;
    }
}
