package com.example.accounts_demo.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="customer")
@AllArgsConstructor @NoArgsConstructor @Setter @Getter @ToString
public class CustomerEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String name, mobileNumber, email;

}
