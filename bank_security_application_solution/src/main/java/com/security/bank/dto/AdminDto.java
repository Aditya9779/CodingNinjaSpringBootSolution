package com.security.bank.dto;

import lombok.Data;

@Data
public class AdminDto {
    private String name;
    private String username;
    private String password;
    private String address;
    private Long number;
    private String identityProof;
}
