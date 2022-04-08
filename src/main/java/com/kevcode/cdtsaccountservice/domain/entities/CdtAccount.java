package com.kevcode.cdtsaccountservice.domain.entities;

import com.kevcode.cdtsaccountservice.domain.entities.base.EntityBase;

import javax.persistence.Entity;

@Entity
public class CdtAccount extends EntityBase {
    private Long balance;

    public Long getBalance() {
        return balance == null ? 0 : balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    private Long personId;
}
