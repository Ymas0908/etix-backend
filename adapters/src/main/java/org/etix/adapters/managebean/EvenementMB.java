//package org.etix.adapters.managebean;
//
//import jakarta.annotation.PostConstruct;
//import jakarta.faces.view.ViewScoped;
//import jakarta.inject.Named;
//import lombok.Getter;
//import lombok.Setter;
//import org.etix.adapters.driver.facades.CreerUnEvenementFacade;
//import org.etix.adapters.entities.EvenementEntity;
//import org.etix.adapters.entities.TicketEntity;
//import org.etix.adapters.notification.FlashMessage;
//import org.etix.domain.models.Evenement;
//import org.etix.domain.models.enumerations.TypeEvenement;
//import org.etix.domain.models.enumerations.TypeTicket;
//import org.primefaces.PrimeFaces;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//
//@Named
//@ViewScoped
//@Getter
//@Setter
//public class EvenementMB implements Serializable {
//
//
//    @Autowired
//    private CreerUnEvenementFacade creerUnEvenementFacade;
//
//    private List<EvenementEntity> evenementsList = new ArrayList<>();
//    private EvenementEntity evenement;
//    private TypeEvenement typeEvenement;
//    private List<TypeEvenement> typeEvenementList = new ArrayList<>();
//    private TypeTicket typeTicket;
//    private List<TypeTicket> typeTicketList = new ArrayList<>();
//    private TicketEntity ticket;
//
//
//
//
//    @PostConstruct
//    public void init() {
//        evenement = new EvenementEntity();
//        ticket = new TicketEntity();
//        typeEvenementList = TypeEvenement.getTypes();
//        typeTicketList = TypeTicket.getTypes();
//        this.collecterLesEvenements();
//    }
//
//
//    public void creerUnEvenement() {
//        try {
//            creerUnEvenementFacade.creerUnEvenement(evenement);
//            System.out.println("Evenement créé" + evenement);
//            FlashMessage.flash(FlashMessage.INFO, "Succès", "L'evenement à bien été crée.");
//            this.collecterLesEvenements();
//            this.resetCreerUnEvenement();
//        } catch (Exception e) {
//            FlashMessage.flash(FlashMessage.ERROR, "Erreur", "Une erreur s'est produite.");
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void modifierUnEvenement() {
//        try {
//            creerUnEvenementFacade.modifierUnEvenement(evenement);
//            this.resetCreerUnEvenement();
//            System.out.println("Evenement modifié" + evenement);
//            PrimeFaces.current().ajax().update("formEvenement");
//            FlashMessage.flash(FlashMessage.INFO, "Succès", "L'evenement à bien été modifié.");
//            this.collecterLesEvenements();
//        } catch (Exception e) {
//            FlashMessage.flash(FlashMessage.ERROR, "Erreur", "Une erreur s'est produite.");
//            throw new RuntimeException(e);
//        }
//    }
//
//
//    public void supprimerUnEvenement() {
//        try {
//            creerUnEvenementFacade.supprimerUnEvenement(evenement);
//            System.out.println("Evenement supprimé" + evenement);
//            FlashMessage.flash(FlashMessage.INFO, "Succès", "L'evenement à bien été supprimé.");
//            PrimeFaces.current().ajax().update("formEvenement");
//            this.collecterLesEvenements();
//        } catch (Exception e) {
//            FlashMessage.flash(FlashMessage.ERROR, "Erreur", "Une erreur s'est produite.");
//        }
//    }
//    public void collecterLesEvenements() {
//        evenementsList = new ArrayList<>();
//        evenementsList = creerUnEvenementFacade.getAllEvenements();
//
//    }
//
//    public void resetCreerUnEvenement() {
//        evenement = new EvenementEntity();// Réinitialise l'objet
//    }
//
//
//
//
//
//}
