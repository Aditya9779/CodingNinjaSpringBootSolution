package com.security.bank.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long cardNumber;

    private String cardHolderName;

    @Enumerated(EnumType.STRING)
    private CardType cardType;

    private double dailyLimit;

    private int cvv;

    private Date allocationDate;

    private Date expiryDate;

    private Long pin;

    private String status;

}
