package com.elky.reservation.repository.reservation;

import com.elky.reservation.model.reservation.ReservationInfoValue;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ReservationInfoRepository extends JpaRepository<ReservationInfoValue, Long>,
        JpaSpecificationExecutor<ReservationInfoValue> {

}
