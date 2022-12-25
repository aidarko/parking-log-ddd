package com.aidarko.app;

import com.aidarko.app.event.TicketIssuedEvent;
import com.aidarko.app.event.TicketPaidEvent;
import com.aidarko.app.event.ParkedToSpotEvent;
import com.aidarko.app.event.UnParkedFromSpotEvent;
import com.aidarko.domain.ParkingLot;
import com.aidarko.domain.ticket.Ticket;
import com.aidarko.domain.ticket.TicketsRepository;
import com.aidarko.infastructure.InMemoryVehicleAuditStorage;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LotListeners {
    final ParkingLot parkingLot;
    final InMemoryVehicleAuditStorage vehicleAuditStorage;
    final TicketsRepository ticketsRepository;

    public void onEvent(TicketIssuedEvent event) {
        ticketsRepository.save(new Ticket(event.getTicketId()));
    }

    public void onEvent(ParkedToSpotEvent event) {
        parkingLot.occupy(event.getParkingSpotId());
    }

    public void onEvent(UnParkedFromSpotEvent event) {
        parkingLot.unOccupy(event.getParkingSpotId());
    }

    public void onEvent(TicketPaidEvent event) {
        vehicleAuditStorage.add(event);
    }
}
