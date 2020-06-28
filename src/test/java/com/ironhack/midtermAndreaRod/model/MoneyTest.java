package com.ironhack.midtermAndreaRod.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class MoneyTest {
    private static Money m;
    private static Account a;
    private static Savings s;

    @BeforeEach
    public void setUp() {
        m = new Money(BigDecimal.valueOf(500.00));
        s.setLastAccessedDate(LocalDate.of(2017, Month.JANUARY, 1));
        s = new Savings();
        s.setInterestRate(BigDecimal.valueOf(0.01));
        s.setBalance(new Money(BigDecimal.valueOf(2000.00)));
    }

    @AfterEach
    public void clear() {
    }

    @Test
    void multiplyAmount_test() {
        BigDecimal amount = m.getAmount();
        //m.multiplyAmount(BigDecimal.valueOf(0.01));
    }
}