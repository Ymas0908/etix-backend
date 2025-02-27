package org.etix.adapters.driver.api;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Réponse de l'API Rest
 *
 * @author Luc
 */
@Setter
@Getter
public class ErrorResponseApi implements Serializable {


    private static final long serialVersionUID = 1678596161217027130L;

    // SETTERS
    // GETTERS
    private String message; // Le message de retour
    private int status; // Le satus
    private Date timestamp; // La date et l'heure

    public ErrorResponseApi() {
        this.timestamp = new Date();
    }

    public ErrorResponseApi(String message) {
        this.message = message;
    }


    public ErrorResponseApi(String message, int status) {
        this.message = message;
        this.status = status;
        this.timestamp = new Date();
    }

}
