package com.xzinoviou.ssec.repository;

import com.xzinoviou.ssec.domain.jpa.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("SELECT r FROM Role r WHERE r.id in ?1")
    Set<Role> findRolesByIdsIn(Set<Long> ids);
}
