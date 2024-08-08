package com.example.accounts_demo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="accounts")
@Setter @Getter @ToString @AllArgsConstructor @NoArgsConstructor
public class AccountsEntity extends BaseEntity{


    @Id
    private Long accountNumber;

    private Long customerId;

    private String accountType, branchAddress;

}
