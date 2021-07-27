package com.security.security_configurations.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Person,Integer> {
    Optional<Person>findByUserName(String userName);
}
