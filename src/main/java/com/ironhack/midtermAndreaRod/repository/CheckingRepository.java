package com.ironhack.midtermAndreaRod.repository;

import com.ironhack.midtermAndreaRod.model.Checking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckingRepository extends JpaRepository<Checking, Integer> {
}
