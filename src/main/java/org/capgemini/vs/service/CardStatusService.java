package org.capgemini.vs.service;

import org.capgemini.vs.model.CardStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CardStatusService {
    CardStatus createCardStatusForCardId(Long cardId, CardStatus cardStatus);

    CardStatus updateCardStatus(Long cardStatusId, CardStatus cardStatus);

    void deleteCardStatusByCardStatusId(Long cardStatusId);

    void deleteAllCardStatusByCardId(Long cardInfo);

    List<CardStatus>  getAllCardStatusesByCardId(Long cardId);

    CardStatus getCardStatusByCardStatusId(Long cardStatusId);
}
