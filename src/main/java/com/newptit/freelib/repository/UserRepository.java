package com.newptit.freelib.repository;

import com.newptit.freelib.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    public User findUserById(String id);
}
