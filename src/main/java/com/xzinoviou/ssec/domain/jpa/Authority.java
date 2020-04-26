package com.xzinoviou.ssec.domain.jpa;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
public class Authority {

    @JoinTable(name = "users.id")
    @Column(name = "user_id")
    private Long id;

    @Column(name = "authority")
    private String autority;

    public Authority() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAutority() {
        return autority;
    }

    public void setAutority(String autority) {
        this.autority = autority;
    }
}
