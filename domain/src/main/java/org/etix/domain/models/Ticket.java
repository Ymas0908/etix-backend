package org.etix.domain.models;

import org.etix.domain.models.enumerations.TypeTicket;

public class Ticket {
    private Integer id;

    private double prix;
    private int quantite;
    private TypeTicket typeTicket;
    private Evenement evenement;
    public Ticket() {
    }

    public Ticket(Integer id, double prix, int quantite, TypeTicket typeTicket, Evenement evenement) {
        this.id = id;
        this.prix = prix;
        this.quantite = quantite;
        this.typeTicket = typeTicket;
        this.evenement = evenement;
    }

    private Ticket(Builder builder) {
        setId(builder.id);
        setPrix(builder.prix);
        setQuantite(builder.quantite);
        setTypeTicket(builder.typeTicket);
        setEvenement(builder.evenement);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public TypeTicket getTypeTicket() {
        return typeTicket;
    }

    public void setTypeTicket(TypeTicket typeTicket) {
        this.typeTicket = typeTicket;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    public static final class Builder {
        private Integer id;
        private double prix;
        private int quantite;
        private TypeTicket typeTicket;
        private Evenement evenement;

        public Builder() {
        }

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder prix(double prix) {
            this.prix = prix;
            return this;
        }

        public Builder quantite(int quantite) {
            this.quantite = quantite;
            return this;
        }

        public Builder typeTicket(TypeTicket typeTicket) {
            this.typeTicket = typeTicket;
            return this;
        }

        public Builder evenement(Evenement evenement) {
            this.evenement = evenement;
            return this;
        }

        public Ticket build() {
            return new Ticket(this);
        }
    }
}
