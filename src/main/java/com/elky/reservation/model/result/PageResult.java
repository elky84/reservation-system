package com.elky.reservation.model.result;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.elky.reservation.ResultCode;

@SuppressWarnings("serial")
@Data
public class PageResult<T> extends PageImpl<T> {

    private long resultCode = ResultCode.RT_SUCCESS.getResultCode();

    public PageResult(long resultCode, Page<T> page, Pageable pageable) {

        super(page.getContent(), pageable, page.getTotalElements());
        setResultCode(resultCode);
    }


    public PageResult(ResultCode resultCode, Page<T> page, Pageable pageable) {

        super(page.getContent(), pageable, page.getTotalElements());
        setResultCode(resultCode.getResultCode());
    }

    public PageResult(Page<T> page, Pageable pageable) {
        super(page.getContent(), pageable, page.getTotalElements());
        setResultCode(ResultCode.RT_SUCCESS.getResultCode());
    }

}
