package Model;

public class Kurier {
    private Integer ID;
    private Lista_rozwozowa Lista_rozwozowa_ID;
    private String Login;
    private String Haslo;
    private String Imie_I_Nazwisko;

    public Kurier(){}
    public Kurier(Integer ID, Lista_rozwozowa lista_rozwozowa_ID, String login, String haslo, String imie_I_Nazwisko) {
        this.ID = ID;
        Lista_rozwozowa_ID = lista_rozwozowa_ID;
        Login = login;
        Haslo = haslo;
        Imie_I_Nazwisko = imie_I_Nazwisko;
    }

    //getters & setters
    public Integer getID() {
        return ID;
    }
    public void setID(Integer ID) {
        this.ID = ID;
    }
    public Lista_rozwozowa getLista_rozwozowa_ID() {
        return Lista_rozwozowa_ID;
    }
    public void setLista_rozwozowa_ID(Lista_rozwozowa lista_rozwozowa_ID) {
        Lista_rozwozowa_ID = lista_rozwozowa_ID;
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
    public String getImie_I_Nazwisko() {
        return Imie_I_Nazwisko;
    }
    public void setImie_I_Nazwisko(String imie_I_Nazwisko) {
        Imie_I_Nazwisko = imie_I_Nazwisko;
    }
}