package com.gg.proj.consumer;

import com.gg.proj.config.ConsumerProperties;
import com.gg.proj.consumer.wsdl.profiles.ListLateProfilesRequest;
import com.gg.proj.consumer.wsdl.profiles.ListLateProfilesResponse;
import com.gg.proj.consumer.wsdl.profiles.UserMin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.WebServiceMessageFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.util.List;

/**
 *
 * Consumer connector's class
 */
public class ProfileConnector extends WebServiceGatewaySupport {

    private ConsumerProperties properties;

    private static final Logger log = LoggerFactory.getLogger(ProfileConnector.class);

    private String service_location;

    @Autowired
    public ProfileConnector(ConsumerProperties properties) {
        this.properties = properties;
        service_location = this.properties.getUri() + "/profiles";
    }

    public ProfileConnector(WebServiceMessageFactory messageFactory, @Autowired ConsumerProperties properties) {
        super(messageFactory);
        this.properties = properties;
        service_location = this.properties.getUri() + "/profiles";

    }

    /**
     *
     * <p>Directly call the Web-service's method listAllProfiles() from the Profile service. It ask the WS to provide
     * the list of all late users.</p>
     *
     * @return a list of UserMin (a DTO)
     */
    List<UserMin> listLateUser() {

        ListLateProfilesRequest request = new ListLateProfilesRequest();
        log.info("Requesting profiles from user that are late ...");

        ListLateProfilesResponse response = (ListLateProfilesResponse) getWebServiceTemplate().
                marshalSendAndReceive(service_location, request,
                        new SoapActionCallback("http://proj.gg.com/service/library-client"));

        return response.getUsers();
    }
}
