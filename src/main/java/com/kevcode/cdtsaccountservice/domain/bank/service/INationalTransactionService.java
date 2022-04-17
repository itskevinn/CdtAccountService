package com.kevcode.cdtsaccountservice.domain.bank.service;

import com.kevcode.cdtsaccountservice.domain.bank.exceptions.InvalidValueException;
import com.kevcode.cdtsaccountservice.domain.bank.exceptions.InsufficientFundsException;

public interface INationalTransactionService {
    Long withdraw(Long value, Long accountId) throws InsufficientFundsException, InvalidValueException;

    Long deposit(Long value, Long accountId) throws InvalidValueException;

    Long getBalance(Long accountId) throws InvalidValueException;
}
