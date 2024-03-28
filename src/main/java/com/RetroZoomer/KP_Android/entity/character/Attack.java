package com.RetroZoomer.KP_Android.entity.character;

import javax.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Attack implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private String name;

    private String abilities;

    private boolean isProf;

    private String damage;
}
