package com.example.springboot.springassignment.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "consumer_details")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Consumers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "consumerId")
    private int id;
    @Column(name = "consumerName")
    @NotEmpty(message = "is required")
    private String consumerName;
    @Column(name = "fatherName")
    @NotEmpty(message = "is required")
    private String fatherName;
    @Column(name = "email")
    @NotEmpty(message = "is required")
    private String email;
    @Column(name = "Address")
    private String address;
    @Column(name = "oldMeterReadingDate")
    private String oldMeterReadingDate;
    @Column(name = "newMeterReadingDate")
    private String newMeterReadingDate;
    @Column(name = "oldReading")
    private int oldReading;
    @Column(name = "newReading")
    private int newReading;
    @Column(name = "unitConsumed")
    private int unitConsumed;
    @Column(name = "chargePerUnit")
    private float chargePerUnit;
    @Column(name = "dueBill")
    private int dueBill;
    @Column(name = "totalBill")
    private int totalBill;
    @Column(name = "billNo")
    private int billNo;



}
