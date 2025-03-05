package org.etix.domain.models;

import org.etix.domain.models.enumerations.TypeEvenement;

import java.sql.Blob;
import java.time.LocalDateTime;

public class Evenement {
    private Integer id;
    private String nom;
    private String description;
    private double prixTicketGP;
    private double prixTicketVIP;
    private double prixTicketVVIP;
    private String lieu;
    private LocalDateTime dateEvenement;
    private LocalDateTime dateHeureCreation;
    private TypeEvenement typeEvenement;

    public Evenement() {
    }

    public Evenement(Integer id, String nom,  String description,double prixTicketGP, double prixTicketVIP, double prixTicketVVIP, String lieu, LocalDateTime dateEvenement, LocalDateTime dateHeureCreation, TypeEvenement typeEvenement) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.prixTicketGP = prixTicketGP;
        this.prixTicketVIP = prixTicketVIP;
        this.prixTicketVVIP = prixTicketVVIP;
        this.lieu = lieu;
        this.dateEvenement = dateEvenement;
        this.dateHeureCreation = dateHeureCreation;
        this.typeEvenement = typeEvenement;
    }

    private Evenement(Builder builder) {
        setId(builder.id);
        setNom(builder.nom);
        setDescription(builder.description);
        setLieu(builder.lieu);
        setDateEvenement(builder.dateEvenement);
        setDateHeureCreation(builder.dateHeureCreation);
        setTypeEvenement(builder.typeEvenement);
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

    public double getPrixTicketGP() {
        return prixTicketGP;
    }

    public void setPrixTicketGP(double prixTicketGP) {
        this.prixTicketGP = prixTicketGP;
    }

    public double getPrixTicketVVIP() {
        return prixTicketVVIP;
    }

    public void setPrixTicketVVIP(double prixTicketVVIP) {
        this.prixTicketVVIP = prixTicketVVIP;
    }

    public double getPrixTicketVIP() {
        return prixTicketVIP;
    }

    public void setPrixTicketVIP(double prixTicketVIP) {
        this.prixTicketVIP = prixTicketVIP;
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


    public static final class Builder {
        private Integer id;
        private String nom;
        private Blob imageEvenement;
        private String description;
        private double prixTicketGP;
        private double prixTicketVIP;
        private double prixTicketVVIP;
        private String lieu;
        private LocalDateTime dateEvenement;
        private LocalDateTime dateHeureCreation;
        private TypeEvenement typeEvenement;

        public Builder() {
        }

        public Builder id(Integer val) {
            id = val;
            return this;
        }

        public Builder nom(String val) {
            nom = val;
            return this;
        }


        public Builder description(String val) {
            description = val;
            return this;
        }

        public Builder lieu(String val) {
            lieu = val;
            return this;
        }

        public Builder dateEvenement(LocalDateTime val) {
            dateEvenement = val;
            return this;
        }

        public Builder dateHeureCreation(LocalDateTime val) {
            dateHeureCreation = val;
            return this;
        }

        public Builder typeEvenement(TypeEvenement val) {
            typeEvenement = val;
            return this;
        }

        public Builder prixTicketGP(double prixTicketGP) {
            this.prixTicketGP = prixTicketGP;
            return this;
        }

        public Builder prixTicketVVIP(double prixTicketVVIP) {
            this.prixTicketVVIP = prixTicketVVIP;
            return this;
        }

        public Builder prixTicketVIP(double prixTicketVIP) {
            this.prixTicketVIP = prixTicketVIP;
            return this;
        }

        public Evenement build() {
            return new Evenement(this);
        }
    }
}
