package Model;

import java.util.Date;
import java.util.List;

public class Lista_rozwozowa {
    private Integer ID;
    private Date Data;
    private Magazynier Magazynier_ID;
    private Kurier kurier;
    private List<Przesylka> przesylka;

    public Lista_rozwozowa(){}
    public Lista_rozwozowa(Integer ID, Date data, Magazynier magazynier_ID, Kurier kurier, List<Przesylka> przesylka) {
        this.ID = ID;
        Data = data;
        Magazynier_ID = magazynier_ID;
        this.kurier = kurier;
        this.przesylka = przesylka;
    }

    public Lista_rozwozowa(Date data, Magazynier magazynier_ID, Kurier kurier, List<Przesylka> przesylka) {
        Data = data;
        Magazynier_ID = magazynier_ID;
        this.kurier = kurier;
        this.przesylka = przesylka;
    }

    //getters & setters
    public Integer getID() {
        return ID;
    }
    public void setID(Integer ID) {
        this.ID = ID;
    }
    public Date getData() {
        return Data;
    }
    public void setData(Date data) {
        Data = data;
    }
    public Magazynier getMagazynier_ID() {
        return Magazynier_ID;
    }
    public void setMagazynier_ID(Magazynier magazynier_ID) {
        Magazynier_ID = magazynier_ID;
    }
    public Kurier getKurier() {
        return kurier;
    }
    public void setKurier(Kurier kurier) {
        this.kurier = kurier;
    }
    public List<Przesylka> getPrzesylka() {
        return przesylka;
    }
    public void setPrzesylka(List<Przesylka> przesylka) {
        this.przesylka = przesylka;
    }
}