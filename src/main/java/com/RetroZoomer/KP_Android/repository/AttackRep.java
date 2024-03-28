package com.RetroZoomer.KP_Android.repository;

import com.RetroZoomer.KP_Android.entity.character.Attack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttackRep extends JpaRepository<Attack, Long> {
}
