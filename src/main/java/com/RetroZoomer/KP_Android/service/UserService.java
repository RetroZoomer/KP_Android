package com.RetroZoomer.KP_Android.service;

import com.RetroZoomer.KP_Android.entity.user.User;
import com.RetroZoomer.KP_Android.entity.user.role.ERole;
import com.RetroZoomer.KP_Android.entity.user.role.Role;
import com.RetroZoomer.KP_Android.repository.RoleRep;
import com.RetroZoomer.KP_Android.repository.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    @Autowired
    UserRep userRepository;
    @Autowired
    RoleRep roleRepository;

    public User findUserById(Long userId) {
        Optional<User> userFromDb = userRepository.findById(userId);
        return userFromDb.orElse(new User());
    }

    public List<User> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    public User saveUser(User user) {
        Set<Role> roles = new HashSet<>();

        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(userRole);
        user.setRoles(roles);
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return user;
    }

    public User updateUser(User user) {
        //User userFromDB = userRepository.findByUsername(user.getUsername());

        //user.setRoles(userFromDB.getRoles());
        //if (!Objects.equals(user.getPassword(), userFromDB.getPassword())) {
            //user.setPassword(passwordEncoder.encode(user.getPassword()));
        //}
        userRepository.save(user);

        return user;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
