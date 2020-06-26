package com.ironhack.midtermAndreaRod.service;

import com.ironhack.midtermAndreaRod.exceptions.IdNotFoundException;
import com.ironhack.midtermAndreaRod.model.Account;
import com.ironhack.midtermAndreaRod.model.Checking;
import com.ironhack.midtermAndreaRod.model.Money;
import com.ironhack.midtermAndreaRod.model.StudentChecking;
import com.ironhack.midtermAndreaRod.repository.CheckingRepository;
import com.ironhack.midtermAndreaRod.repository.StudentCheckingRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
public class CheckingService {

    @Autowired
    CheckingRepository checkingRepository;
    @Autowired
    StudentCheckingRepository studentCheckingRepository;

    public Account save(Checking checking) {
        LocalDate today = LocalDate.now();
        LocalDate accountHolderBirth = checking.getPrimaryOwner().getDateOfBirth();
        if(Period.between(accountHolderBirth, today).getYears() < 24){
            StudentChecking studentChecking = new StudentChecking(checking.getBalance(), checking.getPrimaryOwner(), checking.getSecondaryOwner(), checking.getSecretKey());
            return studentCheckingRepository.save(studentChecking);
        }return checkingRepository.save(checking);
    }

    public Money getBalanceById(Integer id) {
        if(checkingRepository.findById(id) != null ) {
            Optional<Checking> checking = checkingRepository.findById(id);
            return checking.get().getBalance();
        }else if(studentCheckingRepository.findById(id) != null){
            Optional<StudentChecking> studentChecking = studentCheckingRepository.findById(id);
            return studentChecking.get().getBalance();
        }else{
            throw new IdNotFoundException("There is no Checking nor StudentChecking Account with this " + id);
        }
    }

    public List<Checking> findAll() {
        return checkingRepository.findAll();
    }
}
