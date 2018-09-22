package com.elky.reservation.model.result;

import com.elky.reservation.ResultCode;
import lombok.Data;

@Data
public class ObjectResult<T> extends Result {

    private T content;

    public ObjectResult(T t) {
        super();
        this.content = t;
    }

    public ObjectResult(ResultCode resultCode, T t) {
        super(resultCode.getResultCode());
        this.content = t;
    }

    public ObjectResult(long resultCode, T t) {
        super(resultCode);
        this.content = t;
    }
}
