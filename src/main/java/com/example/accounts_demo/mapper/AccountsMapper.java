package com.example.accounts_demo.mapper;

import com.example.accounts_demo.dto.AccountsDto;
import com.example.accounts_demo.entity.AccountsEntity;

public class AccountsMapper {

    private AccountsMapper(){}

    public static AccountsDto mapToAccountsDto(AccountsEntity accountsEntity){
        AccountsDto accountsDto = new AccountsDto();
        accountsDto.setAccountNumber(accountsEntity.getAccountNumber());
        accountsDto.setAccountType(accountsEntity.getAccountType());
        accountsDto.setBranchAddress(accountsEntity.getBranchAddress());
        return accountsDto;
    }

    public static AccountsEntity mapToAccountsEntity(AccountsDto accountsDto){
        AccountsEntity accountsEntity = new AccountsEntity();
        accountsEntity.setAccountNumber(accountsDto.getAccountNumber());
        accountsEntity.setAccountType(accountsDto.getAccountType());
        accountsEntity.setBranchAddress(accountsDto.getBranchAddress());
        return accountsEntity;
    }
}
