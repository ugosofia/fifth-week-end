package com.corso.java.tourismagency.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Objects;

/**
 *  Si sviluppi una classe Cliente avente come variabili d’istanza il nominativo ed numero telefonico del cliente,
 *  rappresentati entrambi come stringhe, con i relativi metodi di accesso ed un costruttore.
 */

@Entity
public class Cliente {

    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
        if (!(o instanceof Cliente))
            return false;
        if (o == null)
            return false;
        Cliente cliente = (Cliente) o;



        return (this.nominativo.equals(cliente.nominativo)) && (this.telNumber.equals(cliente.telNumber));
    }

    public static void main(String[] args) {
        Cliente c = new Cliente("ugo", "434234342");
        Cliente c1 = new Cliente("ugo", "434234342");
        ArrayList<Cliente> list = new ArrayList<>();
        Cliente[] lista = new Cliente[1];
        Spettacolo spettacolo = new Spettacolo(lista, 1, list);

        spettacolo.prenota(c.getNominativo(), c.getTelNumber());


    }
}
