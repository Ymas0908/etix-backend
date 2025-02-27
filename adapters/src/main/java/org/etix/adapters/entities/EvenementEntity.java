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
    private Blob imageEvenement;
    private String lieu;
    private String description;
    private LocalDateTime dateEvenement;
    private LocalDateTime dateHeureCreation;
    @Enumerated(EnumType.STRING)
    private TypeEvenement typeEvenement;

    public static EvenementEntity toEntity(Evenement evenement) {
        return EvenementEntity.builder()
                .id(evenement.getId())
                .nom(evenement.getNom())
                .imageEvenement(evenement.getImageEvenement())
                .lieu(evenement.getLieu())
                .description(evenement.getDescription())
                .dateEvenement(evenement.getDateEvenement())
                .dateHeureCreation(evenement.getDateHeureCreation())
                .typeEvenement(evenement.getTypeEvenement())
                .build();
    }

    public Evenement toDomain() {
        return new Evenement.Builder()
                .id(this.id)
                .nom(this.nom)
                .imageEvenement(this.imageEvenement)
                .lieu(this.lieu)
                .description(this.description)
                .dateEvenement(this.dateEvenement)
                .dateHeureCreation(this.dateHeureCreation)
                .typeEvenement(this.typeEvenement)
                .build();
    }

}
