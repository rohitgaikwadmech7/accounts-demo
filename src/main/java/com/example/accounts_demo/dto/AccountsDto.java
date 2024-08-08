package com.example.accounts_demo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class AccountsDto {

    private String accountType, branchAddress;

    private Long accountNumber;
}
