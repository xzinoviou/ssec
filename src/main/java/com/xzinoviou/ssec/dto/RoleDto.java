package com.xzinoviou.ssec.dto;

import com.xzinoviou.ssec.domain.jpa.RoleEnum;

import java.io.Serializable;
import java.util.Objects;

public class RoleDto implements Serializable {

    private Long id;

    private RoleEnum roleType;

    public RoleDto() {
    }

    public RoleDto(String role) {
        this.roleType = RoleEnum.of(role);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleEnum getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleEnum roleType) {
        this.roleType = roleType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoleDto)) return false;
        RoleDto roleDto = (RoleDto) o;
        return Objects.equals(getId(), roleDto.getId()) &&
                getRoleType() == roleDto.getRoleType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRoleType());
    }
}
