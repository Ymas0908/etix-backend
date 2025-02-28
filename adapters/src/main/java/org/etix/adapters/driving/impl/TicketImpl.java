package org.etix.adapters.driving.impl;

import lombok.AllArgsConstructor;
import org.etix.adapters.driving.repositories.TicketRepository;
import org.etix.adapters.entities.TicketEntity;
import org.etix.domain.models.Ticket;
import org.etix.domain.ports.driving.TicketRepo;
import org.springframework.stereotype.Component;

import java.util.List;
@AllArgsConstructor
@Component
public class TicketImpl implements TicketRepo {

    private final TicketRepository ticketRepository;
    @Override
    public Ticket saveTicket(Ticket ticket) {
        return ticketRepository.save(TicketEntity.toEntity(ticket)).toDomain();
    }

    @Override
    public List<Ticket> getTicketByEvenement(Integer idEvenement) {
        return ticketRepository.findByEvenementId(idEvenement).stream().map(TicketEntity::toDomain).toList();
    }
}
