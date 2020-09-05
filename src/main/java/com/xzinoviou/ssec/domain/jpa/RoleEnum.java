package com.xzinoviou.ssec.domain.jpa;

import java.util.stream.Stream;

public enum RoleEnum {

    ADMIN, USER, MANAGER, DEV;

    RoleEnum() {
    }

    public static RoleEnum of(String value) {
        return Stream.of(RoleEnum.values()).filter(r -> r.name().equals(value)).findFirst().orElseThrow(UnsupportedOperationException::new);
    }
}
