package com.kevcode.cdtsaccountservice.infrastructure.bank.repositories;

import com.kevcode.cdtsaccountservice.domain.bank.entities.CdtAccount;
import com.kevcode.cdtsaccountservice.domain.bank.repository.ICdtAccountCustomRepository;
import com.kevcode.cdtsaccountservice.infrastructure.bank.mapping.CdtAccountMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CdtAccountCustomRepository implements ICdtAccountCustomRepository {
    private final JdbcTemplate _jdbcTemplate;

    @Autowired
    public CdtAccountCustomRepository(JdbcTemplate jdbcTemplate) {
        _jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<CdtAccount> getByCustomerId(Long customerId) {
        String sqlQuery = "SELECT BALANCE, ID, CUSTOMER_ID FROM CDT_ACCOUNT WHERE CUSTOMER_ID = ?";
        return _jdbcTemplate.query(sqlQuery, new CdtAccountMapping(), customerId);
    }
}
