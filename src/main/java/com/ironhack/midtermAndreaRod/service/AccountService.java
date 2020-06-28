package com.ironhack.midtermAndreaRod.service;

import com.ironhack.midtermAndreaRod.dto.ThirdPartyCredit;
import com.ironhack.midtermAndreaRod.dto.ThirdPartyDebit;
import com.ironhack.midtermAndreaRod.dto.Transference;
import com.ironhack.midtermAndreaRod.exceptions.IdNotFoundException;
import com.ironhack.midtermAndreaRod.exceptions.NotValidDataException;
import com.ironhack.midtermAndreaRod.model.Account;
import com.ironhack.midtermAndreaRod.model.Money;
import com.ironhack.midtermAndreaRod.repository.AccountRepository;
import com.ironhack.midtermAndreaRod.repository.ThirdPartyRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Optional;

@Service
public class AccountService {

    private static final Logger LOGGER = LogManager.getLogger(AccountService.class);

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ThirdPartyRepository thirdPartyRepository;

    public Account findById(Integer id) {
        LOGGER.info("[INIT] - findById");
        if(accountRepository.findById(id) != null){
            LOGGER.info("[END] - findById");
            return accountRepository.findById(id).orElseGet(null);
        }else{
            LOGGER.error("Account not found");
            throw new IdNotFoundException("There is no Account with this ID: " + id);
        }
        //return accountRepository.findById(id).orElseThrow(() -> new IdNotFoundException("There is no Account with this ID: " + id));
    }

    public void debitById(Integer id, Integer amount) {
            LOGGER.info("[INIT] - debitById");
            Optional<Account> account = accountRepository.findById(id);
            Money amountMoney = new Money(BigDecimal.valueOf(amount));
            LOGGER.info("Debit the amount specified to the account");
            account.get().setBalance(account.get().getBalance().decreaseAmount(amountMoney));
            LOGGER.info("[END] - debitById");
            accountRepository.save(account.get());
    }

    public void creditById(Integer id, Integer amount) {
        Optional<Account> account = accountRepository.findById(id);
        LOGGER.info("[INIT] - creditById");
        Money amountMoney = new Money(BigDecimal.valueOf(amount));
        LOGGER.info("Credit the amount specified to the account");
        account.get().setBalance(account.get().getBalance().decreaseAmount(amountMoney));
        LOGGER.info("[END] - creditById");
        accountRepository.save(account.get());
    }

    @Transactional
    public void makeTransference(Transference transference) throws Exception {
        Account senderAccount = accountRepository.findById(transference.getAccountSenderId()).orElseThrow(() -> new RuntimeException("Account not found"));
        LOGGER.info("[INIT] - makeTransference");
        if(senderAccount.getBalance().isMoreThan(transference.getAmount()) == false ){
            LOGGER.error("Not enough founds available for transference.");
            throw new Exception("Not enough founds available for transference.");
        }
        LOGGER.info("Reducing amount from sender and increasing it at receiver.");
        //reduce money from sender
        senderAccount.setBalance(senderAccount.getBalance().decreaseAmountMoney(transference.getAmount()));
        accountRepository.save(senderAccount);
        //increase money at receiver
        Account receiverAccount = accountRepository.findById(transference.getAccountReceiverId()).orElseThrow(() -> new RuntimeException("Account not found :C"));
        receiverAccount.setBalance(receiverAccount.getBalance().increaseAmountMoney(transference.getAmount()));
        accountRepository.save(receiverAccount);
        LOGGER.info("[END] - creditById");
    }

    @Transactional
    public void thirdPartyDebit(String hashedKey, ThirdPartyDebit thirdPartyDebit) {
        //verify thirdparty User exist
        if(hashedKey == thirdPartyRepository.findByHashedKey(hashedKey).getHashedKey()) {
            LOGGER.info("[INIT] - thirdPartyDebit");
            //find by ID
            Account debitAccount = accountRepository.findById(thirdPartyDebit.getAccountId()).orElseThrow(() -> new RuntimeException("Account not found"));
            //verify the secretKey Account matches
            LOGGER.info("Verifying the account details are correct");
            if(thirdPartyDebit.getSecretKey() == debitAccount.getSecretKey()){
                //debit the amount
                Money amountMoney = new Money(BigDecimal.valueOf(thirdPartyDebit.getAmount()));
                LOGGER.info("Debit the amount specified of the account");
                debitAccount.setBalance(debitAccount.getBalance().decreaseAmount(amountMoney));
                LOGGER.info("[END] - creditById");
                accountRepository.save(debitAccount);
            }else{
                //error for not matching
                LOGGER.error("Introduced SecretKey is not valid");
                throw new NotValidDataException("Introduced SecretKey is not valid");
            }
        }else{
            LOGGER.error("The ThirdParty User was not found.");
            throw new IdNotFoundException("The ThirdParty User was not found.");
        }
    }

    @Transactional
    public void thirdPartyCredit(String hashedKey, ThirdPartyCredit thirdPartyCredit) {
        //verify thirdparty User exist
        if(hashedKey == thirdPartyRepository.findByHashedKey(hashedKey).getHashedKey()) {
            LOGGER.info("[INIT] - thirdPartyDebit");
            //find by ID
            Account debitAccount = accountRepository.findById(thirdPartyCredit.getAccountId()).orElseThrow(() -> new RuntimeException("Account not found"));
            //verify the secretKey Account matches
            LOGGER.info("Verifying the account details are correct");
            if(thirdPartyCredit.getSecretKey() == debitAccount.getSecretKey()){
                //debit the amount
                Money amountMoney = new Money(BigDecimal.valueOf(thirdPartyCredit.getAmount()));
                LOGGER.info("Debit the amount specified of the account");
                debitAccount.setBalance(debitAccount.getBalance().increaseAmount(amountMoney));
                LOGGER.info("[END] - creditById");
                accountRepository.save(debitAccount);
            }else{
                //error for not matching
                LOGGER.error("Introduced SecretKey is not valid");
                throw new NotValidDataException("Introduced SecretKey is not valid");
            }
        }else{
            LOGGER.error("The ThirdParty User was not found.");
            throw new IdNotFoundException("The ThirdParty User was not found.");
        }
    }
    }

