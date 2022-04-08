package com.kevcode.cdtsaccountservice.application.CdtsAccount.services;

import com.kevcode.cdtsaccountservice.application.CdtsAccount.dto.CdtAccountDto;
import com.kevcode.cdtsaccountservice.application.CdtsAccount.request.CdtAccountRequest;
import com.kevcode.cdtsaccountservice.application.shared.Response;
import com.kevcode.cdtsaccountservice.domain.entities.CdtAccount;
import com.kevcode.cdtsaccountservice.domain.repository.INationalTransactionRepository;
import com.kevcode.cdtsaccountservice.infrastructure.repositories.ICdtsAccountRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CdtsAccountService implements ICdtsAccountService {

    @Autowired
    private INationalTransactionRepository _nationalTransactionRepository;

    @Autowired
    private ICdtsAccountRepository _cdtsAccountRepository;

    @Autowired
    private ModelMapper _modelMapper;

    @Override
    public Response<Long> withdraw(Long value, Long accountId) {
        return null;
    }

    @Override
    public Response<Long> deposit(Long value, Long accountId) {
        return null;
    }

    @Override
    public Response<Long> getBalance(Long accountId) {
        try {
            if (accountId <= 0) return new Response<>(null, HttpStatus.BAD_REQUEST, "Ingrese un valor válido");
            Long balance = _nationalTransactionRepository.getBalance(accountId);
            return new Response<>(balance, HttpStatus.OK, "Este es su balance " + balance);
        } catch (Exception e) {
            return new Response<>(null, HttpStatus.INTERNAL_SERVER_ERROR, "Ocurrió un error :(", e.getMessage());
        }
    }

    @Override
    public Response<CdtAccountDto> create(CdtAccountRequest request) {
        try {
            CdtAccount account = new CdtAccount();
            account.setPersonId(request.getPersonId());
            account = _cdtsAccountRepository.save(account);
            CdtAccountDto cdtAccountDto = _modelMapper.map(account, CdtAccountDto.class);
            return new Response<>(cdtAccountDto, HttpStatus.OK, "Cuenta creada!");
        } catch (Exception e) {
            return new Response<>(null, HttpStatus.INTERNAL_SERVER_ERROR, "Ocurrió un error", e.getMessage());
        }
    }

    @Override
    public Response<CdtAccountDto> getById(Long accounId) {
        return null;
    }

    @Override
    public Response<List<CdtAccountDto>> getByPersonId(Long personId) {
        return null;
    }
}
