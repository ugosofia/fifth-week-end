# fifth-week-end
Esercitazione del quinto weekend



Testo:

Un’agenzia per il turismo desidera gestire automaticamente la prenotazione dei posti per un concerto. Si sviluppi una classe Cliente avente come variabili d’istanza il nominativo ed numero telefonico del cliente, rappresentati entrambi come stringhe, con i relativi metodi di accesso ed un costruttore. Si sviluppi inoltre la seguente classe:

public class Spettacolo {
private Cliente[] prenotazioni;
private int n_prenotazione;
private ArrayList<Cliente> attesa;
public Spettacolo(int n){...}
public boolean libero(){...}
public int trova(String nome, String tel){...}
public void prenota(String nome, String tel){...}
public void disdici(String nome, String tel){...}
public boolean incompleto(){...}
}

L’array prenotazioni contiene i clienti che hanno il posto, la lista attesa contiene i clienti in lista d’attesa. La lista d’attesa deve essere gestita con la politica primo arrivato, primo servito. Il costruttore inizializza una classe con un array prenotazioni (inizialmente vuoto) avente lunghezza n specificata come parametro. Il metodo libero restituisce true solo se vi sono posti ancora liberi. Il metodo trova restituisce 0 se il cliente specificato ha il posto, 1 se il cliente è in attesa e -1 altrimenti. Il metodo prenota inserisce il cliente specificato nell’oggetto (eventualmente in attesa). Il metodo disdici rimuove il cliente specificato dall’oggetto. Nel caso venga liberato un posto in prenotazioni, viene trasferito il primo cliente da attesa. Infine, il metodo incompleto restituisce true se esiste almeno un cliente che abbia almeno un posto ed almeno una prenotazione in attesa; il metodo restituisce false
in caso contrario. 

Si assume che un cliente possa avere più prenotazioni che possono trovarsi sia nell’array prenotazioni, sia nell’ArrayList attesa. Sulla base di questa considerazione si implementa il metodo disdici in modo che venga cancellata una prenotazione per volta a partire dalla lista delle attese. A questo scopo si è preferito invertire l’ordine delle istruzioni nel metodo trova() in modo da analizzare prima la lista d’attesa. 

Si Utilizzi springboot con Jpa, Angular per verificare le funzioni e deve essere completo di una test suite.
