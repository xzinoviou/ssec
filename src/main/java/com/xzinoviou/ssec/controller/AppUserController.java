package com.xzinoviou.ssec.controller;

import com.xzinoviou.ssec.domain.jpa.AppUser;
import com.xzinoviou.ssec.dto.AppUserRequestDto;
import com.xzinoviou.ssec.mapper.GenericMapper;
import com.xzinoviou.ssec.service.AppUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/app-user")
public class AppUserController {


    private final AppUserService appUserService;

    private final GenericMapper<AppUser, AppUserRequestDto> mapper;

    public AppUserController(AppUserService appUserService, GenericMapper<AppUser, AppUserRequestDto> mapper) {
        this.appUserService = appUserService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<AppUser> saveAppUser(HttpServletRequest request, @RequestBody AppUserRequestDto dto) {
        return new ResponseEntity<>(appUserService.createAppUser(mapper.convertToEntity(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AppUser>> getAllAppUsers() {
        return ResponseEntity.ok(appUserService.findAllAppUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppUser> getAppUserById(@PathVariable Long id) {
        return ResponseEntity.ok(appUserService.findById(id));
    }
}
