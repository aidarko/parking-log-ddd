package com.aidarko.infastructure;

import com.aidarko.domain.spot.ParkingSpotRepository;
import com.aidarko.domain.spot.ParkingSpot;

import java.util.HashSet;
import java.util.Set;

public class InMemoryParkingSpotAdapter implements ParkingSpotRepository {

    Set<ParkingSpot> parkingSpots = new HashSet<>();

    @Override
    public Set<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    @Override
    public void save(ParkingSpot spot) {
        ParkingSpot newSpot = new ParkingSpot(spot.getId(), spot.getType(), spot.getName());
        parkingSpots.add(newSpot);
    }

    @Override
    public ParkingSpot findSpot(ParkingSpot.Id id) {
        return parkingSpots.stream()
                .filter(spot -> spot.getId().equals(id))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
