package com.xzinoviou.ssec.controller;

import com.xzinoviou.ssec.domain.jpa.AppUser;
import com.xzinoviou.ssec.dto.AppUserRequestDto;
import com.xzinoviou.ssec.service.AppUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app-user")
public class AppUserController {


    private final AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @PostMapping
    public ResponseEntity<AppUser> saveAppUser(@RequestBody AppUserRequestDto dto) {
        return new ResponseEntity<>(appUserService.createAppUser(convertDtoToEntity(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AppUser>> getAllAppUsers() {
        return ResponseEntity.ok(appUserService.fineAllAppUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppUser> getAppUserById(@PathVariable Long id) {
        return ResponseEntity.ok(appUserService.findById(id));
    }

    private AppUser convertDtoToEntity(AppUserRequestDto dto) {
        AppUser appUser = new AppUser();
        appUser.setFirstName(dto.getFirstName());
        appUser.setLastName(dto.getLastName());
        appUser.setUsername(dto.getUsername());
        appUser.setPassword(dto.getPassword());
        appUser.setEmail(dto.getEmail());
        appUser.setEnabled(true);
        appUser.setExpired(false);
        appUser.setRoles(dto.getRoles());
        return appUser;
    }
}
