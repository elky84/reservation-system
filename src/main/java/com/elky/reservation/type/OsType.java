package com.elky.reservation.type;

import lombok.Getter;

@Getter
public enum OsType {
    NONE("none"),
    IOS("ios"),
    ANDROID("android");

    private String value;

    OsType(String value) {
        this.value = value;
    }
}
