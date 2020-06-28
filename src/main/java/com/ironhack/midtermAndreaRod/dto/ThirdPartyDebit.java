package com.ironhack.midtermAndreaRod.dto;

import java.math.BigDecimal;

public class ThirdPartyDebit {
    private String hashedKey;
    private Integer accountId;
    private String account_secret_key;
    private BigDecimal amount;

    public ThirdPartyDebit() {
    }

    public String getHashedKey() {
        return hashedKey;
    }

    public void setHashedKey(String hashedKey) {
        this.hashedKey = hashedKey;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccount_secret_key() {
        return account_secret_key;
    }

    public void setAccount_secret_key(String account_secret_key) {
        this.account_secret_key = account_secret_key;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
