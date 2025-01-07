package com.cn.trademaster.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TradeDto {

    private Integer stockId;
    private String stockName;
    private Integer quantity;
    private String stockHolderUserName;
    private Double price;
    private boolean buyTrade;
}
