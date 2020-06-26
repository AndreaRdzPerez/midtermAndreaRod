package com.ironhack.midtermAndreaRod.repository;

import com.ironhack.midtermAndreaRod.model.StudentChecking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentCheckingRepository extends JpaRepository<StudentChecking, Integer> {
}