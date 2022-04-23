package com.corso.java.tourismagency.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *  Si sviluppi una classe Cliente avente come variabili d’istanza il nominativo ed numero telefonico del cliente,
 *  rappresentati entrambi come stringhe, con i relativi metodi di accesso ed un costruttore.
 */

@Entity
public class Cliente {

    @Id
    private String nominativo;
    private String telNumber;

    public Cliente(String nominativo, String telNumber) {
        this.nominativo = nominativo;
        this.telNumber = telNumber;
    }

    public Cliente() {

    }

    public String getNominativo() {
        return nominativo;
    }

    public void setNominativo(String nominativo) {
        this.nominativo = nominativo;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }
}
