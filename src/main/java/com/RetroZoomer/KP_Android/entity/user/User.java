package com.RetroZoomer.KP_Android.entity.user;

import com.RetroZoomer.KP_Android.entity.user.role.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "\"user\"")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private boolean isGM;

    @Column(nullable = false, unique = true)
    private String login;
    @Column(nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();


    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(Long id, String login, String password, Set<Role> roles) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.roles = roles;
    }

    public User() {

    }
}
