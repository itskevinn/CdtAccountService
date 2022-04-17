package com.kevcode.cdtsaccountservice.application.CdtsAccount.services;

import com.kevcode.cdtsaccountservice.application.CdtsAccount.dto.CdtAccountDto;
import com.kevcode.cdtsaccountservice.application.CdtsAccount.request.CdtAccountRequest;
import com.kevcode.cdtsaccountservice.application.shared.Response;

import java.util.List;

public interface ICdtsAccountService {
    Response<Long> withdraw(Long value, Long accountId);

    Response<Long> deposit(Long value, Long accountId);

    Response<Long> getBalance(Long accountId);

    Response<CdtAccountDto> create(CdtAccountRequest request);

    Response<CdtAccountDto> getById(Long accountId);

    List<CdtAccountDto> getByCustomerId(Long customerId);
}
