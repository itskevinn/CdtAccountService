package com.kevcode.cdtsaccountservice.domain.service;

import com.kevcode.cdtsaccountservice.domain.exceptions.InvalidValueException;
import com.kevcode.cdtsaccountservice.domain.exceptions.NotSuficientFundsException;

public interface INationalTransactionService {
    Long withdraw(Long value, Long accountId) throws NotSuficientFundsException, InvalidValueException;

    Long deposit(Long value, Long accountId) throws InvalidValueException;

    Long getBalance(Long accountId) throws InvalidValueException;
}
