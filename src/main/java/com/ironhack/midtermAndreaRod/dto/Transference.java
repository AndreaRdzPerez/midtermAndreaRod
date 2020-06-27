package com.ironhack.midtermAndreaRod.dto;

import java.math.BigDecimal;

public class Transference {
    private Integer senderAccountHolderId;
    private Integer accountSenderId;
    private Integer accountReceiverId;
    private BigDecimal amount;

    public Integer getSenderAccountHolderId() {
        return senderAccountHolderId;
    }

    public void setSenderAccountHolderId(Integer senderAccountHolderId) {
        this.senderAccountHolderId = senderAccountHolderId;
    }

    public Integer getAccountSenderId() {
        return accountSenderId;
    }

    public void setAccountSenderId(Integer accountSenderId) {
        this.accountSenderId = accountSenderId;
    }

    public Integer getAccountReceiverId() {
        return accountReceiverId;
    }

    public void setAccountReceiverId(Integer accountReceiverId) {
        this.accountReceiverId = accountReceiverId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}