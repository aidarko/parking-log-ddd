package com.aidarko.infastructure;

import com.aidarko.app.event.TicketPaidEvent;

import java.util.ArrayList;
import java.util.List;

public class InMemoryVehicleAuditStorage {

    private final List<TicketPaidEvent> vehicles = new ArrayList<>();

    public void add(TicketPaidEvent vehicle) {
        vehicles.add(vehicle);
    }
}
