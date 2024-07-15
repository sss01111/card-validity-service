package org.capgemini.vs.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class ErrorMessage {

    private int statusCode;
    private String message;
    private String description;
    private LocalDate timestamp;
}
