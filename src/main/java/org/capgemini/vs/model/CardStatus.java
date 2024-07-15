package org.capgemini.vs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="card_status")
public class CardStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="card_status_id")
    private Long cardStatusId;
    @Column(name="card_no")
    private String cardNumber;
    @Column(name="status_start_date")
    private LocalDate statusStartDate;
    @Column(name="status_end_date")
    private LocalDate statusEndDate;
    @Column(name="status_validity")
    private String statusValidity;
    // map multiple CardStatus object with one CardInfo object
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "card_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private CardInfo cardInfo;

}
