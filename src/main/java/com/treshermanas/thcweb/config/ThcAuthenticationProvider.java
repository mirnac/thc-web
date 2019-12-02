package com.treshermanas.thcweb.config;

import com.treshermanas.thcweb.beans.users.UserDto;
import com.treshermanas.thcweb.services.auth.AuthService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ThcAuthenticationProvider implements AuthenticationProvider {

    private final AuthService authService;

    public ThcAuthenticationProvider(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        if (shouldAuthenticateAgainstThirdPartySystem(name,password)) {

            try{
                UserDto user = authService.authenticateUser(name,password);
                /*List<SimpleGrantedAuthority> permissions = new ArrayList<>();
                user.getRights().forEach(rightDefinitionDto ->
                        permissions.add(new SimpleGrantedAuthority(rightDefinitionDto.getLabel()))
                );*/
                return new UsernamePasswordAuthenticationToken(
                        name, password, new ArrayList<>());

            }catch (com.treshermanas.thcweb.exception.AuthenticationException ae){
                throw new BadCredentialsException(ae.getLocalizedMessage());
            }

        } else {
            return null;
        }
    }

    private boolean shouldAuthenticateAgainstThirdPartySystem(String userName, String password) {

            return true;
    }

    @Override
    public boolean supports(Class<?> authentication) {
         return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
