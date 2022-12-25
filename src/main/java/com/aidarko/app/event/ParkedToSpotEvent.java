package com.aidarko.app.event;

import com.aidarko.domain.spot.ParkingSpot;
import lombok.Value;

@Value
public class ParkedToSpotEvent {
    ParkingSpot.Id parkingSpotId;
}
