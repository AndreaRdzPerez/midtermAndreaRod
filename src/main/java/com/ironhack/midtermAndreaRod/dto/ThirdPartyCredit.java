package com.ironhack.midtermAndreaRod.dto;

public class ThirdPartyCredit {
    private Integer accountId;
    private String secretKey;
    private double amount;

    public ThirdPartyCredit() {
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String account_secret_key) {
        this.secretKey = account_secret_key;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
