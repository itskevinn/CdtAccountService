package com.kevcode.cdtsaccountservice.api.controllers;

import com.kevcode.cdtsaccountservice.application.CdtsAccount.dto.CdtAccountDto;
import com.kevcode.cdtsaccountservice.application.CdtsAccount.request.CdtAccountRequest;
import com.kevcode.cdtsaccountservice.application.CdtsAccount.services.ICdtsAccountService;
import com.kevcode.cdtsaccountservice.application.shared.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/CdtAccount")
public class CdtAccountController {
    private final ICdtsAccountService _cdtAccountService;

    @Autowired
    public CdtAccountController(ICdtsAccountService cdtAccountService) {
        _cdtAccountService = cdtAccountService;
    }

    @PostMapping("/Create")
    public Response<CdtAccountDto> create(@RequestBody CdtAccountRequest request) {
        return _cdtAccountService.create(request);
    }

    @GetMapping("/GetBalance/{accountId}")
    public Response<Long> getBalance(@PathVariable Long accountId) {
        return _cdtAccountService.getBalance(accountId);
    }

    @GetMapping("/GetByCustomerId/{customerId}")
    public Response<List<CdtAccountDto>> getByCustomerId(@PathVariable Long customerId) {
        try {
            List<CdtAccountDto> accountDtos = _cdtAccountService.getByCustomerId(customerId);
            return new Response<>(accountDtos, HttpStatus.OK, "Cuentas recuperadas!");
        } catch (Exception e) {
            return new Response<>(null, HttpStatus.INTERNAL_SERVER_ERROR, "Ocurrió un error", e);
        }

    }
}
