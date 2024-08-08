package com.example.accounts_demo.mapper;

import com.example.accounts_demo.dto.CustomerDto;
import com.example.accounts_demo.entity.CustomerEntity;

public class CustomerMapper {

    public static CustomerEntity maptoCustomerEntity(CustomerDto customerDto){
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName(customerDto.getName());
        customerEntity.setEmail(customerDto.getEmail());
        customerEntity.setMobileNumber(customerDto.getMobileNumber());
        return customerEntity;
    }

    public static CustomerDto maptoCustomerDto(CustomerEntity customerEntity){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName(customerEntity.getName());
        customerDto.setEmail(customerEntity.getEmail());
        customerDto.setMobileNumber(customerEntity.getMobileNumber());
        return customerDto;
    }
}
