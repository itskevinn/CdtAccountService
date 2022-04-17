package com.kevcode.cdtsaccountservice.domain.bank.repository;


public interface INationalTransactionRepository {
    Long withdraw(Long value, Long accountId);

    Long deposit(Long value, Long accountId);

    Long getBalance(Long accountId);
}
