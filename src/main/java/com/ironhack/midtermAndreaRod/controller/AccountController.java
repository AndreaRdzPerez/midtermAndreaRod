package com.ironhack.midtermAndreaRod.controller;

import com.ironhack.midtermAndreaRod.dto.ThirdPartyCredit;
import com.ironhack.midtermAndreaRod.dto.ThirdPartyDebit;
import com.ironhack.midtermAndreaRod.dto.Transference;
import com.ironhack.midtermAndreaRod.model.*;
import com.ironhack.midtermAndreaRod.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    @PostMapping("/debit/third_party_debit/{hashedKey}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void thirdPartyDebit(@PathVariable String hashedKey, @RequestBody ThirdPartyDebit thirdPartyDebit){ accountService.thirdPartyDebit(hashedKey, thirdPartyDebit); }

    //3rd party credit
    @PostMapping("/debit/third_party_credit/{hashedKey}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void thirdPartyCredit(@PathVariable String hashedKey, @RequestBody ThirdPartyCredit thirdPartyCredit){ accountService.thirdPartyCredit(hashedKey, thirdPartyCredit); }



}

