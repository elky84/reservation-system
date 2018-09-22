package com.elky.reservation.model.result;

import com.elky.reservation.ResultCode;
import lombok.Data;

@Data
public class ExceptionResult extends Result {

    private String message;
    private String moreInfo;

    public ExceptionResult(long code, String message) {
        super(code);
        this.message = message;
    }

    public ExceptionResult(ResultCode resultCode, String message) {
        super(resultCode.getResultCode());
        this.message = message;
    }

    public ExceptionResult(long code, String message, String moreInfo) {
        super(code);
        this.message = message;
        this.moreInfo = moreInfo;
    }
}
