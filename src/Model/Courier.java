package Model;

/**
 * Created by Kacper on 12.01.2019.
 */
public class Courier {
    private int id;
    private int lista_rozwozowa;
    private String login;
    private String haslo;

    public Courier(int id, int lista_rozwozowa, String login, String haslo) {
        this.id = id;
        this.lista_rozwozowa = lista_rozwozowa;
        this.login = login;
        this.haslo = haslo;
    }
}
