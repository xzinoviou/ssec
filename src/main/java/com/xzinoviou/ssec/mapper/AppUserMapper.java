package com.xzinoviou.ssec.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xzinoviou.ssec.domain.jpa.AppUser;
import com.xzinoviou.ssec.dto.AppUserRequestDto;
import org.springframework.stereotype.Component;

@Component
public class AppUserMapper implements GenericMapper<AppUser, AppUserRequestDto> {

    private final ObjectMapper objectMapper;

    public AppUserMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public AppUserRequestDto mapToDto(AppUser appUser) {
        return objectMapper.convertValue(appUser, AppUserRequestDto.class);
    }

    @Override
    public AppUser convertToEntity(AppUserRequestDto appUserRequestDto) {
        AppUser appUser = objectMapper.convertValue(appUserRequestDto, AppUser.class);
        appUser.setEnabled(true);
        appUser.setExpired(false);
        return appUser;
    }
}
