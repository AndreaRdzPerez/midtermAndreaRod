package com.ironhack.midtermAndreaRod.service;

import com.ironhack.midtermAndreaRod.exceptions.IdNotFoundException;
import com.ironhack.midtermAndreaRod.model.Account;
import com.ironhack.midtermAndreaRod.model.Money;
import com.ironhack.midtermAndreaRod.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account findById(Integer id) {
        return accountRepository.findById(id).orElseThrow(() -> new IdNotFoundException("There is no Checking Account with this " + id));
    }

    public void debitById(Integer id, Integer amount) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new IdNotFoundException("There is no Checking Account with this " + id));
        Money amountMoney = new Money(BigDecimal.valueOf(amount));
        account.setBalance(account.getBalance().decreaseAmount(amountMoney));
        accountRepository.save(account);
    }

    public void creditById(Integer id, Integer amount) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new IdNotFoundException("There is no Checking Account with this " + id));
        Money amountMoney = new Money(BigDecimal.valueOf(amount));
        account.setBalance(account.getBalance().decreaseAmount(amountMoney));
        accountRepository.save(account);
    }

    /**
     Debería de crear una clase transference y hacer un Request Body o puedo aplicar toda la lógica aquí?????
     */
    public void transference(String name, Integer id, Integer amount) {
    }

    public void thirdPartyDebit(String hashedKey, Integer id, String account_secret_key, Integer amount) {
    }

    // public void thirdPartyCredit(String hashedKey, Integer id, String account_secret_key, Integer amount) {
    //}
}
