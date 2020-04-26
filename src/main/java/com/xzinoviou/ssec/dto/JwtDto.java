package com.xzinoviou.ssec.dto;

public class JwtDto {

    private String jwtToken;

    public JwtDto() {
    }

    public JwtDto(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getJwtToken() {
        return jwtToken;
    }

}
