package com.ironhack.midtermAndreaRod.service;

import com.ironhack.midtermAndreaRod.exceptions.IdNotFoundException;
import com.ironhack.midtermAndreaRod.model.Savings;
import com.ironhack.midtermAndreaRod.model.Money;
import com.ironhack.midtermAndreaRod.model.Savings;
import com.ironhack.midtermAndreaRod.repository.SavingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class SavingsService {
    @Autowired
    SavingsRepository savingsRepository;

    public Savings save(Savings savings) {
        return savingsRepository.save(savings);
    }

    public Money getBalanceById(Integer id) {
        LocalDate today = LocalDate.now();
        Savings savings = savingsRepository.findById(id).orElseThrow(() -> new IdNotFoundException("There is no Savings Account with this" + id));
        LocalDate lastAccess = savings.getLastAccessedDate();
        Integer years = Period.between(lastAccess, today).getYears();
        for(int i = 0; i < years; i++ ){
            savings.setBalance(savings.getBalance().multiplyAmount(savings.getInterestRate()));
        }
        return savings.getBalance();
        }

    }
