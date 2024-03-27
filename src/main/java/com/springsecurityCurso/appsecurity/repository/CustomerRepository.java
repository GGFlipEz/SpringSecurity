package com.springsecurityCurso.appsecurity.repository;

import com.springsecurityCurso.appsecurity.entites.Customer;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, BigInteger> {
    Optional<Customer> findByEmail(String email);
}
