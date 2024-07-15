package org.capgemini.vs.service;

import jakarta.annotation.Resource;
import org.capgemini.vs.exception.ResourceNotFoundException;
import org.capgemini.vs.model.CardInfo;
import org.capgemini.vs.repository.CardInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CardInfoServiceImpl implements CardInfoService{
    @Autowired
    CardInfoRepository cardInfoRepository;

    @Override
    public List<CardInfo> getAllCardInfos(String cardNumber) {
        return null;
    }

    @Override
    public List<CardInfo> getAllCardInfosByCardNumber(String cardNumber) {
        List<CardInfo> cardInfos = null;
        if(cardNumber!=null){
            cardInfos = cardInfoRepository.findByCardNumber(cardNumber);
        }
        else{
            cardInfos = cardInfoRepository.findAll();
        }

        return cardInfos;
    }

    @Override
    public CardInfo getCardInfoByCardId(Long cardId) {
        CardInfo cardInfo = cardInfoRepository.findById(cardId).orElseThrow(()->{
            return new ResourceNotFoundException("resource not found with card id: "+cardId);
        });
        return cardInfo;
    }

    @Override
    public CardInfo createCardInfo(CardInfo cardInf) {
        CardInfo cardInfo = new CardInfo(cardInf.getCardNumber(), LocalDate.now());


        return cardInfoRepository.save(cardInfo);
    }

    @Override
    public void deleteCardInfoByCardId(Long cardId) {
        cardInfoRepository.deleteById(cardId);
    }

    @Override
    public void deleteAllCardInfos() {
        cardInfoRepository.deleteAll();
    }

    @Override
    public CardInfo updateCardInfo(CardInfo cardInf) {
        CardInfo cardInfo = cardInfoRepository.findById(cardInf.getCardId())
        .orElseThrow(()-> new ResourceNotFoundException("resource not found with the card id "+cardInf.getCardId()));

        cardInfo.setCardNumber(cardInf.getCardNumber());
        cardInfo.setIssueDate(cardInf.getIssueDate());

        return cardInfoRepository.save(cardInfo);
    }
}
