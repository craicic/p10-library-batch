package com.gg.proj.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProfileConsumer {

    private ProfileConnector profileConnector;

    public ProfileConsumer() {
    }

    @Autowired
    public ProfileConsumer(ProfileConnector profileConnector) {
        this.profileConnector = profileConnector;
    }
}
