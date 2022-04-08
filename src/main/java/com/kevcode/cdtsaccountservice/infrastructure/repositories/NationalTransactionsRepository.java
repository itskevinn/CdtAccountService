package com.kevcode.cdtsaccountservice.infrastructure.repositories;

import com.kevcode.cdtsaccountservice.domain.repository.INationalTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class NationalTransactionsRepository implements INationalTransactionRepository {
    @Autowired
    private JdbcTemplate _jdbcTemplate;

    @Override
    public Long withdraw(Long value, Long accountId) {
        SimpleJdbcCall jdbcCall = getSimpleJdbcCall("SP_WITHDRAW");
        SqlParameterSource parameterSource =
                new MapSqlParameterSource().addValue("value", value).addValue("accountId", accountId);
        Map<String, Object> executionResult = jdbcCall.execute(parameterSource);
        return (Long) executionResult.get("balance");
    }

    @Override
    public Long deposit(Long value, Long accountId) {
        return null;
    }

    @Override
    public Long getBalance(Long accountId) {
        SimpleJdbcCall jdbcCall = getSimpleJdbcCall("SP_GET_CDT_BALANCE");
        SqlParameterSource parameterSource =
                new MapSqlParameterSource().addValue("accountId", accountId);
        Map<String, Object> executionResult = jdbcCall.execute(parameterSource);
        Object result = executionResult.get("BALANCE");
        String balance = result == null ? "0" : (String) result;
        return Long.parseLong(balance);
    }

    private SimpleJdbcCall getSimpleJdbcCall(String procedureName) {
        return new SimpleJdbcCall(_jdbcTemplate).withProcedureName(procedureName);
    }
}
