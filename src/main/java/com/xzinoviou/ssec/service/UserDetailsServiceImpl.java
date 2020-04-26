package com.xzinoviou.ssec.service;

import com.xzinoviou.ssec.domain.JpaUserDetails;
import com.xzinoviou.ssec.repository.AppUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AppUserRepository appUserRepository;

    public UserDetailsServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails jpaUserDetails = new JpaUserDetails(appUserRepository.findByUsername(username).orElseThrow(() -> new RuntimeException(username)));

        return jpaUserDetails;
    }

}
