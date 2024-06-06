package com.benja.login.login.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.benja.login.login.Entities.User.User;

public interface UserRepository extends JpaRepository<User, Integer>
{
    Optional<User> findByUsername(String username);
}
