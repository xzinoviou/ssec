package com.xzinoviou.ssec.service;

import com.xzinoviou.ssec.domain.jpa.AppUser;
import com.xzinoviou.ssec.domain.jpa.Role;
import com.xzinoviou.ssec.repository.AppUserRepository;
import com.xzinoviou.ssec.repository.RoleRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Transactional
@Service
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    public AppUserServiceImpl(AppUserRepository appUserRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AppUser createAppUser(AppUser appUser) {

        Set<Long> ids = appUser.getRoles().stream().map(Role::getId).collect(Collectors.toSet());

        Set<Role> roles = roleRepository.findRolesByIdsIn(ids);

        appUser.setRoles(roles);

        String passwordEncoded = passwordEncoder.encode(appUser.getPassword());

        appUser.setPassword(passwordEncoded);

        return appUserRepository.save(appUser);
    }

    @Override
    public List<AppUser> findAllAppUsers() {
        return appUserRepository.findAll();
    }

    @Override
    public AppUser findById(Long id) {
        return appUserRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found : " + id));
    }
}
