package com.example.accounts_demo.controller;


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

}
