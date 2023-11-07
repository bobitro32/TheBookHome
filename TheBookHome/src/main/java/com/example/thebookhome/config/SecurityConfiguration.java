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
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests(authorizeRequest -> authorizeRequest.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        .requestMatchers("/", "/users/login", "/users/register", "/users/login-error").permitAll()
                        .anyRequest().authenticated()

                ).formLogin(formLogin ->{
                    formLogin.loginPage("/users/login")

                            .successForwardUrl("/")
                            .usernameParameter("username")
                            .passwordParameter("password")
                            .failureForwardUrl("/users/register");
                })
                .logout(logout -> {
                    logout.logoutUrl("/users/logout")
                            .logoutSuccessUrl("/users/login")
                            .invalidateHttpSession(true);
                })
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepo userRepository) {
        return new UserDetailService(userRepository);
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }


}
