package com.aidarko.domain

import com.aidarko.domain.gate.Gate
import com.aidarko.domain.gate.GateRepository
import com.aidarko.domain.spot.ParkingSpot
import com.aidarko.domain.spot.ParkingSpotRepository
import com.aidarko.domain.ticket.TicketsRepository
import com.aidarko.infastructure.GateAdapter
import com.aidarko.infastructure.InMemoryCapacityAdapter
import com.aidarko.infastructure.InMemoryParkingSpotAdapter
import com.aidarko.infastructure.InMemoryTicketsRepositoryAdapter
import spock.lang.Specification

class ParkingLotTest extends Specification {
    int capacity = 2
    ParkingSpotRepository parkingSpotRepository = new InMemoryParkingSpotAdapter()
    TicketsRepository ticketsRepository = new InMemoryTicketsRepositoryAdapter()
    CapacityRepository capacityRepository = new InMemoryCapacityAdapter(capacity)
    GateRepository gateRepository = new GateAdapter()

    def parkingLot = new ParkingLot(parkingSpotRepository, ticketsRepository, capacityRepository, gateRepository)
    def spotId = UUID.randomUUID().toString()
    def spot = new ParkingSpot(new ParkingSpot.Id(spotId), "anyType", "anyName")

    def 'vehicle can enter lot'() {
        given:
        def gateId = new Gate.Id("gateId")

        when:
        parkingLot.enter(gateId)

        then:
        capacityRepository.capacity == 1
        parkingLot.isFree()
    }

    def 'vehicle can exit a lot'() {
        given:
        def gateId1 = new Gate.Id("gateId1")
        def gateId2 = new Gate.Id("gateId2")
        parkingLot.enter(gateId1)

        when:
        parkingLot.exit(gateId2)

        then:
        capacityRepository.capacity == 2
        parkingLot.isFree()
    }

    def 'vehicle can park in a spot'() {
        given:
        parkingSpotRepository.save(spot)

        when:
        parkingLot.occupy(spot.getId())

        def actualSpot = parkingSpotRepository.getParkingSpots()[0]
        then:
        spot == actualSpot
        actualSpot.isOccupied()
        !spot.isOccupied()
    }

    def 'vehicle can un-park from a spot'() {
        given:
        parkingSpotRepository.save(spot)
        parkingLot.occupy(spot.getId())

        when:
        parkingLot.unOccupy(spot.getId())

        then:
        !parkingSpotRepository.getParkingSpots()[0].occupied
    }


    def 'cannot park in a non-existent spot'() {
        when:
        parkingLot.occupy(new ParkingSpot.Id("non-existent"))

        then:
        thrown IllegalArgumentException
    }

    def 'occupied spot cannot be occupied again'() {
        given:
        parkingSpotRepository.save(spot)
        parkingLot.occupy(spot.getId())

        when:
        parkingLot.occupy(spot.getId())

        then:
        thrown IllegalStateException
    }

    def 'same parking spot cannot be released twice'() {
        given:
        parkingSpotRepository.save(spot)
        parkingLot.occupy(spot.getId())

        when:
        parkingLot.unOccupy(spot.getId())
        parkingLot.unOccupy(spot.getId())

        then:
        thrown IllegalStateException
    }
}
