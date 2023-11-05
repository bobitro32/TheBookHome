package com.example.thebookhome.config;

import com.example.thebookhome.repository.UserRepo;
import com.example.thebookhome.service.impl.UserDetailService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.security.Security;

@Configuration
public class SecurityConfiguration  {
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests(authorizeRequest -> authorizeRequest.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .requestMatchers("/", "/users/login", "/users/register", "/users/login-error").permitAll()

        ).formLogin(formLogin ->{
                formLogin.loginPage("/users/login")

                        .defaultSuccessUrl("/")
                        .failureForwardUrl("/users/register")
                        .loginProcessingUrl("/users/login");
                })
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepo userRepository) {
        UserDetails bob = User.builder()
                .username(System.getenv("MY_USERNAME"))
                .password(passwordEncoder().encode(System.getenv("MY_PASSWORD")))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(bob);
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }


}
