package com.RetroZoomer.KP_Android.repository;

import com.RetroZoomer.KP_Android.entity.user.role.ERole;
import com.RetroZoomer.KP_Android.entity.user.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRep extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
