package com.aidarko.domain;

import com.aidarko.domain.gate.Gate;
import com.aidarko.domain.gate.GateRepository;
import com.aidarko.domain.spot.ParkingSpot;
import com.aidarko.domain.spot.ParkingSpotRepository;
import com.aidarko.domain.ticket.TicketsRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ParkingLot {
    ParkingSpotRepository parkingSpotRepository;
    TicketsRepository ticketsRepository;
    CapacityRepository capacityRepository;
    GateRepository gateRepository;

    public boolean isFree() {
        return capacityRepository.getCapacity() > 0;
    }

    public void occupy(ParkingSpot.Id spotId) {
        ParkingSpot parkingSpot = parkingSpotRepository.findSpot(spotId);
        parkingSpot.occupy();
        parkingSpotRepository.save(parkingSpot);
    }

    public void unOccupy(ParkingSpot.Id spotId) {
        ParkingSpot parkingSpot = parkingSpotRepository.findSpot(spotId);
        parkingSpot.unOccupy();
        parkingSpotRepository.save(parkingSpot);
    }

    public void enter(Gate.Id gateId) {
        gateRepository.open(gateId);
        capacityRepository.decrease();
    }

    public void exit(Gate.Id gateId) {
        gateRepository.open(gateId);
        capacityRepository.increase();
    }
}
