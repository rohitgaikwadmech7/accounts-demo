package com.example.accounts_demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class CustomerDto {

    private String name, email, mobileNumber;
    private AccountsDto accountsDto;
}
