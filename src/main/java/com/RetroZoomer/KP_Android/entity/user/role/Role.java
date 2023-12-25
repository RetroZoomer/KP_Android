package com.RetroZoomer.KP_Android.entity.user.role;

import com.RetroZoomer.KP_Android.entity.user.role.ERole;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "\"role\"")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private ERole name;

    public Role(Long id, ERole name) {
        this.id = id;
        this.name = name;
    }

    public Role() {}

    public Role(ERole name) {
        this.name = name;
    }


}