package org.etix.adapters.driver.facades;

import lombok.AllArgsConstructor;
import org.etix.adapters.entities.TicketEntity;
import org.etix.domain.ports.driver.TicketPort;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class GenererUnTicketFacade {

    private  TicketPort ticketPort;

    public TicketEntity creerUnTicket(TicketEntity ticket) {
        return TicketEntity.toEntity(ticketPort.saveTicket(ticket.toDomain()));
    }


    public List<TicketEntity> getTicketByEvenement(Integer idEvenement) {
        return ticketPort.getTicketByEvenement(idEvenement).stream().map(TicketEntity::toEntity).toList();
    }



}
