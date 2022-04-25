package com.corso.java.tourismagency.domain;

import org.springframework.web.bind.annotation.Mapping;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Spettacolo {

    @Id
    private String id;

    @ManyToOne
    private Cliente[] prenotazioni;

    private int n_prenotazione;

    @OneToMany
    private ArrayList<Cliente> attesa;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cliente[] getPrenotazioni() {
        return prenotazioni;
    }

    public void setPrenotazioni(Cliente[] prenotazioni) {
        this.prenotazioni = prenotazioni;
    }

    public int getN_prenotazione() {
        return n_prenotazione;
    }

    public void setN_prenotazione(int n_prenotazione) {
        this.n_prenotazione = n_prenotazione;
    }

    public ArrayList<Cliente> getAttesa() {
        return attesa;
    }

    public void setAttesa(ArrayList<Cliente> attesa) {
        this.attesa = attesa;
    }

    public Spettacolo(Cliente[] prenotazioni, int n_prenotazione, ArrayList<Cliente> attesa) {
        this.prenotazioni = prenotazioni;
        this.n_prenotazione = n_prenotazione;
        this.attesa = attesa;
    }

    public Spettacolo(int n) {
        this.prenotazioni = new Cliente[n];
    }

    public Spettacolo() {
    }

    public boolean libero() {
        int length = this.prenotazioni.length;
        //cerco se almeno un posto è libero
        return this.prenotazioni[length - 1] == null;
    }


    public int trova(String nome, String tel) {
        int length = this.prenotazioni.length, res = -1;
        Cliente c = new Cliente(nome, tel);

        // controllo se il cliente ha già un posto
        for (int i = 0; i < prenotazioni.length; i++) {
            if(c.equals(prenotazioni[i])) {
                res = 0;
                break;
            }
        }

        // controllo se il cliente è in lista di attesa
        for (int i = 0; i < length; i++) {
            if (c.equals(attesa.get(i))) {
                res = 1;
                break;
            }
        }
        return res;
    }


    public void prenota(String nome, String tel) {
        Cliente c = new Cliente(nome, tel);
    //controllo se c'è un posto libero
        if (libero()) {
            // controllo se il cliente è in attesa, se sì lo elimino dalla lista d'attesa.
            if (trova(nome, tel) == 1)
                attesa.remove(c);
        // lo aggiungo alla lista prenotazioni nel primo posto libero
        for (int i = 0; i < prenotazioni.length; i++) {
            if (prenotazioni[i] == null) {
                prenotazioni[i] = c;
                break;
            }
        }
        // se non ci sono posti disponibili stampo messaggio
        } else
            System.out.println("Posti esauriti!");
    }


    public void disdici(String nome, String tel){
        Cliente c = new Cliente(nome,tel);

        //cerco il cliente da eliminare e lo rimuovo.
        for (int i = 0; i < prenotazioni.length; i++) {
            if (c.equals(prenotazioni[i])) {
                prenotazioni[i] = null;
                //aggiungo alle prenotazioni il primo cliente in lista d'attesa
                prenotazioni[i] = attesa.get(0);
                //rimuovo il primo elemento della lista d'attesa
                attesa.remove(attesa.get(0));
                // sistemo la coda d'attesa
                spostaAvanti();
                break;
            }
        }
    }

    public boolean incompleto() {
        for (Cliente cliente : prenotazioni) {
            for (Cliente cliente1 : attesa) {
                if (cliente.equals(cliente1))
                    return true;
            }
        }
           return false;

    }

    public void spostaAvanti() {
        for (int i = 0; i < attesa.size() - 1; i++) {
            attesa.add(i, attesa.get(i + 1));
        }
        attesa.remove(attesa.get(attesa.size() - 1));
    }


}
