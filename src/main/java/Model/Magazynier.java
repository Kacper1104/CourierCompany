package Model;


import java.util.List;

public class Magazynier {
    private Integer ID;
    private String Login;
    private String Haslo;
    private List<Lista_rozwozowa> lista_rozwozowa;

    public Magazynier(Integer ID, String login, String haslo, List<Lista_rozwozowa> lista_rozwozowa) {
        this.ID = ID;
        Login = login;
        Haslo = haslo;
        this.lista_rozwozowa = lista_rozwozowa;
    }

    //getters & setters
    public Integer getID() {
        return ID;
    }
    public void setID(Integer ID) {
        this.ID = ID;
    }
    public String getLogin() {
        return Login;
    }
    public void setLogin(String login) {
        Login = login;
    }
    public String getHaslo() {
        return Haslo;
    }
    public void setHaslo(String haslo) {
        Haslo = haslo;
    }
    public List<Lista_rozwozowa> getLista_rozwozowa() {
        return lista_rozwozowa;
    }
    public void setLista_rozwozowa(List<Lista_rozwozowa> lista_rozwozowa) {
        this.lista_rozwozowa = lista_rozwozowa;
    }
}