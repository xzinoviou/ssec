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
@RequestMapping("/status")
public class StatusController {

    private final StatusUtil statusUtil;

    public StatusController(StatusUtil statusUtil) {
        this.statusUtil = statusUtil;
    }

    @GetMapping("/admin")
    public ResponseEntity<List<StatusDto>> getAdminAuthorizedStatus() {
        return ResponseEntity.ok(statusUtil.getStatuses());
    }

    @GetMapping("/admin/{id}")
    public ResponseEntity<StatusDto> getStatus(@PathVariable Integer id) {
        return ResponseEntity.ok(statusUtil.getStatuses().stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseGet(() -> new StatusDto(100, NOT_FOUND.value(), NOT_FOUND.getReasonPhrase())));
    }

    @GetMapping("/user")
    public ResponseEntity<List<StatusDto>> getUserauthorizedStatus() {
        return ResponseEntity.ok(statusUtil.getStatuses());
    }

}
