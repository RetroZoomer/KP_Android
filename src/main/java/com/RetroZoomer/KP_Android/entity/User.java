package com.RetroZoomer.KP_Android.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    private Long id;
    private boolean isGM;
    private String login;
    private String password;
}
