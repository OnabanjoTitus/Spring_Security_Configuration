package com.security.security_configurations.UserLoginAndRegisterationBackend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppUser,Integer> {
    Optional<AppUser> findByEmail(String email);
    AppUser findAppUserByEmail(String email);
}
