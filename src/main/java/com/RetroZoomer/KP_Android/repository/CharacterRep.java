package com.RetroZoomer.KP_Android.repository;

import com.RetroZoomer.KP_Android.entity.character.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRep extends JpaRepository<Character, Long> {
}
