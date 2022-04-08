package com.kevcode.cdtsaccountservice.api.controllers;

import com.kevcode.cdtsaccountservice.application.CdtsAccount.dto.CdtAccountDto;
import com.kevcode.cdtsaccountservice.application.CdtsAccount.request.CdtAccountRequest;
import com.kevcode.cdtsaccountservice.application.CdtsAccount.services.CdtsAccountService;
import com.kevcode.cdtsaccountservice.application.shared.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/CdtsAccount")
public class CdtsAccountController {
    @Autowired
    CdtsAccountService _cdtsAccountRepository;

    @PostMapping("/Create")
    public Response<CdtAccountDto> create(@RequestBody CdtAccountRequest request) {
        return _cdtsAccountRepository.create(request);
    }

    @GetMapping("/GetBalance/{accountId}")
    public Response<Long> getBalance(@PathVariable Long accountId) {
        return _cdtsAccountRepository.getBalance(accountId);
    }
}
