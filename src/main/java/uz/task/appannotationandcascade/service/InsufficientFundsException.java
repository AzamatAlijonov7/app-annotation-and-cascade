package uz.task.appannotationandcascade.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String insufficientFunds) {
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        class insufficientFundsException extends RuntimeException {
            public insufficientFundsException(String message) {
                super(message);
            }
        }
    }
}
