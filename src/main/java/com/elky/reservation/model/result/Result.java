package com.elky.reservation.model.result;

import com.elky.reservation.ResultCode;
import lombok.Data;

@Data
public class Result {

    private long resultCode = ResultCode.RT_SUCCESS.getResultCode();

    public Result() {

    }

    public Result(ResultCode resultCode) {
        this.resultCode = resultCode.getResultCode();
    }

    public Result(long resultCode) {
        this.resultCode = resultCode;
    }
}
