package com.ironhack.midtermAndreaRod.controller;

import com.ironhack.midtermAndreaRod.model.Account;
import com.ironhack.midtermAndreaRod.model.Checking;
import com.ironhack.midtermAndreaRod.model.Money;
import com.ironhack.midtermAndreaRod.service.CheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CheckingController {

    @Autowired
    CheckingService checkingService;

    @PostMapping("/checking/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Account saveChecking(@Validated @RequestBody Checking checking) {
        return checkingService.save(checking);
    }

    @GetMapping("/checkings")
    @ResponseStatus(HttpStatus.OK)
    public List<Checking> findAll(){ return checkingService.findAll(); }

    @GetMapping("/checking/balance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Money getBalanceById(@PathVariable Integer id){ return checkingService.getBalanceById(id); }

}
