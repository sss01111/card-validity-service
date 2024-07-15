package org.capgemini.vs.service;

import org.capgemini.vs.exception.ResourceNotFoundException;
import org.capgemini.vs.model.CardInfo;
import org.capgemini.vs.model.CardStatus;
import org.capgemini.vs.repository.CardInfoRepository;
import org.capgemini.vs.repository.CardStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;

@Service
public class CardStatusServiceImpl implements CardStatusService{
    @Autowired
    CardInfoRepository cardInfoRepository;
    @Autowired
    CardStatusRepository cardStatusRepository;

    @Override
    public CardStatus createCardStatusForCardId(Long cardId, CardStatus cardStatus) {
        CardStatus cardStatusCreated = cardInfoRepository.findById(cardId).map(cardInfo -> {
            if(cardStatus.getCardNumber()!=null)
                cardStatus.setCardNumber(cardStatus.getCardNumber());
            else
                cardStatus.setCardNumber(cardInfo.getCardNumber());
            cardStatus.setStatusStartDate(LocalDate.now());
            cardStatus.setStatusEndDate(LocalDate.now().plusYears(3));
            cardStatus.setStatusValidity("status is valid till: "+cardStatus.getStatusEndDate());
            cardStatus.setCardInfo(cardInfo);
            return cardStatusRepository.save(cardStatus);
        }).orElseThrow(()-> new ResourceNotFoundException("resource not found with card id: "+cardId));

        return cardStatusCreated;
    }

    @Override
    public CardStatus updateCardStatus(Long cardStatusId, CardStatus cardStatus) {
        CardStatus cardStatusToUpdate = cardStatusRepository.findById(cardStatusId).orElseThrow(()->{
            return new ResourceNotFoundException("resource not found with card status id: "+cardStatusId);
        });
        cardStatusToUpdate.setCardNumber(cardStatus.getCardNumber());
        cardStatusToUpdate.setStatusStartDate(cardStatus.getStatusStartDate());
        cardStatusToUpdate.setStatusEndDate(cardStatus.getStatusEndDate());
        return cardStatusRepository.save(cardStatusToUpdate);
    }

    @Override
    public void deleteCardStatusByCardStatusId(Long cardStatusId) {
        cardStatusRepository.deleteById(cardStatusId);
    }

    @Override
    public void deleteAllCardStatusByCardId(Long cardId) {
        if(!cardInfoRepository.existsById(cardId)){
            throw new ResourceNotFoundException("resource not found with card id: "+cardId);
        }
        cardStatusRepository.deleteByCardInfoCardId(cardId);
    }

    @Override
    public List<CardStatus> getAllCardStatusesByCardId(Long cardId) {
        if(!cardInfoRepository.existsById(cardId)){
            throw new ResourceNotFoundException("resource not found with card id: "+cardId);
        }
        return cardStatusRepository.findByCardInfoCardId(cardId);
    }

    @Override
    public CardStatus getCardStatusByCardStatusId(Long cardStatusId) {
        CardStatus cardStatus = cardStatusRepository.findById(cardStatusId)
                .orElseThrow(() -> new ResourceNotFoundException("card status not found with card status id = " + cardStatusId));
        return cardStatus;
    }
}
