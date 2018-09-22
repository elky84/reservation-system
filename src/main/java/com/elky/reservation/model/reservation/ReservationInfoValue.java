package com.elky.reservation.model.reservation;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity @Table(name = "reservation_info") @Data @Getter @Setter
public class ReservationInfoValue {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_info_id", nullable = false) protected long reservationInfoId;

    @Column(name = "name") protected String name;

    @Column(name = "expect_release_date") protected Date expectReleaseDate;

    @Column(name = "description") protected String description;

    @Column(name = "video_uri")
    protected String videoUri;

    @Column(name = "image_uri")
    @ElementCollection(targetClass = String.class)
    protected List<String> imageUris = new ArrayList<>();
}
