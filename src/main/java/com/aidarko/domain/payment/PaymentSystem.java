package com.aidarko.domain.payment;

import com.aidarko.domain.ticket.Ticket;
import com.aidarko.domain.ticket.TicketStatus;
import com.aidarko.domain.ticket.TicketsRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class PaymentSystem {

    RatesRepository ratesRepository;
    PayRepository payRepository;
    TicketsRepository ticketsRepository;

    void pay(Ticket ticket) {
        BigDecimal amount = calculatePrice(ticket);
        payRepository.pay(amount);
        ticketsRepository.setTicketStatus(ticket, TicketStatus.PAID);
    }

    private BigDecimal calculatePrice(Ticket ticket) {
        ZonedDateTime now = ZonedDateTime.now();
        long hours = Util.zonedDateTimeDifference(ticket.getIssuedDateTime(), now, ChronoUnit.HOURS);
        BigDecimal rate = ratesRepository.getRatePerHour();
        return rate.multiply(new BigDecimal(hours))
            .setScale(2, RoundingMode.CEILING);
    }
}
