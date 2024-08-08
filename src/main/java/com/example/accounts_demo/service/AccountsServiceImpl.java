package com.example.accounts_demo.service;

import com.example.accounts_demo.dto.CustomerDto;
import com.example.accounts_demo.entity.AccountsEntity;
import com.example.accounts_demo.entity.CustomerEntity;
import com.example.accounts_demo.exception.CustomerAlreadyExistsException;
import com.example.accounts_demo.mapper.CustomerMapper;
import com.example.accounts_demo.repository.AccountsRepo;
import com.example.accounts_demo.repository.CustomerRepo;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;


@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountsService{

    private static final Logger logger = LoggerFactory.getLogger(AccountsServiceImpl.class);

    private AccountsRepo accountsRepo;
    private CustomerRepo customerRepo;
    @Override
    public void createAccount(CustomerDto customerDto) {
        Optional<CustomerEntity> optionalCustomer = customerRepo.findByMobileNumber(customerDto.getMobileNumber());
        if(optionalCustomer.isPresent()){
            throw new CustomerAlreadyExistsException("Customer already exists with given mobile number : " + customerDto.getMobileNumber());
        }
        CustomerEntity customerEntity = CustomerMapper.maptoCustomerEntity(customerDto);
        customerEntity.setCreatedBy("SYSTEM");
        customerEntity.setCreatedAt(LocalDateTime.now());
        CustomerEntity savedCustomer = customerRepo.save(customerEntity);
        accountsRepo.save(createNewAccount(savedCustomer));
    }

    private AccountsEntity createNewAccount(CustomerEntity savedCustomer){
        AccountsEntity accountsEntity = new AccountsEntity();
        Long accountNumber = 1000_000_000L + new Random().nextInt(900_000_000);;
        accountsEntity.setAccountNumber(accountNumber);
        accountsEntity.setCustomerId(savedCustomer.getCustomerId());
        accountsEntity.setAccountType("Savings");
        accountsEntity.setBranchAddress("A/P Fulchincholi, Tal-Pandharpur, Dist-Solapur, Pin-413304");
        accountsEntity.setCreatedBy("SYSTEM");
        accountsEntity.setCreatedAt(LocalDateTime.now());
        return accountsEntity;
    }

    @Override
    public CustomerDto fetchAccount(String mobileNumber) {
        return null;
    }

    @Override
    public boolean updateAccount(CustomerDto customerDto) {
        return false;
    }

    @Override
    public boolean deleteAccount(String mobileNumber) {
        return false;
    }
}
