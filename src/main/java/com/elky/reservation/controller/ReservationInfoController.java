package com.elky.reservation.controller;

import com.elky.reservation.ResultCode;
import com.elky.reservation.model.result.ObjectResult;
import com.elky.reservation.model.result.PageResult;
import com.elky.reservation.model.result.Result;
import com.elky.reservation.model.reservation.ReservationInfoValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.elky.reservation.service.reservation.ReservationInfoService;

@RestController @RequestMapping(value = "/reservation-info")
public class ReservationInfoController {

    @Autowired private ReservationInfoService reservationInfoService;

    @ResponseBody @RequestMapping(value = "", method = RequestMethod.GET)
    public PageResult<ReservationInfoValue> get(Pageable pageable) {
        return new PageResult<>(reservationInfoService.select(pageable), pageable);
    }

    @ResponseBody @RequestMapping(value = "{reservationInfoId}", method = RequestMethod.GET)
    public ObjectResult<ReservationInfoValue> get(
            @PathVariable(value = "reservationInfoId") Long reservationInfoId) {
        return new ObjectResult<>(ResultCode.RT_SUCCESS, reservationInfoService.select(reservationInfoId));
    }

    @ResponseBody @RequestMapping(value = "", method = RequestMethod.POST)
    public ObjectResult<ReservationInfoValue> post(
            @RequestBody ReservationInfoValue reservationInfoValue) {
        return new ObjectResult<>(reservationInfoService.insert(reservationInfoValue),
                reservationInfoValue);
    }

    @ResponseBody @RequestMapping(value = "{reservationInfoId}", method = RequestMethod.PUT)
    public ObjectResult<ReservationInfoValue> put(
            @PathVariable(value = "reservationInfoId") Long reservationInfoId,
            @RequestBody ReservationInfoValue reservationInfoValue) {
        return new ObjectResult<>(
                reservationInfoService.update(reservationInfoId, reservationInfoValue),
                reservationInfoValue);
    }

    @ResponseBody @RequestMapping(value = "", method = RequestMethod.DELETE)
    public Result delete(@PathVariable(value = "reservationInfoId") Long reservationInfoId) {
        return new Result(reservationInfoService.delete(reservationInfoId));
    }
}
