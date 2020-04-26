package com.xzinoviou.ssec.domain.model;

import com.xzinoviou.ssec.domain.jpa.AppUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Service
public class JpaUserDetails implements UserDetails {

    private String username;
    private String password;
    private boolean enabled;
    private boolean expired;
    private Collection<? extends GrantedAuthority> authorities;

    public JpaUserDetails() {
    }

    public JpaUserDetails(AppUser appUser) {
        this.username = appUser.getUsername();
        this.password = appUser.getPassword();
        this.enabled = appUser.isEnabled();
        this.expired = appUser.isExpired();
        this.authorities = createAuthorities(appUser);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !expired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }


    private Collection<? extends GrantedAuthority> createAuthorities(AppUser appUser) {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
//        return appUser.getRoles().stream()
//                .map(r -> new SimpleGrantedAuthority("ROLE_" + r.getRoleType().name()))
//                .collect(Collectors.toList());
    }
}
