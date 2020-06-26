package com.ironhack.midtermAndreaRod.controller;

import com.ironhack.midtermAndreaRod.model.Account;
import com.ironhack.midtermAndreaRod.model.AccountHolder;
import com.ironhack.midtermAndreaRod.model.Checking;
import com.ironhack.midtermAndreaRod.service.AccountHolderService;
import com.ironhack.midtermAndreaRod.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountHolderController {

    @Autowired
    AccountHolderService accountHolderService;

    @PostMapping("/accountHolder/create")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountHolder saveAccountHolder(@Validated @RequestBody AccountHolder accountHolder) {
        return accountHolderService.save(accountHolder);
    }

}
