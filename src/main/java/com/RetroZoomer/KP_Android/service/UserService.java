package com.RetroZoomer.KP_Android.service;

import com.RetroZoomer.KP_Android.entity.user.User;
import com.RetroZoomer.KP_Android.entity.user.role.ERole;
import com.RetroZoomer.KP_Android.entity.user.role.Role;
import com.RetroZoomer.KP_Android.repository.RoleRep;
import com.RetroZoomer.KP_Android.repository.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRep userRepository;
    @Autowired
    RoleRep roleRepository;
    PasswordEncoder passwordEncoder;

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
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return user;
    }

    public User updateUser(User user) {
        User userFromDB = userRepository.findByUsername(user.getUsername());

        user.setRoles(userFromDB.getRoles());
        if (!Objects.equals(user.getPassword(), userFromDB.getPassword())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        userRepository.save(user);

        return user;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}
