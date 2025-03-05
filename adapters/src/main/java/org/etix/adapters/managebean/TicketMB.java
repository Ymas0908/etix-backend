package org.etix.adapters.managebean;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.etix.adapters.driver.facades.GenererUnTicketFacade;
import org.etix.adapters.entities.EvenementEntity;
import org.etix.adapters.entities.TicketEntity;
import org.etix.adapters.notification.FlashMessage;
import org.etix.domain.models.enumerations.TypeTicket;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
@Getter
@Setter
public class TicketMB implements Serializable  {

    private TicketEntity ticket = new TicketEntity();
    private TypeTicket typeTicket;
    private List<TypeTicket> typeTicketList = TypeTicket.getTypes();
    private List<TicketEntity> ticketList = new ArrayList<>();
    private List<EvenementEntity> evenementList = new ArrayList<>();
    private EvenementEntity evenement;

    @Autowired
    private GenererUnTicketFacade genererUnTicketFacade;



    @PostConstruct
    public void init() {
        ticketList = new ArrayList<>();
        ticket = new TicketEntity();
        typeTicketList = TypeTicket.getTypes();
    }




    public void genererTicket() {
        try {
            if (ticket.getEvenement() == null) {
                System.out.println("Événement non défini pour le ticket.");
            }
            ticket = genererUnTicketFacade.creerUnTicket(ticket);
        } catch (Exception e) {
            e.printStackTrace();
            FlashMessage.flash(FlashMessage.ERROR, "Erreur", "Une erreur s'est produite.");
        }
    }







}
