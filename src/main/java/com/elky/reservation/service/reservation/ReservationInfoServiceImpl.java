package com.elky.reservation.service.reservation;

import com.elky.reservation.ResultCode;
import com.elky.reservation.model.reservation.ReservationInfoValue;
import com.elky.reservation.repository.reservation.ReservationInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service public class ReservationInfoServiceImpl implements ReservationInfoService {
    @Autowired ReservationInfoRepository reservationInfoRepository;

    @Override public Page<ReservationInfoValue> select(Pageable pageable) {
        return reservationInfoRepository.findAll(pageable);

    }

    @Override public ReservationInfoValue select(Long reservationInfoId) {
        return reservationInfoRepository.findOne(reservationInfoId);

    }

    @Override public ResultCode insert(ReservationInfoValue reservationInfoValue) {
        return reservationInfoRepository.save(reservationInfoValue) != null ?
                ResultCode.RT_SUCCESS :
                ResultCode.RT_FAILURE;

    }

    @Override
    public ResultCode update(Long reservationInfoId, ReservationInfoValue reservationInfoValue) {
        if (reservationInfoRepository.findOne(reservationInfoId) != null) {
            return ResultCode.RT_NOT_EXIST;
        }

        return reservationInfoRepository.save(reservationInfoValue) != null ?
                ResultCode.RT_SUCCESS :
                ResultCode.RT_FAILURE;
    }

    @Override public ResultCode delete(Long reservationInfoId) {
        if (reservationInfoRepository.findOne(reservationInfoId) != null) {
            return ResultCode.RT_NOT_EXIST;
        }

        reservationInfoRepository.delete(reservationInfoId);
        return ResultCode.RT_SUCCESS;
    }
}
