package com.xzinoviou.ssec.controller;

import com.xzinoviou.ssec.dto.StatusDto;
import com.xzinoviou.ssec.util.StatusUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/admin")
public class StatusAdminController {

    private final StatusUtil statusUtil;

    public StatusAdminController(StatusUtil statusUtil) {
        this.statusUtil = statusUtil;
    }

    @GetMapping
    public ResponseEntity<List<StatusDto>> getAdminAuthStatuses() {
        return ResponseEntity.ok(statusUtil.getStatuses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusDto> getAdminAuthStatusesById(@PathVariable Integer id) {
        return ResponseEntity.ok(statusUtil.getStatuses().stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseGet(() -> new StatusDto(100, NOT_FOUND.value(), NOT_FOUND.getReasonPhrase())));
    }
}
