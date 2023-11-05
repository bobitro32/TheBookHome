package com.example.thebookhome.service.impl;

import com.example.thebookhome.model.Role;
import com.example.thebookhome.model.UserEntity;

import com.example.thebookhome.repository.UserRepo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailService implements UserDetailsService {
    private final UserRepo userRepo;

    public UserDetailService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username).map(UserDetailService::map).orElseThrow(() -> new UsernameNotFoundException("UserEntity " + username + " not found!"));
    }
    private static UserDetails map(UserEntity userEntity){
        return User
                .withUsername(userEntity.getUsername())
                .password(userEntity.getPassword())
                .authorities(userEntity.getRoles().stream().map(UserDetailService::map).toList()).build();
    }
    private static GrantedAuthority map(Role role){
        return new SimpleGrantedAuthority(role.getRoleType().name());
    }
}
