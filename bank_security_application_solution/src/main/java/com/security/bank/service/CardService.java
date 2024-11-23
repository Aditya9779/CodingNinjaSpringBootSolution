package com.security.bank.service;

import com.security.bank.dto.CardDto;
import com.security.bank.entity.Account;
import com.security.bank.entity.Card;
import com.security.bank.entity.CardType;
import com.security.bank.repository.AccountRepository;
import com.security.bank.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CardService {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    CardRepository cardRepository;

    public String blockCard(Long accountNumber, Long cardNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber).get();
        Card card = cardRepository.findByCardNumber(cardNumber).get();
        if(account.getCard().getCardNumber().equals(card.getCardNumber())){
            account.setCard(null);
            accountRepository.save(account);
            cardRepository.deleteById(card.getId());
            return "Card Blocked Successfully";
        }
        throw new RuntimeException("No Card Found with the given cardNumber: "+ cardNumber);
    }

    public String applyNewCard(Long accountNumber, CardDto cardDto) {
        Account account = accountRepository.findByAccountNumber(accountNumber).get();
        if(account.getCard() != null && account.getCard().getCardNumber() != null){
            throw new RuntimeException("Account with number: "+ accountNumber+" already has a card.");
        }
        Card card = new Card();
        card.setCardNumber(Long.parseLong(generateCardNumber()));
        card.setCvv(generateCvv());
        switch (cardDto.getCardType()) {
            case "DEBIT_CLASSIC" -> {
                card.setDailyLimit(20000);
                card.setCardType(CardType.DEBIT_CLASSIC);
            }
            case "CREDIT_PREMIUM" -> {
                card.setDailyLimit(50000);
                card.setCardType(CardType.CREDIT_PREMIUM);
            }
            case "CREDIT_MASTER" -> {
                card.setDailyLimit(75000);
                card.setCardType(CardType.CREDIT_MASTER);
            }
            default -> {
                card.setDailyLimit(40000);
                card.setCardType(CardType.DEBIT_GLOBAL);
            }
        }
        card.setPin(cardDto.getPin());
        card.setAllocationDate(new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, 5);
        card.setExpiryDate(calendar.getTime());
        card.setCardHolderName(cardDto.getCardHolderName());
        card.setStatus("ACTIVE");
        Card savedCard = cardRepository.save(card);
        account.setCard(savedCard);
        accountRepository.save(account);
        return "New Card Allocated to account wih Number: "+ accountNumber;
    }

    public int generateCvv() {
        Random random = new Random();
        // Generating a random 3-digit number for CVV
        return random.nextInt(900) + 100;
    }

    public String generateCardNumber() {
        StringBuilder cardNumber = new StringBuilder();
        Random random = new Random();

        // Generating a 16-digit card number
        for (int i = 0; i < 16; i++) {
            int digit = random.nextInt(10);
            cardNumber.append(digit);
        }
        return cardNumber.toString();
    }

    public void modifySetting(Long cardNumber, Card carDto) {
        Optional<Card> optionalCard = cardRepository.findByCardNumber(cardNumber);
        Double cardLimit = carDto.getDailyLimit();
        Card fetchedCard = optionalCard.get();
        switch(fetchedCard.getCardType()){
            case DEBIT_GLOBAL -> {
            if(cardLimit != 0 && carDto.getDailyLimit()<= 50000) fetchedCard.setDailyLimit(carDto.getDailyLimit());
            }
            case DEBIT_CLASSIC -> {
            if(cardLimit != 0 && carDto.getDailyLimit()<= 40000) fetchedCard.setDailyLimit(carDto.getDailyLimit());
            }
            case CREDIT_MASTER -> {
            if(cardLimit != 0 && carDto.getDailyLimit()<= 100000) fetchedCard.setDailyLimit(carDto.getDailyLimit());
            }
            case CREDIT_PREMIUM -> {
            if(cardLimit != 0 && carDto.getDailyLimit()<= 75000)  fetchedCard.setDailyLimit(carDto.getDailyLimit());
            }
        }
        if(carDto.getPin()!=null) fetchedCard.setPin(carDto.getPin());
        cardRepository.save(fetchedCard);
    }
}
