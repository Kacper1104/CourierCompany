package Model;

import java.util.Date;

public class Przesylka {
    private Integer ID;
    private String Status_przesylki;
    private String Opcja_dostawy;
    private double Koszt_Do_Zaplaty;
    private Date Data_nadania;
    private boolean Na_liscie_rozwozowej;
    private Integer Proba_dostarczenia;
    private Date Ostatnia_zmiana_statusu;
    private Lista_rozwozowa Lista_rozwozowa_ID;
    private Nadawca Nadawca_ID;
    private Odbiorca Odbiorca_ID;


    public Przesylka(){};
    public Przesylka(Integer ID, String status_przesylki, String opcja_dostawy, double koszt_Do_Zaplaty, Date data_nadania, boolean na_liscie_rozwozowej, Integer proba_dostarczenia, Date ostatnia_zmiana_statusu, Lista_rozwozowa lista_rozwozowa_ID, Nadawca nadawca_ID, Odbiorca odbiorca_ID) {
        this.ID = ID;
        Status_przesylki = status_przesylki;
        Opcja_dostawy = opcja_dostawy;
        Koszt_Do_Zaplaty = koszt_Do_Zaplaty;
        Data_nadania = data_nadania;
        Na_liscie_rozwozowej = na_liscie_rozwozowej;
        Proba_dostarczenia = proba_dostarczenia;
        Ostatnia_zmiana_statusu = ostatnia_zmiana_statusu;
        Lista_rozwozowa_ID = lista_rozwozowa_ID;
        Nadawca_ID = nadawca_ID;
        Odbiorca_ID = odbiorca_ID;
    }

    public Przesylka(String status_przesylki, String opcja_dostawy, double koszt_Do_Zaplaty, Date data_nadania, Date ostatnia_zmiana_statusu, Odbiorca odbiorca_ID) {
        Status_przesylki = status_przesylki;
        Opcja_dostawy = opcja_dostawy;
        Koszt_Do_Zaplaty = koszt_Do_Zaplaty;
        Data_nadania = data_nadania;
        Ostatnia_zmiana_statusu = ostatnia_zmiana_statusu;
        Odbiorca_ID = odbiorca_ID;
    }

    //getters & setters
    public Integer getID() {
        return ID;
    }
    public void setID(Integer ID) {
        this.ID = ID;
    }
    public String getOpcja_dostawy() {
        return Opcja_dostawy;
    }
    public void setOpcja_dostawy(String opcja_dostawy) {
        Opcja_dostawy = opcja_dostawy;
    }
    public String getStatus_przesylki() {
        return Status_przesylki;
    }
    public void setStatus_przesylki(String status_przesylki) {
        Status_przesylki = status_przesylki;
    }
    public double getKoszt_Do_Zaplaty() {
        return Koszt_Do_Zaplaty;
    }
    public void setKoszt_Do_Zaplaty(double koszt_Do_Zaplaty) {
        Koszt_Do_Zaplaty = koszt_Do_Zaplaty;
    }
    public Date getData_nadania() {
        return Data_nadania;
    }
    public void setData_nadania(Date data_nadania) {
        Data_nadania = data_nadania;
    }
    public boolean getNa_liscie_rozwozowej() {
        return Na_liscie_rozwozowej;
    }
    public void setNa_liscie_rozwozowej(boolean na_liscie_rozwozowej) {
        Na_liscie_rozwozowej = na_liscie_rozwozowej;
    }
    public Integer getProba_dostarczenia() {
        return Proba_dostarczenia;
    }
    public void setProba_dostarczenia(Integer proba_dostarczenia) {
        Proba_dostarczenia = proba_dostarczenia;
    }
    public Date getOstatnia_zmiana_statusu() {
        return Ostatnia_zmiana_statusu;
    }
    public void setOstatnia_zmiana_statusu(Date ostatnia_zmiana_statusu) {
        Ostatnia_zmiana_statusu = ostatnia_zmiana_statusu;
    }
    public Lista_rozwozowa getLista_rozwozowa_ID() {
        return Lista_rozwozowa_ID;
    }
    public void setLista_rozwozowa_ID(Lista_rozwozowa lista_rozwozowa_ID) {
        Lista_rozwozowa_ID = lista_rozwozowa_ID;
    }
    public Nadawca getNadawca_ID() {
        return Nadawca_ID;
    }
    public void setNadawca_ID(Nadawca nadawca_ID) {
        Nadawca_ID = nadawca_ID;
    }
    public Odbiorca getOdbiorca_ID() {
        return Odbiorca_ID;
    }
    public void setOdbiorca_ID(Odbiorca odbiorca_ID) {
        Odbiorca_ID = odbiorca_ID;
    }
}
