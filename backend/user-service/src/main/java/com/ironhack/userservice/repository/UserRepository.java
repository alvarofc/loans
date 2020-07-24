package com.ironhack.userservice.repository;

import com.ironhack.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String Email);
}
