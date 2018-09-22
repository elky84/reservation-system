package com.elky.reservation.controller;

import com.elky.reservation.model.result.ObjectResult;
import com.elky.reservation.model.reservation.ReservationValue;
import com.elky.reservation.type.OsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.elky.reservation.ResultCode;
import com.elky.reservation.model.result.PageResult;
import com.elky.reservation.model.result.Result;
import com.elky.reservation.service.reservation.ReservationService;

@RestController
@RequestMapping(value = "/reservation")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @ResponseBody @RequestMapping(value = "", method = RequestMethod.GET)
    public PageResult<ReservationValue> get(Pageable pageable) {
        return new PageResult<>(reservationService.select(pageable), pageable);
    }


    @ResponseBody @RequestMapping(value = "get-by-phoneNo", method = RequestMethod.GET)
    public ObjectResult<ReservationValue> getByOsTypeAndPhoneNo(@RequestParam OsType osType, @RequestParam String phoneNo) {
        return new ObjectResult<>(reservationService.getByOsTypeAndPhoneNo(osType, phoneNo));
    }


    @ResponseBody @RequestMapping(value = "{reservationId}", method = RequestMethod.GET)
    public ObjectResult<ReservationValue> get(
            @PathVariable(value = "reservationId") Long reservationId) {
        return new ObjectResult<>(ResultCode.RT_SUCCESS, reservationService.select(reservationId));
    }

    @ResponseBody @RequestMapping(value = "", method = RequestMethod.POST)
    public ObjectResult<ReservationValue> post(
            @RequestBody ReservationValue ReservationValue) {
        return new ObjectResult<>(reservationService.insert(ReservationValue),
                ReservationValue);
    }

    @ResponseBody @RequestMapping(value = "{reservationId}", method = RequestMethod.PUT)
    public ObjectResult<ReservationValue> put(
            @PathVariable(value = "reservationId") Long reservationId,
            @RequestBody ReservationValue ReservationValue) {
        return new ObjectResult<>(
                reservationService.update(reservationId, ReservationValue),
                ReservationValue);
    }

    @ResponseBody @RequestMapping(value = "", method = RequestMethod.DELETE)
    public Result delete(@PathVariable(value = "reservationId") Long reservationId) {
        return new Result(reservationService.delete(reservationId));
    }

}
