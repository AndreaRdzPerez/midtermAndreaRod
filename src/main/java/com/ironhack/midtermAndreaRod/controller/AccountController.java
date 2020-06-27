package com.ironhack.midtermAndreaRod.controller;

import com.ironhack.midtermAndreaRod.dto.Transference;
import com.ironhack.midtermAndreaRod.model.*;
import com.ironhack.midtermAndreaRod.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/account/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Account findById(@PathVariable Integer id){ return accountService.findById(id); }

    @PatchMapping("/account/debit/{id}/{amount}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void debitById(@PathVariable Integer id, Integer amount){ accountService.debitById(id, amount); }

    @PatchMapping("/account/credit/{id}/{amount}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void creditById(@PathVariable Integer id, Integer amount){ accountService.creditById(id, amount); }

    @PostMapping("/account/transference")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void makeTransference(@RequestBody Transference transference) throws Exception { accountService.makeTransference(transference); }

    //3rd party debit
    @PatchMapping("/debit/{hashed_key}/{id}/{account_secret_key}/{amount}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void thirdPartyDebit(@PathVariable String hashedKey, Integer id, String account_secret_key, Integer amount){ accountService.thirdPartyDebit(hashedKey, id, account_secret_key, amount); }

    //3rd party credit
    /* @PatchMapping("/debit/{hashed_key}/{id}/{account_secret_key/{amount}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void thirdPartyCredit(@PathVariable String hashedKey, Integer id, String account_secret_key, Integer amount){ checkingService.thirdPartyCredit(hashedKey, id, account_secret_key, amount); }

     */


}

