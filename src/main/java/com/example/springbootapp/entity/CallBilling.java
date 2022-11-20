package com.example.springbootapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "call_billing")
@Entity
@Data
@NoArgsConstructor
public class CallBilling {
    @Id
    @Column(name = "user_name")
    String userName;
    @Column(name = "call_count")
    int callCount;
    @Column(name = "block_count")
    long blockCount;
}
