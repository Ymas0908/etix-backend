//package org.etix.adapters.driver.facades;
//
//import lombok.AllArgsConstructor;
//import org.etix.adapters.entities.TicketEntity;
//import org.etix.domain.ports.driver.TicketPort;
//import org.springframework.stereotype.Component;
//@AllArgsConstructor
//@Component
//public class GenererTicketFacade {
//
//    private final TicketPort ticketPort;
//
//
//
//    public TicketEntity genererTicket(TicketEntity ticket) {
//        return TicketEntity.toEntity(ticketPort.genererTicket(ticket.toDomain()));
//    }
//
//    public TicketEntity acheterTicket(TicketEntity ticket) {
//        return TicketEntity.toEntity(ticketPort.acheterTicket(ticket.toDomain()));
//    }
//}
