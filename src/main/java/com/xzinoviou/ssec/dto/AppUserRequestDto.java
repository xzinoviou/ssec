package com.xzinoviou.ssec.dto;

import com.xzinoviou.ssec.domain.jpa.Role;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class AppUserRequestDto implements Serializable {

    private String firstName;

    private String lastName;

    private String email;

    private String username;

    private String password;

    private Set<Role> roles;

    public AppUserRequestDto() {
    }

    public AppUserRequestDto(String firstName, String lastName, String email,
                             String username, String password, Set<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Set<Role> getRoles() {
        return roles;
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
