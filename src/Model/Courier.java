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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLista_rozwozowa() {
        return lista_rozwozowa;
    }

    public void setLista_rozwozowa(int lista_rozwozowa) {
        this.lista_rozwozowa = lista_rozwozowa;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }
}
