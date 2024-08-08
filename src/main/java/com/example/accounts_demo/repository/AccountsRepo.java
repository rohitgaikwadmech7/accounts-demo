package com.example.accounts_demo.repository;

import com.example.accounts_demo.entity.AccountsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountsRepo extends JpaRepository<AccountsEntity,Long> {
}
