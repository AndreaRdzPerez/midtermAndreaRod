package com.ironhack.midtermAndreaRod.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Currency;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class MoneyTest {
    private static Money m;
    private static AccountHolder ah1;
    private static AccountHolder ah2;
    private static Savings s;

    @BeforeEach
    public void setUp() {
        ah1 = new AccountHolder();
        ah2 = new AccountHolder();
        m = new Money(BigDecimal.valueOf(500.00));
        s = new Savings();
        s.setPrimaryOwner(ah1);
        s.setSecondaryOwner(ah2);
        s.setInterestRate(BigDecimal.valueOf(0.01));
        s.setLastAccessedDate(LocalDate.of(2017, Month.JANUARY, 1));
        s.setBalance(new Money(BigDecimal.valueOf(2000.00)));
        s.setMinimumBalance(BigDecimal.valueOf(1000));
        s.setPenaltyFee(BigDecimal.valueOf(40));
    }

    @AfterEach
    public void clear() {
    }

    @Test
    void multiplyAmount_test() {
        BigDecimal amount = m.getAmount();
        m.multiplyAmount(BigDecimal.valueOf(0.01));
    }

    @Test
    void increaseAmount_test() {
    }

    @Test
    void increaseAmountMoney_test() {
    }

    @Test
    void decreaseAmount_test() {
    }

    @Test
    void decreaseAmountMoney_Test() {
    }

    @Test
    void isMoreThan_Test() {
    }
}