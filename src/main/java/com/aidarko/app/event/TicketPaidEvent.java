package com.aidarko.app.event;

import com.aidarko.domain.vehicle.Vehicle;
import lombok.Value;

import java.time.ZonedDateTime;

@Value
public class TicketPaidEvent {
    String ticketId;
    Vehicle.LicensePlate licensePlate;
    ZonedDateTime start;
    ZonedDateTime end;
}
