package com.aidarko.domain.ticket;

import lombok.EqualsAndHashCode;
import lombok.Value;

import java.time.ZonedDateTime;

@Value
@EqualsAndHashCode(exclude = {"ticketStatus"})
public class Ticket {
    String id;
    ZonedDateTime issuedDateTime;
    TicketStatus ticketStatus;

    public Ticket(Ticket ticket, TicketStatus ticketStatus) {
        this.id = ticket.getId();
        this.issuedDateTime = ticket.getIssuedDateTime();
        this.ticketStatus = ticketStatus;
    }

    public Ticket(String ticketId) {
        this.id = ticketId;
        issuedDateTime = ZonedDateTime.now();
        ticketStatus = TicketStatus.UNPAID;
    }
}
