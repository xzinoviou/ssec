package com.xzinoviou.ssec.dto;

import org.springframework.stereotype.Component;

@Component
public class StatusDto {

    private Integer id;

    private int code;

    private String reason;

    public StatusDto() {
    }

    public StatusDto(Integer id, int code, String reason) {
        this.id = id;
        this.code = code;
        this.reason = reason;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
