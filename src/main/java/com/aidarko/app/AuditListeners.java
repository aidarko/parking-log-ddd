package com.aidarko.app;

import com.aidarko.app.event.TicketPaidEvent;
import com.aidarko.infastructure.InMemoryVehicleAuditStorage;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuditListeners {
    final InMemoryVehicleAuditStorage vehicleAuditStorage;

    public void onEvent(TicketPaidEvent event) {
        vehicleAuditStorage.add(event);
    }
}
