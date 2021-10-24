package org.test.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<UserIncorrectDate> handleException(NoSuchUserException e){
        UserIncorrectDate user = new UserIncorrectDate();
        user.setInfo(e.getMessage());
        return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);

    }

    // для ловли всех ошибок
    @ExceptionHandler
    public ResponseEntity<UserIncorrectDate> handleException(Exception e){
        UserIncorrectDate user = new UserIncorrectDate();
        user.setInfo(e.getMessage());
        return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);

    }
}