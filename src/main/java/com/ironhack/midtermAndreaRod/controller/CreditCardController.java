package com.ironhack.midtermAndreaRod.controller;

import com.ironhack.midtermAndreaRod.model.Checking;
import com.ironhack.midtermAndreaRod.model.CreditCard;
import com.ironhack.midtermAndreaRod.model.Money;
import com.ironhack.midtermAndreaRod.service.AccountService;
import com.ironhack.midtermAndreaRod.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class CreditCardController {

    @Autowired
    CreditCardService creditCardService;

    @PostMapping("/creditcard/create")
    @ResponseStatus(HttpStatus.CREATED)
    public CreditCard creditCard(@Validated @RequestBody CreditCard creditCard) {
        return creditCardService.save(creditCard);
    }

    @GetMapping("/creditcard/balance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Money getBalanceById(@PathVariable Integer id){ return creditCardService.getBalanceById(id); }
}
