package com.ironhack.midtermAndreaRod.controller;

import com.ironhack.midtermAndreaRod.model.Money;
import com.ironhack.midtermAndreaRod.model.Savings;
import com.ironhack.midtermAndreaRod.service.AccountService;
import com.ironhack.midtermAndreaRod.service.SavingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class SavingsController {

    @Autowired
    SavingsService savingsService;

    @PostMapping("/savings/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Savings saveSavings(@Validated @RequestBody Savings savings) {
        return savingsService.save(savings);
    }

    @GetMapping("/savings/balance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Money getBalanceById(@PathVariable Integer id){ return savingsService.getBalanceById(id); }
}
