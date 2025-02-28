package org.etix.domain.services;

import org.etix.domain.ddd.DomaineService;
import org.etix.domain.models.Ticket;
import org.etix.domain.ports.driver.TicketPort;
import org.etix.domain.ports.driving.TicketRepo;

import java.time.LocalDateTime;
import java.util.List;

@DomaineService
public class TicketService implements TicketPort {

    private final TicketRepo ticketRepo;

    public TicketService(TicketRepo ticketRepo) {
        this.ticketRepo = ticketRepo;
    }


    @Override
    public Ticket saveTicket(Ticket ticket) {
        return null;
    }

    @Override
    public List<Ticket> getTicketByEvenement(Integer idEvenement) {
        return null;
    }
}
