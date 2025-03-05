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
        // Vérifier que le ticket a un type
        if (ticket.getTypeTicket() == null) {
            throw new IllegalArgumentException("Le ticket doit avoir un type");
        }

        // Vérifier que le ticket est lié à un événement
        if (ticket.getEvenement() == null) {
            throw new IllegalArgumentException("Le ticket doit être lié à un évènement");
        }

        // Assigner la date et l'heure de création du ticket
        ticket.setDateHeureCreation(LocalDateTime.now());

        // Enregistrer le ticket en base de données
        // Si vous utilisez un repository ou une interface JPA pour la persistance, vous pouvez le faire ainsi :
        return ticketRepo.saveTicket(ticket);  // ticketRepo.save(ticket) va persister le ticket
    }

    @Override
    public List<Ticket> getTicketByEvenement(Integer idEvenement) {
        return ticketRepo.getTicketByEvenement(idEvenement);
    }
}
