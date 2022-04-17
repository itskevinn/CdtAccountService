package com.kevcode.cdtsaccountservice.infrastructure.bank.mapping;

import com.kevcode.cdtsaccountservice.domain.bank.entities.CdtAccount;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CdtAccountMapping implements RowMapper<CdtAccount> {
    @Override
    public CdtAccount mapRow(ResultSet rs, int rowNum) throws SQLException {
        CdtAccount cdtAccount = new CdtAccount();
        cdtAccount.setId(rs.getLong("ID"));
        cdtAccount.setCustomerId(rs.getLong("customer_id"));
        cdtAccount.setBalance(rs.getLong("balance"));
        return cdtAccount;
    }
}
