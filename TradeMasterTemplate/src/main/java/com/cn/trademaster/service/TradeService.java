package com.cn.trademaster.service;

import com.cn.trademaster.dto.TradeDto;
import com.cn.trademaster.model.Trade;
import com.cn.trademaster.repository.TradeRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TradeService {

    // Logger object creation
    private static final Logger logger = LoggerFactory.getLogger(TradeService.class);

    @Autowired
    private TradeRepo tradeRepo;

    public void executeTrade(TradeDto tradeDto) {
        // Map tradeDto to Trade entity
        Trade trade = new Trade();
        trade.setQuantity(tradeDto.getQuantity());
        trade.setStockHolderUserName(tradeDto.getStockHolderUserName());
        trade.setBuyTrade(tradeDto.isBuyTrade());
        trade.setStockId(tradeDto.getStockId());
        trade.setPrice(tradeDto.getPrice());
        trade.setStockHolderUserName(tradeDto.getStockHolderUserName());

        // Log error if quantity exceeds 1500
        if (trade.getQuantity() > 1500) {
            logger.error("Trade execution halted: Quantity of stock exceeds 1500.");
            return;
        }

        // Log a warning before saving the trade
        logger.warn("Saving trade. Please remember your unique username.");

        // Save trade entity
        tradeRepo.save(trade);

        // Log info after successful trade execution
        logger.info("Trade executed successfully for user: {}", trade.getStockHolderUserName());
    }

    public List<Trade> getTradeHistory(String username) {
        // Fetch trade history by username
        List<Trade> tradesByUsername = tradeRepo.findByStockHolderUserName(username);

        // Log error if no trades are found
        if (tradesByUsername.isEmpty()) {
            logger.error("No trades found for username: {}", username);
        } else {
            // Log info if trades are found
            logger.info("Trade history retrieved successfully for username: {}", username);
        }

        // Return the trade history list
        return tradesByUsername;
    }
}
