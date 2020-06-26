package com.ironhack.midtermAndreaRod.repository;

import com.ironhack.midtermAndreaRod.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Integer> {
}
