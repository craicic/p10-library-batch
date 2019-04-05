package com.gg.proj.utils;

import com.gg.proj.consumer.wsdl.profiles.UserMin;
import com.gg.proj.model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    private static UserModel userMinToUserModel(UserMin user) {

        if (user == null)
            return null;

        UserModel userModel = new UserModel();
        userModel.setFirstName(user.getFirstName());
        userModel.setLastName(user.getLastName());
        userModel.setMailAdress(user.getMailAddress());

        return userModel;
    }

    public static List<UserModel> toUserModelList(List<UserMin> users) {
        if (users == null)
            return null;
        List<UserModel> userModelList = new ArrayList<>(users.size());

        for (UserMin userMin : users) {
            userModelList.add(UserMapper.userMinToUserModel(userMin));
        }
        return userModelList;
    }
}
