package Model;

import java.util.List;

/**
 * Created by Kacper on 12.01.2019.
 */
public class WarehouseKeeper {
    private Integer id;
    private String login;
    private String haslo;
    private String imie_i_nazwisko;
    private List<DistList> lista_rozwozowa;

    public WarehouseKeeper(Integer id, String login, String haslo, String imie_i_nazwisko, List<DistList> lista_rozwozowa)
    {
        this.id = id;
        this.login = login;
        this.haslo = haslo;
        this.imie_i_nazwisko = imie_i_nazwisko;
        this.lista_rozwozowa=lista_rozwozowa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<DistList> getLista_rozwozowa() {
        return lista_rozwozowa;
    }

    public void setLista_rozwozowa(List<DistList> lista_rozwozowa) {
        this.lista_rozwozowa = lista_rozwozowa;
    }

    public String getImie_i_nazwisko() {
        return imie_i_nazwisko;
    }

    public void setImie_i_nazwisko(String imie_i_nazwisko) {
        this.imie_i_nazwisko = imie_i_nazwisko;
    }
}
