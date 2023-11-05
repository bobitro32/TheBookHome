package com.example.thebookhome.repository;

import com.example.thebookhome.model.Role;
import com.example.thebookhome.model.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findRoleByRoleType(RoleType roleName);
}
