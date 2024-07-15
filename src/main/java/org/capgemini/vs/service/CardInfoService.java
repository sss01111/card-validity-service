package org.capgemini.vs.service;

import org.capgemini.vs.model.CardInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CardInfoService {

    public List<CardInfo> getAllCardInfos(String cardNumber);

    List<CardInfo> getAllCardInfosByCardNumber(String cardNumber);

    CardInfo getCardInfoByCardId(Long cardId);

    CardInfo createCardInfo(CardInfo cardInf);

    void deleteCardInfoByCardId(Long cardId);

    void deleteAllCardInfos();

    CardInfo updateCardInfo(CardInfo cardInf);
}
