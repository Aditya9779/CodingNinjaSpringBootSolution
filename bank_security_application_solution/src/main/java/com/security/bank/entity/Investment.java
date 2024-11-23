package com.security.bank.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Investment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(EnumType.STRING)
  private InvestmentType investmentType;

  private String risk;

  private double amount;

  private float returns;

  private String duration;

  private String companyName;

  @ManyToOne
  @JsonIgnoreProperties("investmentList")
  @JoinColumn(name = "user_id")
  private User user;

}


