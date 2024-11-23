package com.security.bank.repository;

import com.security.bank.entity.Account;
import com.security.bank.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card,Long> {

    Optional<Card> findByCardNumber(Long cardNumber);
}
