package com.corso.java.tourismagency.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(nominativo, cliente.nominativo) && Objects.equals(telNumber, cliente.telNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nominativo, telNumber);
    }
}
