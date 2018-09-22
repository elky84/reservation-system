package com.elky.reservation.model.reservation;

import javax.persistence.*;

import com.elky.reservation.type.OsType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity @Table(name = "reservation") @Data @Getter @Setter public class ReservationValue {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id", nullable = false) protected long reservationId;

    @Column(name = "os_type") @Enumerated(EnumType.STRING) protected OsType osType = OsType.NONE;

    @Column(name = "name") protected String name;

    @Column(name = "phone_no", unique = true) protected String phoneNo;

    @ManyToOne @JoinColumn(name = "reservation_info_id") @Setter @Getter
    protected ReservationInfoValue reservationInfoValue;
}
