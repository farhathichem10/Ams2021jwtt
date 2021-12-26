package com.sip.Ams.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sip.Ams.entities.User;


@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByUsername(String username);
      Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
 }
