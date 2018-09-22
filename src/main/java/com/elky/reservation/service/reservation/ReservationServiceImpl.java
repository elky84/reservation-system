package com.elky.reservation.service.reservation;

import com.elky.reservation.ResultCode;
import com.elky.reservation.model.reservation.ReservationValue;
import com.elky.reservation.repository.reservation.ReservationRepository;

import com.elky.reservation.type.OsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service public class ReservationServiceImpl implements ReservationService {
    @Autowired ReservationRepository reservationRepository;

    @Override public ReservationValue getByOsTypeAndPhoneNo(OsType osType, String phoneNo) {
        return reservationRepository.findByOsTypeAndPhoneNo(osType, phoneNo);
    }

    @Override public Page<ReservationValue> select(Pageable pageable) {
        return reservationRepository.findAll(pageable);
    }

    @Override public ReservationValue select(Long reservationId) {
        return reservationRepository.findOne(reservationId);
    }

    @Override public ResultCode insert(ReservationValue reservationInfoValue) {
        if (reservationInfoValue.getOsType() == null ||
                reservationInfoValue.getOsType() == OsType.NONE) {
            return ResultCode.RT_INVALID_OS_TYPE;
        }

        final int minPhoneNoLength = 10;
        final int maxPhoneNoLength = 11;

        String replacedPhoneNo = reservationInfoValue.getPhoneNo().replaceAll("[^0-9]", "");
        if (replacedPhoneNo.length() < minPhoneNoLength && maxPhoneNoLength < replacedPhoneNo
                .length()) {
            return ResultCode.RT_INVALID_PHONE_NO_LENGTH;
        }

        if (reservationRepository.findByPhoneNo(replacedPhoneNo) != null) {
            return ResultCode.RT_PHONE_NO_IS_ALREADY_REGISTER;
        }

        if (reservationInfoValue.getReservationInfoValue() == null) {
            return ResultCode.RT_NOT_INPUT_RESERVATION_INFO;
        }

        return reservationRepository.save(reservationInfoValue) != null ?
                ResultCode.RT_SUCCESS :
                ResultCode.RT_FAILURE;
    }

    @Override public ResultCode update(Long reservationid, ReservationValue reservationInfoValue) {
        if (reservationRepository.findOne(reservationid) != null) {
            return ResultCode.RT_NOT_EXIST;
        }

        return reservationRepository.save(reservationInfoValue) != null ?
                ResultCode.RT_SUCCESS :
                ResultCode.RT_FAILURE;
    }


    @Override public ResultCode delete(Long reservationid) {
        if (reservationRepository.findOne(reservationid) != null) {
            return ResultCode.RT_NOT_EXIST;
        }

        reservationRepository.delete(reservationid);
        return ResultCode.RT_SUCCESS;
    }
}
