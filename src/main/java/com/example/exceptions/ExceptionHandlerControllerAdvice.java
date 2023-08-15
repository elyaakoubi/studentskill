package com.example.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionHandlerControllerAdvice {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Message>
    EntityNotFoundExceptionHandler(HttpServletRequest request,
                                 EntityNotFoundException exception) {
        Message message = Message.builder()
                .message(exception.getMessage())
                .build();
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SkillWithSameNameAlreadyExist.class)
    public ResponseEntity<Message>
    ExceptionHandler(HttpServletRequest request,
                     SkillWithSameNameAlreadyExist skillexception) {
        Message message = Message.builder()
                .message(skillexception.getMessage())
                .build();
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}
