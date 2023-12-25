package com.RetroZoomer.KP_Android.repository;

import com.RetroZoomer.KP_Android.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRep extends JpaRepository<User, Long> {
    User findByUsername(String username);

    Boolean existsByUsername(String username);
}
