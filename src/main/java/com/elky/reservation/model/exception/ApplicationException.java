package com.elky.reservation.model.exception;

import com.elky.reservation.ResultCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApplicationException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private long resultCode;
    private String resultMessage;
    private HttpStatus resultHttpStatus;

    public ApplicationException(ResultCode resultCode) {
        super(resultCode.toString());
        this.resultCode = resultCode.getResultCode();
        this.resultMessage = resultCode.getResultMessage();
        this.resultHttpStatus = resultCode.getHttpStatus();
    }

    public ApplicationException(ResultCode resultCode, String additionalMessage) {
        super(resultCode.toString() + additionalMessage);
        this.resultCode = resultCode.getResultCode();
        this.resultMessage = resultCode.getResultMessage() + additionalMessage;
        this.resultHttpStatus = resultCode.getHttpStatus();
    }

    public ApplicationException(ResultCode resultCode, Throwable th) {
        super(resultCode.toString(), th);
        this.resultCode = resultCode.getResultCode();
        this.resultMessage = resultCode.getResultMessage();
        this.resultHttpStatus = resultCode.getHttpStatus();
    }

    public ApplicationException(ResultCode resultCode, String additionalMessage, Throwable th) {
        super(resultCode.toString() + additionalMessage, th);
        this.resultCode = resultCode.getResultCode();
        this.resultMessage = resultCode.getResultMessage();
        this.resultHttpStatus = resultCode.getHttpStatus();
    }
}
