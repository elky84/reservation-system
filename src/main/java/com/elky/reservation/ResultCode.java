package com.elky.reservation;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ResultCode {
    // Common Return Code;
    RT_EXECUTED(1, "Executed", HttpStatus.ACCEPTED),
    RT_SUCCESS(0, "Success", HttpStatus.OK),
    RT_INTERNAL_ERROR(-1, "Internal error", HttpStatus.INTERNAL_SERVER_ERROR),
    RT_WRONG_PARAMETER(-2, "Wrong parameter", HttpStatus.BAD_REQUEST),
    RT_WRONG_STATUS(-3, "Wrong status", HttpStatus.BAD_REQUEST),
    RT_PROPAGATION_ERROR(-5, "Propagation error", HttpStatus.BAD_REQUEST),
    RT_VALIDATION_FAILURE(-6, "Validation error", HttpStatus.BAD_REQUEST),
    RT_AUTHENTICATION_FAILURE(-7, "Authentication failure", HttpStatus.FORBIDDEN),
    RT_NOT_EXIST(-8, "Not exist", HttpStatus.GONE),
    RT_DUPLICATED(-9, "Duplicated", HttpStatus.BAD_REQUEST),
    RT_NOT_SUPPORT(-10, "Not support", HttpStatus.NOT_FOUND),
    RT_UNAUTHORITZED(-11, "Unauthorized", HttpStatus.UNAUTHORIZED),
    RT_REQUIRE_PERMISSION(-12, "Require Permission", HttpStatus.FORBIDDEN),
    RT_FAILURE(-99, "Failure ", HttpStatus.INTERNAL_SERVER_ERROR),

    // Custom Return Code [-1000XX]
    RT_INVALID_OS_TYPE(-100001, "Invalid OS Type", HttpStatus.BAD_REQUEST),
    RT_INVALID_PHONE_NO_LENGTH(-100002, "Invalid PhoneNo Length", HttpStatus.BAD_REQUEST),
    RT_PHONE_NO_IS_ALREADY_REGISTER(-100003, "PhoneNo is Already Register", HttpStatus.BAD_REQUEST),
    RT_NOT_INPUT_RESERVATION_INFO(-100003, "Not Input Reservation Info", HttpStatus.BAD_REQUEST),

    // UNKNOWN Error Return Code
    RT_UNKNOWN(-999999, "Unknown error.", HttpStatus.INTERNAL_SERVER_ERROR);

    private final long resultCode;

    private final String resultMessage;

    private final HttpStatus httpStatus;

    ResultCode(long resultCode, String resultMessage, HttpStatus httpStatus) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
        this.httpStatus = httpStatus;
    }
}
