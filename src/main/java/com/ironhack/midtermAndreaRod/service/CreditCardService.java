package com.ironhack.midtermAndreaRod.service;

import com.ironhack.midtermAndreaRod.exceptions.IdNotFoundException;
import com.ironhack.midtermAndreaRod.model.Checking;
import com.ironhack.midtermAndreaRod.model.CreditCard;
import com.ironhack.midtermAndreaRod.model.Money;
import com.ironhack.midtermAndreaRod.model.StudentChecking;
import com.ironhack.midtermAndreaRod.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@Service
public class CreditCardService {

    @Autowired
    CreditCardRepository creditCardRepository;

    public CreditCard save(CreditCard creditCard) {
        return creditCardRepository.save(creditCard);
    }

    public Money getBalanceById(Integer id) {
        LocalDate today = LocalDate.now();
        CreditCard creditCard = creditCardRepository.findById(id).orElseThrow(() -> new IdNotFoundException("There is no CreditCard Account with this" + id));
        LocalDate lastAccess = creditCard.getLastAccessedDate();
        Integer months = Period.between(lastAccess, today).getMonths();
        for(int i = 0; i < months; i++ ){
            creditCard.setBalance(creditCard.getBalance().multiplyAmount(creditCard.getInterestRate()));
    }
        return creditCard.getBalance();
    }
}