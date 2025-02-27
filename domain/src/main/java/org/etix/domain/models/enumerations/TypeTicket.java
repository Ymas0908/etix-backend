package org.etix.domain.models.enumerations;

import java.util.List;

public enum TypeTicket {
    GP,
    VIP,
    VVIP;

    public static List<TypeTicket> getTypes() {
        return List.of(TypeTicket.values());
    }
}
