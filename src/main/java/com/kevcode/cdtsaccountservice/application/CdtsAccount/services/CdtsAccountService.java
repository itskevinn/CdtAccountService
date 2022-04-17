package com.kevcode.cdtsaccountservice.application.CdtsAccount.services;

import com.kevcode.cdtsaccountservice.application.CdtsAccount.dto.CdtAccountDto;
import com.kevcode.cdtsaccountservice.application.CdtsAccount.request.CdtAccountRequest;
import com.kevcode.cdtsaccountservice.application.shared.Response;
import com.kevcode.cdtsaccountservice.domain.bank.entities.CdtAccount;
import com.kevcode.cdtsaccountservice.domain.bank.repository.ICdtAccountCustomRepository;
import com.kevcode.cdtsaccountservice.domain.bank.repository.INationalTransactionRepository;
import com.kevcode.cdtsaccountservice.infrastructure.bank.repositories.ICdtAccountRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CdtsAccountService implements ICdtsAccountService {
    private final INationalTransactionRepository _nationalTransactionRepository;
    private final ICdtAccountRepository _cdtAccountRepository;
    private final ICdtAccountCustomRepository _cdtAccountCustomRepository;
    private final ModelMapper _modelMapper;

    @Autowired
    public CdtsAccountService(ModelMapper modelMapper,
                              INationalTransactionRepository nationalTransactionRepository,
                              ICdtAccountRepository cdtAccountRepository,
                              ICdtAccountCustomRepository cdtAccountCustomRepository) {
        _modelMapper = modelMapper;
        _cdtAccountRepository = cdtAccountRepository;
        _nationalTransactionRepository = nationalTransactionRepository;
        _cdtAccountCustomRepository = cdtAccountCustomRepository;
    }

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
            this.setMatchingStrategyLooseModelMapper();
            if (accountId <= 0) return new Response<>(null, HttpStatus.BAD_REQUEST, "Ingrese un valor válido");
            Long balance = _nationalTransactionRepository.getBalance(accountId);
            return new Response<>(balance, HttpStatus.OK, "Este es su balance " + balance);
        } catch (Exception e) {
            return new Response<>(null, HttpStatus.INTERNAL_SERVER_ERROR, "Ocurrió un error :(", e);
        }
    }

    @Override
    public Response<CdtAccountDto> create(CdtAccountRequest request) {
        try {
            this.setMatchingStrategyLooseModelMapper();
            CdtAccount account = new CdtAccount();
            account.setCustomerId(request.getCustomerId());
            account = _cdtAccountRepository.save(account);
            CdtAccountDto cdtAccountDto = _modelMapper.map(account, CdtAccountDto.class);
            return new Response<>(cdtAccountDto, HttpStatus.OK, "Cuenta creada!");
        } catch (Exception e) {
            return new Response<>(null, HttpStatus.INTERNAL_SERVER_ERROR, "Ocurrió un error", e);
        }
    }

    @Override
    public Response<CdtAccountDto> getById(Long accountId) {
        return null;
    }

    @Override
    public List<CdtAccountDto> getByCustomerId(Long customerId) {
        this.setMatchingStrategyLooseModelMapper();
        List<CdtAccount> accounts = _cdtAccountCustomRepository.getByCustomerId(customerId);
        List<CdtAccountDto> accountDtos = _modelMapper.map(accounts, new TypeToken<List<CdtAccountDto>>() {
        }.getType());
        return accountDtos;
    }

    private void setMatchingStrategyLooseModelMapper() {
        _modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
    }
}
