package com.kevcode.cdtsaccountservice.domain.bank.entities;

import com.kevcode.cdtsaccountservice.domain.bank.entities.base.EntityBase;

import javax.persistence.Entity;

@Entity
public class CdtAccount extends EntityBase {
    private Long balance;
    private Long customerId;

    public Long getBalance() {
        return balance == null ? 0 : balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long personId) {
        this.customerId = personId;
    }
}
