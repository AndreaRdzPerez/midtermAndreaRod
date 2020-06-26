package com.ironhack.midtermAndreaRod.service;

import com.ironhack.midtermAndreaRod.model.AccountHolder;
import com.ironhack.midtermAndreaRod.repository.AccountHolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountHolderService {

    @Autowired
    private AccountHolderRepository accountHolderRepository;

    public AccountHolder save(AccountHolder accountHolder) {
        return accountHolderRepository.save(accountHolder);
    }
}
