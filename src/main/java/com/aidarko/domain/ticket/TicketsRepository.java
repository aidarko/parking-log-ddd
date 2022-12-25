package com.aidarko.domain.ticket;

public interface TicketsRepository {
    void save(Ticket ticket);

    TicketStatus getTicketStatus(Ticket ticket);

    void setTicketStatus(Ticket ticket, TicketStatus ticketStatus);
}
