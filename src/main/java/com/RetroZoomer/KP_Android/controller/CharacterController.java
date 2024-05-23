package com.RetroZoomer.KP_Android.controller;

import antlr.collections.List;
import com.RetroZoomer.KP_Android.entity.character.Character;
import com.RetroZoomer.KP_Android.service.CharacterService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/character")
//@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
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


    @GetMapping("/find/{id}")
    public ResponseEntity<Character> getCharacterById(@PathVariable("id") Long id)  {
        try {
            Character character = characterService.findCharacterById(id);
            return new ResponseEntity<>(character, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add/{userId}")
    public ResponseEntity<Character> addCharacter(@RequestBody Character character, @PathVariable("userId") int userId)  {
        try {
            Character newCharacter = characterService.saveCharacter(character);

            try {
//                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/KP_Android", "root", "123");
                if (con != null) {

                    String query = "INSERT INTO user_characters(user_id, character_id) VALUES (" + userId + "," + character.getId() + ")";
                    Statement statement = con.createStatement();
                    statement.executeUpdate(query);
                    con.close();
                } else {
                    System.out.println("Not Connected...");
                }

            } catch (Exception e) {
                System.out.println("Exception is " + e.getMessage());
            }
            return new ResponseEntity<>(newCharacter, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<Character> updateCharacter(@RequestBody Character character)  {
        try {
            Character updateCharacter = characterService.updateCharacter(character);
            return new ResponseEntity<>(updateCharacter, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteCharacter(@PathVariable("id") Long id)  {
        try {
            try {
                Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/KP_Android", "root", "123");
                if (con != null) {

                    String query = "DELETE FROM user_characters WHERE character_id = " + id + "";
                    Statement statement = con.createStatement();
                    statement.executeUpdate(query);
                    con.close();
                } else {
                    System.out.println("Not Connected...");
                }

            } catch (Exception e) {
                System.out.println("Exception is " + e.getMessage());
            }
            characterService.deleteCharacter(id);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
