package org.etix.domain.models;

import org.etix.domain.models.enumerations.TypeEvenement;

import java.sql.Blob;
import java.time.LocalDateTime;

public class Evenement {
    private Integer id;
    private String nom;
    private String description;
    private String lieu;
    private Double prixTicketGP;
    private Double prixTicketVIP;
    private Double prixTicketVVIP;
    private LocalDateTime dateEvenement;
    private LocalDateTime dateHeureCreation;
    private TypeEvenement typeEvenement;

    public Evenement() {
    }

    public Evenement(Integer id, String nom, String description, String lieu, Double prixTicketGP, Double prixTicketVIP, Double prixTicketVVIP, LocalDateTime dateEvenement, LocalDateTime dateHeureCreation, TypeEvenement typeEvenement) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.lieu = lieu;
        this.prixTicketGP = prixTicketGP;
        this.prixTicketVIP = prixTicketVIP;
        this.prixTicketVVIP = prixTicketVVIP;
        this.dateEvenement = dateEvenement;
        this.dateHeureCreation = dateHeureCreation;
        this.typeEvenement = typeEvenement;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Double getPrixTicketGP() {
        return prixTicketGP;
    }

    public void setPrixTicketGP(Double prixTicketGP) {
        this.prixTicketGP = prixTicketGP;
    }

    public Double getPrixTicketVIP() {
        return prixTicketVIP;
    }

    public void setPrixTicketVIP(Double prixTicketVIP) {
        this.prixTicketVIP = prixTicketVIP;
    }

    public Double getPrixTicketVVIP() {
        return prixTicketVVIP;
    }

    public void setPrixTicketVVIP(Double prixTicketVVIP) {
        this.prixTicketVVIP = prixTicketVVIP;
    }

    public LocalDateTime getDateEvenement() {
        return dateEvenement;
    }

    public void setDateEvenement(LocalDateTime dateEvenement) {
        this.dateEvenement = dateEvenement;
    }

    public LocalDateTime getDateHeureCreation() {
        return dateHeureCreation;
    }

    public void setDateHeureCreation(LocalDateTime dateHeureCreation) {
        this.dateHeureCreation = dateHeureCreation;
    }

    public TypeEvenement getTypeEvenement() {
        return typeEvenement;
    }

    public void setTypeEvenement(TypeEvenement typeEvenement) {
        this.typeEvenement = typeEvenement;
    }

    private Evenement(Builder builder) {
        id = builder.id;
        nom = builder.nom;
        description = builder.description;
        lieu = builder.lieu;
        prixTicketGP = builder.prixTicketGP;
        prixTicketVIP = builder.prixTicketVIP;
        prixTicketVVIP = builder.prixTicketVVIP;
        dateEvenement = builder.dateEvenement;
        dateHeureCreation = builder.dateHeureCreation;
        typeEvenement = builder.typeEvenement;
    }

    public static final class Builder {
        private Integer id;
        private String nom;
        private String description;
        private String lieu;
        private Double prixTicketGP;
        private Double prixTicketVIP;
        private Double prixTicketVVIP;
        private LocalDateTime dateEvenement;
        private LocalDateTime dateHeureCreation;
        private TypeEvenement typeEvenement;

        public Builder() {
        }

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder nom(String nom) {
            this.nom = nom;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder lieu(String lieu) {
            this.lieu = lieu;
            return this;
        }

        public Builder prixTicketGP(Double prixTicketGP) {
            this.prixTicketGP = prixTicketGP;
            return this;
        }

        public Builder prixTicketVIP(Double prixTicketVIP) {
            this.prixTicketVIP = prixTicketVIP;
            return this;
        }

        public Builder prixTicketVVIP(Double prixTicketVVIP) {
            this.prixTicketVVIP = prixTicketVVIP;
            return this;
        }

        public Builder dateEvenement(LocalDateTime dateEvenement) {
            this.dateEvenement = dateEvenement;
            return this;
        }

        public Builder dateHeureCreation(LocalDateTime dateHeureCreation) {
            this.dateHeureCreation = dateHeureCreation;
            return this;
        }

        public Builder typeEvenement(TypeEvenement typeEvenement) {
            this.typeEvenement = typeEvenement;
            return this;
        }

        public Evenement build() {
            return new Evenement(this);
        }
    }
}
