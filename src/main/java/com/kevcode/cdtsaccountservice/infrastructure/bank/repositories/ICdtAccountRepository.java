package com.kevcode.cdtsaccountservice.infrastructure.bank.repositories;

import com.kevcode.cdtsaccountservice.domain.bank.entities.CdtAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICdtAccountRepository extends JpaRepository<CdtAccount, Long> {
}
