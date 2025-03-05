package org.etix.adapters.entities;

import jakarta.persistence.*;
import lombok.*;
import org.etix.domain.models.Evenement;
import org.etix.domain.models.enumerations.TypeEvenement;

import java.sql.Blob;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Table(name = "evenements")
@Entity
public class EvenementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String lieu;
    private String description;
    private double prixTicketGP;
    private double prixTicketVIP;
    private double prixTicketVVIP;
    private LocalDateTime dateEvenement;
    private LocalDateTime dateHeureCreation;
    @Enumerated(EnumType.STRING)
    private TypeEvenement typeEvenement;

    public static EvenementEntity toEntity(Evenement evenement) {
        return EvenementEntity.builder()
                .id(evenement.getId())
                .nom(evenement.getNom())
                .lieu(evenement.getLieu())
                .description(evenement.getDescription())
                .prixTicketGP(evenement.getPrixTicketGP())
                .prixTicketVIP(evenement.getPrixTicketVIP())
                .prixTicketVVIP(evenement.getPrixTicketVVIP())
                .dateEvenement(evenement.getDateEvenement())
                .dateHeureCreation(evenement.getDateHeureCreation())
                .typeEvenement(evenement.getTypeEvenement())
                .build();
    }

    public Evenement toDomain() {
        return new Evenement.Builder()
                .id(this.id)
                .nom(this.nom)
                .lieu(this.lieu)
                .description(this.description)
                .prixTicketGP(this.prixTicketGP)
                .prixTicketVIP(this.prixTicketVIP)
                .prixTicketVVIP(this.prixTicketVVIP)
                .dateEvenement(this.dateEvenement)
                .dateHeureCreation(this.dateHeureCreation)
                .typeEvenement(this.typeEvenement)
                .build();
    }

}
