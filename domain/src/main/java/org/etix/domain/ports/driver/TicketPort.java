package org.etix.domain.ports.driver;

import org.etix.domain.models.Ticket;

import java.util.List;

public interface TicketPort {


   Ticket saveTicket(Ticket ticket);

    List<Ticket> getTicketByEvenement(Integer idEvenement);




}
