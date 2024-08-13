package com.example.accounts_demo.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //@AllArgsConstructor @NoArgsConstructor
public class AccountsDto {

    @NotEmpty(message = "Account Type can not be null or empty")
    private String accountType;

    @NotEmpty(message = "BranchAddress can not be null or empty")
    private String branchAddress;

    @NotEmpty(message = "Account Number can not be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Account number should be  10 digit")
    private Long accountNumber;
}
