package com.kevcode.cdtsaccountservice.domain.bank.repository;

import com.kevcode.cdtsaccountservice.domain.bank.entities.CdtAccount;

import java.util.List;

public interface ICdtAccountCustomRepository {
    List<CdtAccount> getByCustomerId(Long customerId);
}
