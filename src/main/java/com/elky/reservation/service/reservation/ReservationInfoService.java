package com.elky.reservation.service.reservation;

import com.elky.reservation.ResultCode;
import com.elky.reservation.model.reservation.ReservationInfoValue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReservationInfoService {

    Page<ReservationInfoValue> select(Pageable pageable);

    ReservationInfoValue select(Long reservationInfoId);

    ResultCode insert(ReservationInfoValue reservationInfoValue);

    ResultCode update(Long reservationInfoId, ReservationInfoValue reservationInfoValue);

    ResultCode delete(Long reservationInfoId);
}
