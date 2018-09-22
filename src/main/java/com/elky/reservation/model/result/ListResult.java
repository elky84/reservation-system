package com.elky.reservation.model.result;

import com.elky.reservation.ResultCode;
import lombok.Data;

import java.util.List;

@Data
public class ListResult<T> extends Result {

    private List<T> content;

    public ListResult(List<T> t) {
        super();
        this.content = t;
    }

    public ListResult(ResultCode resultCode, List<T> t) {
        super(resultCode.getResultCode());
        this.content = t;
    }

    public ListResult(long resultCode, List<T> t) {
        super(resultCode);
        this.content = t;
    }

}
