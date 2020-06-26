package com.ironhack.midtermAndreaRod.repository;

import com.ironhack.midtermAndreaRod.model.AccountHolder;
import com.ironhack.midtermAndreaRod.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
