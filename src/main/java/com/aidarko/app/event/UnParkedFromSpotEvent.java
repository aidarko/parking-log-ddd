package com.aidarko.app.event;

import com.aidarko.domain.spot.ParkingSpot;
import lombok.Value;

@Value
public class UnParkedFromSpotEvent {
    ParkingSpot.Id parkingSpotId;
}
