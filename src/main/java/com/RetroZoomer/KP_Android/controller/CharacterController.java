package com.RetroZoomer.KP_Android.controller;

import com.RetroZoomer.KP_Android.entity.character.Character;
import com.RetroZoomer.KP_Android.service.CharacterService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/character")
@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
@Tag(name = "Character", description = "The Character API")
public class CharacterController {
    @Autowired
    private CharacterService characterService;

    @GetMapping("/all")
    public ResponseEntity<List<Character>> getAllCharacters() {
        try {
            List<Character> characters = characterService.findAllCharacters();
            return new ResponseEntity<>(characters, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @GetMapping("/allUsersCharacters")
//    public ResponseEntity<List<Character>> getAllUsersCharactersCharacters(UserDetails userDetails) {
//        try {
//            List<Character> characters = characterService.findAllUsersCharacters(userDetails.getUsername());
//            return new ResponseEntity<>(characters, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Character> getCharacterById(@PathVariable("id") Long id)  {
        try {
            Character character = characterService.findCharacterById(id);
            return new ResponseEntity<>(character, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Character> addCharacter(@RequestBody Character character)  {
        try {
            Character newCharacter = characterService.saveCharacter(character);
            return new ResponseEntity<>(newCharacter, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Character> updateCharacter(@RequestBody Character character)  {
        try {
            Character updateCharacter = characterService.updateCharacter(character);
            return new ResponseEntity<>(updateCharacter, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCharacter(@PathVariable("id") Long id)  {
        try {
            characterService.deleteCharacter(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
