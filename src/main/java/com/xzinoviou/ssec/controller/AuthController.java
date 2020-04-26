package com.xzinoviou.ssec.controller;

import com.xzinoviou.ssec.dto.AuthRequestDto;
import com.xzinoviou.ssec.dto.JwtDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @PostMapping("/authorize")
    public ResponseEntity<JwtDto> authorize(AuthRequestDto authRequestDto) {
        return new ResponseEntity<>();
    }
}
