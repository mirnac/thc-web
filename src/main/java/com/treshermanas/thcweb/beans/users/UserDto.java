package com.treshermanas.thcweb.beans.users;

import java.util.HashSet;
import java.util.Set;

public class UserDto {

    private String login;
    private String lastName;
    private String firstName;
    private String email;
    private Boolean admin;
    private Boolean active;
    private String mobileNumber;
    private Set<RightDefinitionDto> rights;

    public UserDto() {
        rights = new HashSet<>();
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Set<RightDefinitionDto> getRights() {
        return rights;
    }

    public void setRights(Set<RightDefinitionDto> rights) {
        this.rights = rights;
    }
}
