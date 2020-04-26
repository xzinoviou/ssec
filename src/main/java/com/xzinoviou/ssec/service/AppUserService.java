package com.xzinoviou.ssec.service;

import com.xzinoviou.ssec.domain.jpa.AppUser;

import java.util.List;

public interface AppUserService {

    AppUser createAppUser(AppUser appUser);

    List<AppUser> findAllAppUsers();

    AppUser findById(Long id);
}
