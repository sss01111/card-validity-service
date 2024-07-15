package org.capgemini.vs.controller;


import org.capgemini.vs.exception.ResourceNotFoundException;
import org.capgemini.vs.model.CardInfo;
import org.capgemini.vs.service.CardInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CardInfoController {

    @Autowired
    CardInfoService cardInfoService;

    //tested
    @GetMapping("/cardInfos")
    public ResponseEntity<List<CardInfo>> getAllCardInfosByCardNumber(@RequestParam(name = "cardNumber",required = false) String cardNumber){
        List<CardInfo> cardInfoList = new ArrayList<>();
        List<CardInfo> cardInfos = cardInfoService.getAllCardInfosByCardNumber(cardNumber);

        return new ResponseEntity<>(cardInfos,HttpStatus.OK);
    }
    //tested
    @GetMapping("/cardInfos/{cardId}")
    public ResponseEntity<CardInfo> getCardInfosByCardId(@PathVariable("cardId") Long cardId){
        CardInfo cardInfo = cardInfoService.getCardInfoByCardId(cardId);
        return new ResponseEntity<>(cardInfo,HttpStatus.OK);
    }
    //tested
    @PostMapping("/cardInfos")
    public ResponseEntity<CardInfo> createCardInfo(@RequestBody CardInfo cardInf){
        CardInfo cardInfo = cardInfoService.createCardInfo(cardInf);
        return new ResponseEntity<>(cardInfo, HttpStatus.CREATED);
    }
    //tested
    @PutMapping("/cardInfos")
    public ResponseEntity<CardInfo> updateCardInfo(@RequestBody CardInfo cardInf){
        CardInfo cardInfo = cardInfoService.updateCardInfo(cardInf);
        return new ResponseEntity<>(cardInfo, HttpStatus.CREATED);
    }
    //tested
    @DeleteMapping("/cardInfos/{cardId}")
    public ResponseEntity<HttpStatus> deleteCardInfoByCardId(@PathVariable("cardId") Long cardId){
        cardInfoService.deleteCardInfoByCardId(cardId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //tested
    @DeleteMapping("/cardInfos")
    public ResponseEntity<HttpStatus> deleteAllCardInfos(){
        cardInfoService.deleteAllCardInfos();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
