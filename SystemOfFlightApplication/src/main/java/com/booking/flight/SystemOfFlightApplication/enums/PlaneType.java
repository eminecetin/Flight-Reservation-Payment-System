package com.booking.flight.SystemOfFlightApplication.enums;

import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum PlaneType {

    AIRBUS_A320("Airbus A320"),
    BOEING_737("Boeing 737"),
    AIRBUS_A380("Airbus A380"),
    BOEING_747("Boeing 747");
    // şimdilik iki yeter....

    private final String displayName;

    PlaneType(String displayName) {
        this.displayName = displayName;
    }

    public static PlaneType value(String description){
        return Stream.of(PlaneType.values())
                .filter(i -> i.getDisplayName().equals(description))
                .findFirst()
                .orElse(null);
    }
}
