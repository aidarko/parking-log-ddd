package com.aidarko.infastructure;

import com.aidarko.domain.ticket.Ticket;
import com.aidarko.domain.ticket.TicketStatus;
import com.aidarko.domain.ticket.TicketsRepository;

import java.util.HashSet;
import java.util.Set;

public class InMemoryTicketsRepositoryAdapter implements TicketsRepository {
    Set<Ticket> activeTickets = new HashSet<>();

    @Override
    public void save(Ticket ticket) {
        activeTickets.add(ticket);
    }

    @Override
    public TicketStatus getTicketStatus(Ticket ticket) {
        return null;
    }

    @Override
    public void setTicketStatus(Ticket ticket, TicketStatus ticketStatus) {
        if (!activeTickets.contains(ticket)) {
            throw new IllegalStateException("Ticket must be registered first");
        }
        if (ticketStatus.equals(TicketStatus.PAID)) {
            activeTickets.remove(ticket);
        } else {
            Ticket newTicket = new Ticket(ticket, ticketStatus);
            activeTickets.add(newTicket);
        }
    }
}
