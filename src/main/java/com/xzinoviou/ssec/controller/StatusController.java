package com.xzinoviou.ssec.controller;

import com.xzinoviou.ssec.dto.StatusDto;
import com.xzinoviou.ssec.util.StatusUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class StatusController {

    private final StatusUtil statusUtil;

    public StatusController(StatusUtil statusUtil) {
        this.statusUtil = statusUtil;
    }

    @GetMapping
    public ResponseEntity<List<StatusDto>> getStatuses() {
        return ResponseEntity.ok(statusUtil.getStatuses());
    }

}
