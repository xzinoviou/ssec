package com.xzinoviou.ssec.controller;

import com.xzinoviou.ssec.dto.AuthRequestDto;
import com.xzinoviou.ssec.dto.JwtDto;
import com.xzinoviou.ssec.jwt.JwtService;
import com.xzinoviou.ssec.service.UserDetailsServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    public AuthController(AuthenticationManager authenticationManager, JwtService jwtService, UserDetailsServiceImpl userDetailsServiceImpl) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsServiceImpl;
    }

    @PostMapping("/authorize")
    public ResponseEntity<JwtDto> authorize(@RequestBody AuthRequestDto authRequestDto) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDto.getUsername(), authRequestDto.getPassword()));
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Bad credentials");
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequestDto.getUsername());

        final JwtDto jwt = new JwtDto(jwtService.generateToken(userDetails));

        return new ResponseEntity<>(jwt, HttpStatus.CREATED);
    }
}
