package com.gg.proj.consumer;

import com.gg.proj.model.UserModel;
import com.gg.proj.utils.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * Consumer class
 */
@Component
public class ProfileConsumer {

    private ProfileConnector profileConnector;

    public ProfileConsumer() {
    }

    @Autowired
    public ProfileConsumer(ProfileConnector profileConnector) {
        this.profileConnector = profileConnector;
    }

    public List<UserModel> listLateUser() {
        return UserMapper.toUserModelList(profileConnector.listLateUser());
    }

}
