package com.kevcode.cdtsaccountservice.domain.repository;


public interface INationalTransactionRepository {
    Long withdraw(Long value, Long accountId);

    Long deposit(Long value, Long accountId);

    Long getBalance(Long accountId);
}
