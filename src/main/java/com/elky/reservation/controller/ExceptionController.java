package com.elky.reservation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.elky.reservation.model.exception.ApplicationException;
import com.elky.reservation.ResultCode;
import com.elky.reservation.model.result.ExceptionResult;
import com.elky.reservation.model.result.Result;

/**
 */
@ControllerAdvice
@RestController
public class ExceptionController {

    @ExceptionHandler(value = ApplicationException.class)
    public ResponseEntity<ExceptionResult> handleApplicationException(ApplicationException e) {
        return new ResponseEntity<>(
                new ExceptionResult(e.getResultCode(), e.getResultMessage()), e.getResultHttpStatus());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = Exception.class)
    public Result handleException(Exception e) {
        return new ExceptionResult(ResultCode.RT_FAILURE.getResultCode(), e.getMessage());
    }
}
