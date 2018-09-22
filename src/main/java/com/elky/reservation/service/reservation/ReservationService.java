package com.elky.reservation.service.reservation;

import com.elky.reservation.ResultCode;
import com.elky.reservation.model.reservation.ReservationValue;

import com.elky.reservation.type.OsType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReservationService {
    ReservationValue getByOsTypeAndPhoneNo(OsType osType, String phoneNo);

    Page<ReservationValue> select(Pageable pageable);

    ReservationValue select(Long reservationId);

    ResultCode insert(ReservationValue reservationInfoValue);

    ResultCode update(Long reservationid, ReservationValue reservationInfoValue);

    ResultCode delete(Long reservationid);
}
