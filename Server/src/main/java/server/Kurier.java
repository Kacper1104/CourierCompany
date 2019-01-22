package server;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Kurier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;

    private Integer Lista_rozwozowa;

    private String Login;

    private String Haslo;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getLista_rozwozowa() {
        return Lista_rozwozowa;
    }

    public void setLista_rozwozowa(Integer lista_rozwozowa) {
        Lista_rozwozowa = lista_rozwozowa;
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
}