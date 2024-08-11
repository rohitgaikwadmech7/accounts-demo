package com.example.accounts_demo.controller;


import com.example.accounts_demo.constants.AccountsConstants;
import com.example.accounts_demo.dto.CustomerDto;
import com.example.accounts_demo.dto.ResponseDto;
import com.example.accounts_demo.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping(path = "/api/v1", produces ={MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class AccountsController {

    private static final Logger logger = LoggerFactory.getLogger(AccountsController.class);

    private IAccountsService accountsService;

    @GetMapping("/msg")
    public String getMsg(){
        return "Hello-World";
    }


    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto){
         accountsService.createAccount(customerDto);
         return new ResponseEntity<>(
                 new ResponseDto("Account Created Successfully", HttpStatus.CREATED.toString()),
                 HttpStatus.CREATED
         );
    }

    @GetMapping("/get")
    public ResponseEntity<CustomerDto> fetchCustomerDetails(@RequestParam String mobileNumber){
        CustomerDto customerDto = accountsService.fetchAccount(mobileNumber);
        return new ResponseEntity<>(customerDto,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateCustomerDetails(@RequestBody CustomerDto customerDto){
        boolean isUpdated = accountsService.updateAccount(customerDto);
        if(isUpdated){
            return new ResponseEntity<>(
                    new ResponseDto(AccountsConstants.MESSAGE_200,AccountsConstants.STATUS_200),HttpStatus.OK
            );
        }else {
            return new ResponseEntity<>(
                    new ResponseDto(AccountsConstants.MESSAGE_417_UPDATE,AccountsConstants.STATUS_417),
                    HttpStatus.EXPECTATION_FAILED
            );
        }
    }


    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteCustomer(@RequestParam String mobileNumber){
        boolean isDeleted = accountsService.deleteAccount(mobileNumber);
        if(isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(AccountsConstants.STATUS_417, AccountsConstants.MESSAGE_417_DELETE));
        }
    }

}
