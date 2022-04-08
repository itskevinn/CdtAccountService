package com.kevcode.cdtsaccountservice.infrastructure.repositories;

import com.kevcode.cdtsaccountservice.domain.entities.CdtAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICdtsAccountRepository extends JpaRepository<CdtAccount, Long> {
}
