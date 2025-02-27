package org.etix.domain.models.enumerations;

import java.util.List;

public enum TypeEvenement {
    CONCERT,
    THEATRE,
    CINEMA,
    FESTIVAL,
    EXPOSITION,
    RELEASE_PART,

    MATCH;

    public static List<TypeEvenement> getTypes() {
        return List.of(TypeEvenement.values());
    }
}
