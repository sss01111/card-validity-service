package org.capgemini.vs.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="card_info")
public class CardInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="card_id")
    private Long cardId;
    @Column(name="card_no")
    private String cardNumber;
    @Column(name="issue_date")
    private LocalDate issueDate;

    public CardInfo(String cardNumber,LocalDate issueDate) {
        this.cardNumber = cardNumber;
        this.issueDate = issueDate;
    }
}
