package com.springsecurityCurso.appsecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {
@Bean
SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(auth ->
                    auth.antMatchers("/loans","/balance","/accounts","/cards").authenticated()
                            .anyRequest().permitAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }

    /***
    @Bean
    InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        UserDetails admin = User.withUsername("admin")
                .password("to_be_encode")
                .authorities("ADMIN")
                .build();

        UserDetails user = User.withUsername("user")
                .password("to_be_encode")
                .authorities("USER")
                .build();
        return new InMemoryUserDetailsManager(admin,user);
    }
    ***/
    /***
    @Bean
    UserDetailsService userDetailsService(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }
     ***/
    @Bean
    PasswordEncoder passwordEncoder(){
    return NoOpPasswordEncoder.getInstance();
    }
}
