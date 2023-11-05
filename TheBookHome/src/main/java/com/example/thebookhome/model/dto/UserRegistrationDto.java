package com.example.thebookhome.model.dto;

import com.example.thebookhome.validation.UniqueUserEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRegistrationDto {
    @Size(min =3, max = 20,message = "Username length must be between 3 and 20 characters!")
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Email
    @NotBlank(message = "Email cannot be empty!")
    @UniqueUserEmail
    private String email;
    @Size(min =3, max = 20,message = "Password length must be between 3 and 20 characters!")
    private String password;

    private String confirmPassword;
}
