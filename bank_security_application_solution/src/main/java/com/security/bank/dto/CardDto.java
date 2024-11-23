package com.security.bank.dto;

import lombok.Data;

@Data
public class CardDto {

    private String cardHolderName;

    private String cardType;

    private Long pin;
}
