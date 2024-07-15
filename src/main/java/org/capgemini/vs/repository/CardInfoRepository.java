package org.capgemini.vs.repository;

import org.capgemini.vs.model.CardInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CardInfoRepository extends JpaRepository<CardInfo, Long> {
    List<CardInfo> findByCardNumber(String cardNumber);
}
