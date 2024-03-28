package com.RetroZoomer.KP_Android.repository;

import com.RetroZoomer.KP_Android.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    Boolean existsByUsername(String username);

    User findByUsernameAndPassword(String email, String password);
}
