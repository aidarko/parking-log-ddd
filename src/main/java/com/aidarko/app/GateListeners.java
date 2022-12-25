package com.aidarko.app;

import com.aidarko.app.event.TicketIssuedEvent;
import com.aidarko.app.event.ValidTicketScannedEvent;
import com.aidarko.domain.ParkingLot;
import com.aidarko.domain.gate.Gate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GateListeners {
    final ParkingLot parkingLot;

    public void onEvent(TicketIssuedEvent event) {
        parkingLot.enter(new Gate.Id(event.getGateId()));
    }

    public void onEvent(ValidTicketScannedEvent event) {
        parkingLot.exit(new Gate.Id(event.getGateId()));
    }
}
