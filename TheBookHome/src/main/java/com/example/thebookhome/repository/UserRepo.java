package com.example.thebookhome.repository;

import com.example.thebookhome.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo  extends JpaRepository<UserEntity,Long> {
    boolean existsByUsernameOrEmail(String username, String email);

    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findByUsername(String username);
}
