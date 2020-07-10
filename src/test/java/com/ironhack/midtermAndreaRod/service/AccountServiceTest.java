package com.ironhack.midtermAndreaRod.service;

import com.ironhack.midtermAndreaRod.dto.ThirdPartyDebit;
import com.ironhack.midtermAndreaRod.dto.Transference;
import com.ironhack.midtermAndreaRod.model.*;
import org.apache.tomcat.jni.Local;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import javax.transaction.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountServiceTest {

    @Autowired
    AccountService accountService;

    private Money m;
    private Account a;
    private Savings s;
    private Transference t;
    private Checking c;
    private AccountHolder ah1;
    private AccountHolder ah2;
    private ThirdPartyDebit tpd;

    @BeforeEach
    void setUp() {
        m = new Money(BigDecimal.valueOf(500.00));
        //AccountHolders
        ah1 = new AccountHolder();
        ah1.setId(Long.valueOf(1));
        ah1.setUsername("juanito");
        ah1 = new AccountHolder(Long.valueOf(1), "juanito", "juanito", LocalDate.of(1987, Month.JANUARY, 1) );
        ah2 = new AccountHolder();
        ah2.setId(Long.valueOf(2));
        //Saving account test
        s = new Savings();
        s.setLastAccessedDate(LocalDate.of(2017, Month.JANUARY, 1));
        s.setPrimaryOwner(ah2);
        s.setMinimumBalance(BigDecimal.valueOf(1000.00));
        s.setInterestRate(BigDecimal.valueOf(0.01));
        s.setBalance(new Money(BigDecimal.valueOf(2000.00)));
        s.setId(1);
        //checking account test
        c = new Checking(new Money(BigDecimal.valueOf(2000.00)), ah1, ah2);
        c.setId(2);
        //transference
        t = new Transference();
        t.setSenderAccountHolderId(ah1.getId());
        t.setAccountReceiverId(s.getId());
        t.setAccountSenderId(c.getId());
        t.setAmount(BigDecimal.valueOf(20));
        //thirdPartyDebit
        tpd = new ThirdPartyDebit();
        


    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findById_correct() {
        Account account = accountService.findById(1);
        assertEquals(1, account.getId());
    }

    @Test
    void debitById() {
        accountService.debitById(1, 5);
        assertFalse(s.getBalance().isMoreThan(BigDecimal.valueOf(2000.00)));
    }

    @Test
    void creditById() {
        accountService.creditById(1,5);
        assertTrue(s.getBalance().isMoreThan(BigDecimal.valueOf(2000.00)));
    }

    @Test
    void makeTransference_test() throws Exception {
        accountService.makeTransference(t);
        assertTrue(s.getBalance().isMoreThan(c.getBalance().getAmount()));
    }

    @Test
    void thirdPartyDebit() {
    }

    @Test
    void thirdPartyCredit() {
    }
}