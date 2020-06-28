package com.ironhack.midtermAndreaRod.model;

import com.ironhack.midtermAndreaRod.repository.Transactional;

import javax.persistence.Embeddable;
import java.math.RoundingMode;
        import java.math.BigDecimal;
        import java.util.Currency;

@Embeddable
public class Money implements Transactional {
    private static final Currency USD = Currency.getInstance("USD");
    private static final RoundingMode DEFAULT_ROUNDING = RoundingMode.HALF_EVEN;
    private final Currency currency;
    private BigDecimal amount;

    public Money() {
        currency = Currency.getInstance("USD");
    }

    /**
     * Class constructor specifying amount, currency, and rounding
     **/
    public Money(BigDecimal amount, Currency currency, RoundingMode rounding) {
        this.currency = currency;
        setAmount(amount.setScale(currency.getDefaultFractionDigits(), rounding));
    }
    /**
     * Class constructor specifying amount, and currency. Uses default RoundingMode HALF_EVEN.
     **/
    public Money(BigDecimal amount, Currency currency) {
        this(amount, currency, DEFAULT_ROUNDING);
    }
    /**
     * Class constructor specifying amount. Uses default RoundingMode HALF_EVEN and default currency USD.
     **/
    public Money(BigDecimal amount) {
        this(amount, USD, DEFAULT_ROUNDING);
    }

    public Money increaseAmount(Money money) {
        setAmount(this.amount.add(money.amount));
        Money newAmount = new Money(this.amount);
        return newAmount;
    }
    public BigDecimal increaseAmount(BigDecimal addAmount) {
        setAmount(this.amount.add(addAmount));
        return this.amount;
    }

    public Money increaseAmountMoney(BigDecimal addAmount) {
        setAmount(this.amount.add(addAmount));
        Money newAmount = new Money(this.amount);
        return newAmount;
    }

    public Money multiplyAmount(BigDecimal percentage) {
        //hardcoding to add a 1 to make sure the percentage will be added
        BigDecimal addAmount = percentage.add(BigDecimal.valueOf(1));
        //multiplying
        setAmount(this.amount.multiply(addAmount));
        Money newAmount = new Money(this.amount);
        return newAmount;
    }

    public Money decreaseAmount(Money money) {
        setAmount(this.amount.subtract(money.getAmount()));
        Money newAmount = new Money(this.amount);
        return newAmount;
    }
    public BigDecimal decreaseAmount(BigDecimal addAmount) {
        setAmount(this.amount.subtract(addAmount));
        return this.amount;
    }

    public Money decreaseAmountMoney(BigDecimal addAmount) {
        setAmount(this.amount.subtract(addAmount));
        Money newAmount = new Money(this.amount);
        return newAmount;
    }

    public boolean isMoreThan(BigDecimal addAmount) {
        int compare;
        compare = this.amount.compareTo(addAmount);
        if(compare == 1) {
           return true;
       }else if(compare == 0){
            return true;
        }else{
            return false;
        }
    }

    public Currency getCurrency() {
        return this.currency;
    }
    public BigDecimal getAmount() {
        return this.amount;
    }
    private void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public String toString() {
        return getCurrency().getSymbol() + " " + getAmount();
    }
}
