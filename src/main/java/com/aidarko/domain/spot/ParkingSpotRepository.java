package com.aidarko.domain.spot;

import java.util.Set;

public interface ParkingSpotRepository {
    Set<ParkingSpot> getParkingSpots();

    void save(ParkingSpot spot);

    ParkingSpot findSpot(ParkingSpot.Id id);
}
