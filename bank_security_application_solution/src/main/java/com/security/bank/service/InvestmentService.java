package com.security.bank.service;

import com.security.bank.dto.InvestmentDto;
import com.security.bank.entity.Account;
import com.security.bank.entity.Investment;
import com.security.bank.entity.InvestmentType;
import com.security.bank.entity.User;
import com.security.bank.repository.AccountRepository;
import com.security.bank.repository.InvestmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class InvestmentService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    InvestmentRepository investmentRepository;
    public String investNow(Long accountId, InvestmentDto investmentDto) {
        Account account = accountRepository.findById(accountId).get();
        User user =  account.getUser();
        if(account.getBalance()>investmentDto.getAmount()){
            Investment investment = new Investment();
            switch (investmentDto.getInvestmentType()) {
                case "GOLD" -> {
                    investment.setInvestmentType(InvestmentType.GOLD);
                    investment.setRisk("Low");
                    investment.setReturns(12F);
                    investment.setCompanyName("BuyNow");
                }
                case "STOCKS" -> {
                    investment.setInvestmentType(InvestmentType.STOCKS);
                    investment.setRisk("high");
                    investment.setReturns(20F);
                    investment.setCompanyName("StockWay");
                }
                case "MUTUAL_FUND" -> {
                    investment.setInvestmentType(InvestmentType.MUTUAL_FUND);
                    investment.setRisk("Moderate");
                    investment.setReturns(12.3F);
                    investment.setCompanyName("ray fund");
                }
                default -> {
                    investment.setInvestmentType(InvestmentType.FIXED_DEPOSITS);
                    investment.setRisk("Low");
                    investment.setReturns(9.20F);
                    investment.setCompanyName("PST");
                }
            }
            investment.setAmount(investmentDto.getAmount());
            investment.setDuration(investmentDto.getDuration());
            investment.setUser(user);
            investmentRepository.save(investment);
            return "Investment successful";
        }
        throw new RuntimeException("Error in Investment");
    }
}
