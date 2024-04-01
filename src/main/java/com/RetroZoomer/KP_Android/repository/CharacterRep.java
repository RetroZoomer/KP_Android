package com.RetroZoomer.KP_Android.repository;

import com.RetroZoomer.KP_Android.entity.character.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRep extends JpaRepository<Character, Long> {
//    List<Character> findAllCharactersByUsername(String Username);
}
