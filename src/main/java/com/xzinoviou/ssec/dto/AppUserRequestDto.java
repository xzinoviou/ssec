package com.xzinoviou.ssec.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class AppUserRequestDto implements Serializable {

    private String firstName;

    private String lastName;

    private String email;

    private String username;

    private String password;

    private Set<RoleDto> roles;

    public AppUserRequestDto() {
        this.roles = new HashSet<>();
    }

    public AppUserRequestDto(String firstName, String lastName, String email,
                             String username, String password, Set<RoleDto> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.roles = new HashSet<>();
        this.roles.addAll(roles);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<RoleDto> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleDto> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUserRequestDto that = (AppUserRequestDto) o;
        return firstName.equals(that.firstName) &&
                lastName.equals(that.lastName) &&
                email.equals(that.email) &&
                username.equals(that.username) &&
                password.equals(that.password) &&
                roles.equals(that.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, username, password, roles);
    }
}
