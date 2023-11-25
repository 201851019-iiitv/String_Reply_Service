package com.beta.replyservice.Controller;

import com.beta.replyservice.dto.ReplyMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalController {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ReplyMessage> badRequestExceptionHandler(IllegalArgumentException exception){
        return ResponseEntity.badRequest().body(new ReplyMessage("Invalid input"));
    }

    @ExceptionHandler({RuntimeException.class, Exception.class})
    public ResponseEntity<ReplyMessage> InternalServerExceptionHandler(Exception exception){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ReplyMessage("unable to process the request at that moment"));
    }
}
