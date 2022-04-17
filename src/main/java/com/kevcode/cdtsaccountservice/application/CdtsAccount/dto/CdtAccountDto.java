package com.kevcode.cdtsaccountservice.application.CdtsAccount.dto;

import lombok.Data;

@Data
public class CdtAccountDto {
    private Long id;
    private Long balance;
    private Long customerId;
}
