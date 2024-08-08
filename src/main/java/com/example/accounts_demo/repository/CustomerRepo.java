package com.example.accounts_demo.repository;

import com.example.accounts_demo.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity,Long> {

    Optional<CustomerEntity> findByMobileNumber(String mobileNumber);

}
