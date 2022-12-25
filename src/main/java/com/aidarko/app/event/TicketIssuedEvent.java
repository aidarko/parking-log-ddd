package com.aidarko.app.event;

import lombok.Value;

@Value
public class TicketIssuedEvent {
    String ticketId;
    String gateId;
}
