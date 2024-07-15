package org.capgemini.vs.controller;

import org.capgemini.vs.model.CardStatus;
import org.capgemini.vs.service.CardStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CardStatusController {

    @Autowired
    CardStatusService cardStatusService;

    //tested
    @PostMapping("/cardInfos/{cardId}/cardStatus")
    public ResponseEntity<CardStatus> createCardStatus(@PathVariable("cardId") Long cardId, @RequestBody CardStatus cardStatus){
        CardStatus cardStatusCreated = cardStatusService.createCardStatusForCardId(cardId, cardStatus);

        return new ResponseEntity<>(cardStatusCreated,HttpStatus.CREATED);
    }
    //tested
    @PutMapping("/cardStatus/{cardStatusId}")
    public ResponseEntity<CardStatus> updateCardStatus(@PathVariable("cardStatusId") Long cardStatusId, @RequestBody CardStatus cardStatus){
        CardStatus cardStatusUpdated = cardStatusService.updateCardStatus( cardStatusId,  cardStatus);

        return new ResponseEntity<>(cardStatusUpdated,HttpStatus.OK);
    }
    //tested
    @DeleteMapping("/cardStatus/{cardStatusId}")
    public ResponseEntity<HttpStatus> deleteCardStatusById(@PathVariable("cardStatusId") Long cardStatusId){
        cardStatusService.deleteCardStatusByCardStatusId(cardStatusId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/cardInfos/{cardId}/cardStatus")
    public ResponseEntity<HttpStatus> deleteAllCardStatusesByCardId(@PathVariable("cardId") Long cardInfo){
        cardStatusService.deleteAllCardStatusByCardId(cardInfo);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //tested
    @GetMapping("/cardInfos/{cardId}/cardStatus")
    public ResponseEntity<List<CardStatus>> getAllCardStatusesByCardId(@PathVariable("cardId") Long cardId){
        List<CardStatus> cardStatuses = cardStatusService.getAllCardStatusesByCardId(cardId);

        return new ResponseEntity<>(cardStatuses,HttpStatus.OK);
    }

    //tested
    @GetMapping("/cardStatus/{cardStatusId}")
    public ResponseEntity<CardStatus> getCardStatusByCardStatusId(@PathVariable("cardStatusId") Long cardStatusId){
        CardStatus cardStatus = cardStatusService.getCardStatusByCardStatusId( cardStatusId);

        return new ResponseEntity<>(cardStatus,HttpStatus.OK);
    }



}
