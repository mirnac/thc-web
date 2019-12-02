package com.treshermanas.thcweb.services.auth;

import com.treshermanas.thcweb.beans.users.UserDto;

public interface AuthService {

    String AUTH_PATH = "/auth";

    UserDto authenticateUser(String userName, String password) ;
}
