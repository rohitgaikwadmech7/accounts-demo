package com.example.accounts_demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor @NoArgsConstructor
public class CustomerDto {

    @NotEmpty(message = "name can not be null or empty")
    @Size(min=5,max = 30,message = "The length of customer name must be between 5 and 30")
    private String name;

    @Email(message = "Email address should have valid value")
    @NotEmpty(message = "Email address can not be null or empty")
    private String email;

    @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile Number must be 10 digit")
    private String mobileNumber;

    private AccountsDto accountsDto;
}
