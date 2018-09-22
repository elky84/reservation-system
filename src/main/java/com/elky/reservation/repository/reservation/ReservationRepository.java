package com.elky.reservation.repository.reservation;

import com.elky.reservation.model.reservation.ReservationValue;

import com.elky.reservation.type.OsType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ReservationRepository
        extends JpaRepository<ReservationValue, Long>, JpaSpecificationExecutor<ReservationValue> {

    ReservationValue findByOsTypeAndPhoneNo(OsType osType, String phoneNo);

    ReservationValue findByPhoneNo(String phoneNo);
}
