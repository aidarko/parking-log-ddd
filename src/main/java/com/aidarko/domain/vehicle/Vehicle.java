package com.aidarko.domain.vehicle;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;

@AllArgsConstructor
@Value
public class Vehicle {
    @NonNull
    LicensePlate licensePlate;

    @AllArgsConstructor
    @Value
    public static class LicensePlate {
        String value;
    }
}

