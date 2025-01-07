package com.cn.trademaster.controller;

import com.cn.trademaster.dto.TradeDto;
import com.cn.trademaster.model.Trade;
import com.cn.trademaster.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tradeMasterApp")
public class TradeMasterController {

    @Autowired
    private TradeService tradeService;



    @PostMapping("/execute-trade")
    public void executeTrade(@RequestBody TradeDto tradeDto){

            tradeService.executeTrade(tradeDto);

        }


    @GetMapping("/tradeHistory/{username}")
    public List<Trade> getTradeHistoryForUser(@PathVariable String username){
        return tradeService.getTradeHistory(username);
    }
}
