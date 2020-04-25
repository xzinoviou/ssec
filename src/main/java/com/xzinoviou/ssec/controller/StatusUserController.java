package com.xzinoviou.ssec.controller;

import com.xzinoviou.ssec.dto.StatusDto;
import com.xzinoviou.ssec.util.StatusUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class StatusUserController {

    private final StatusUtil statusUtil;

    public StatusUserController(StatusUtil statusUtil) {
        this.statusUtil = statusUtil;
    }

    @GetMapping
    public ResponseEntity<List<StatusDto>> getUserAuthStatuses() {
        return ResponseEntity.ok(statusUtil.getStatuses());
    }
}
