package com.RetroZoomer.KP_Android.service;

import com.RetroZoomer.KP_Android.entity.character.Character;
import com.RetroZoomer.KP_Android.repository.CharacterRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {
    @Autowired
    CharacterRep characterRep;

    public Character findCharacterById(Long characterId) {
        Optional<Character> characterFromDb = characterRep.findById(characterId);
        return characterFromDb.orElse(new Character());
    }

    public List<Character> findAllCharacters() {
        return characterRep.findAll();
    }

    public Character saveCharacter(Character character) {
        characterRep.save(character);
        return character;
    }

    public Character updateCharacter(Character character) {
        characterRep.save(character);
        return character;
    }

    public void deleteCharacter(Long id) {
        characterRep.deleteById(id);
    }
}
