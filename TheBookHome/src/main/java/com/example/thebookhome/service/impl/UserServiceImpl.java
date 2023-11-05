package com.example.thebookhome.service.impl;

import com.example.thebookhome.model.Role;
import com.example.thebookhome.model.UserEntity;
import com.example.thebookhome.model.dto.UserRegistrationDto;
import com.example.thebookhome.model.enums.RoleType;
import com.example.thebookhome.repository.RoleRepo;
import com.example.thebookhome.repository.UserRepo;
import com.example.thebookhome.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepo userRepo, RoleRepo roleRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void register(UserRegistrationDto userRegistrationDto) {
        userRepo.save(map(userRegistrationDto));

    }

    private UserEntity map(UserRegistrationDto userRegistrationDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userRegistrationDto.getUsername());
        userEntity.setEmail(userRegistrationDto.getEmail());
        userEntity.setPassword(passwordEncoder.encode(userRegistrationDto.getPassword()));

        Role role = roleRepo.findRoleByRoleType(RoleType.ROLE_USER);

        userEntity.setRoles(Arrays.asList(role));
        return userEntity;
    }
}
