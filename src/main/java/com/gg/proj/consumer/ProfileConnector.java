package com.gg.proj.consumer;

import com.gg.proj.consumer.wsdl.profiles.ListLateProfilesRequest;
import com.gg.proj.consumer.wsdl.profiles.ListLateProfilesResponse;
import com.gg.proj.consumer.wsdl.profiles.UserMin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.util.List;

public class ProfileConnector extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(ProfileConnector.class);

    private static final String SERVICE_LOCATION = "http://localhost:8080/ws/profiles";

    public List<UserMin> listLateUser() {
        ListLateProfilesRequest request = new ListLateProfilesRequest();
        log.info("Requesting profiles from user that are late ...");

        ListLateProfilesResponse response = (ListLateProfilesResponse) getWebServiceTemplate().
                marshalSendAndReceive(SERVICE_LOCATION, request,
                        new SoapActionCallback("http://proj.gg.com/service/library-client"));

        return response.getUsers();
    }
}
