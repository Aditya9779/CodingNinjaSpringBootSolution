package com.cn.trademaster.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer tradeId;
    private Integer stockId;
    private String stockName;
    private String stockHolderUserName;
    private Integer quantity;
    private Double price;
    private boolean buyTrade;


}

