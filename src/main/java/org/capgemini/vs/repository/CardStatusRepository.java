package org.capgemini.vs.repository;

import jakarta.transaction.Transactional;
import org.capgemini.vs.model.CardStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardStatusRepository  extends JpaRepository<CardStatus, Long> {
    @Transactional
    void deleteByCardInfoCardId(Long cardId);
    List<CardStatus> findByCardInfoCardId(Long cardId);
}
