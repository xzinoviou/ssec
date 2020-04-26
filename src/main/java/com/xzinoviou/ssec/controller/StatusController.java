package com.xzinoviou.ssec.controller;

import com.xzinoviou.ssec.dto.StatusDto;
import com.xzinoviou.ssec.util.StatusUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@RestController
@RequestMapping("/")
public class StatusController {


    private WebApplicationContext webApplicationContext;

    private SecurityContext securityContext;

    private final StatusUtil statusUtil;


    public StatusController(WebApplicationContext webApplicationContext, SecurityContext securityContext, StatusUtil statusUtil) {
        this.webApplicationContext = webApplicationContext;
        this.securityContext = securityContext;
        this.statusUtil = statusUtil;
    }

    @GetMapping
    public ResponseEntity<List<StatusDto>> getStatuses() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return ResponseEntity.ok(statusUtil.getStatuses());
    }

}
