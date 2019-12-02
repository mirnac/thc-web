package com.treshermanas.thcweb.services.auth;

import com.treshermanas.thcweb.beans.users.UserDto;
import com.treshermanas.thcweb.exception.ThcServiceException;
import com.treshermanas.thcweb.services.auth.requests.AuthReq;
import com.treshermanas.thcweb.utils.ThcDigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.security.NoSuchAlgorithmException;

@Service
public class AuthServiceImpl implements AuthService {

    @Value("${thc-api.password.salt}")
    private String salt;

    @Value("${backend.base.url}")
    private String baseUrl;

    private final RestTemplate restTemplate;

    public AuthServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public UserDto authenticateUser(String userName, String password) {
        try {

            String passwordDigest = ThcDigestUtils.getSha256(password + salt);
            AuthReq authReq = new AuthReq(userName, passwordDigest);
            HttpEntity<AuthReq> requestData = new HttpEntity<>(authReq);
            String url = baseUrl + AUTH_PATH;
            return restTemplate.postForObject(url, requestData, UserDto.class);

        }catch (NoSuchAlgorithmException e){
            throw new ThcServiceException("Error trying to digest password");
        }
    }
}
