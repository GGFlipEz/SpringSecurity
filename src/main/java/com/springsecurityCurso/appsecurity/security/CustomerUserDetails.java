package com.springsecurityCurso.appsecurity.security;

import com.springsecurityCurso.appsecurity.repository.CustomerRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class CustomerUserDetails implements UserDetailsService {

    private final CustomerRepository customerRepository;

    public CustomerUserDetails(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.customerRepository.findByEmail(username)
                .map( customer -> {
                    Set<GrantedAuthority> authorities = new HashSet<>();
                    authorities.add(new SimpleGrantedAuthority(customer.getRol()));
                    return new User( customer.getEmail(),customer.getPwd(),authorities);
                }).orElseThrow( () -> new UsernameNotFoundException("Usuario no válido"));
    }
}
