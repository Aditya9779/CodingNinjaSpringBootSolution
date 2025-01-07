package com.cn.trademaster.repository;

import com.cn.trademaster.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeRepo extends JpaRepository<Trade, Integer> {

    List<Trade> findByStockHolderUserName(String stockHolderUserName);

}
