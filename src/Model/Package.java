package Model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by Kacper on 12.01.2019.
 */
public class Package {
    private int id;
    private String status_przesylki;
    private String opcja_dostawy;
    private BigDecimal koszt_do_zaplaty;
    private LocalDate data_nadania;
    private boolean na_liscie_rozwozowej = false;
    private int proba_dostarczenia = 0;
    private LocalDate ostatnia_zmiana_statusu;
    private int lista_rozwozowa_id;
    private int nadawca_id;
    private int odbiorca_id;



    public Package(int id, String status_przesylki, String opcja_dostawy, BigDecimal koszt_do_zaplaty, LocalDate data_nadania,
                   boolean na_liscie_rozwozowej, int proba_dostarczenia, LocalDate ostatnia_zmiana_statusu, int lista_rozwozowa_id, int nadawca_id, int odbiorca_id)
    {
        this.id = id;
        this.status_przesylki = status_przesylki;
        this.opcja_dostawy = opcja_dostawy;
        this.koszt_do_zaplaty = koszt_do_zaplaty;
        this.data_nadania = data_nadania;
        this.na_liscie_rozwozowej = na_liscie_rozwozowej;
        this.proba_dostarczenia = proba_dostarczenia;
        this.ostatnia_zmiana_statusu = ostatnia_zmiana_statusu;
        this.lista_rozwozowa_id = lista_rozwozowa_id;
        this.nadawca_id = nadawca_id;
        this.odbiorca_id = odbiorca_id;
    }


    public Package(String status_przesylki, String opcja_dostawy, BigDecimal koszt_do_zaplaty, LocalDate data_nadania,
                    LocalDate ostatnia_zmiana_statusu, int odbiorca_id)
    {
        this.status_przesylki = status_przesylki;
        this.opcja_dostawy = opcja_dostawy;
        this.koszt_do_zaplaty = koszt_do_zaplaty;
        this.data_nadania = data_nadania;
        this.ostatnia_zmiana_statusu = ostatnia_zmiana_statusu;
        this.odbiorca_id = odbiorca_id;
    }

    public Package(){

    }

    public Package(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus_przesylki() {
        return status_przesylki;
    }

    public void setStatus_przesylki(String status_przesylki) {
        this.status_przesylki = status_przesylki;
    }

    public String getOpcja_dostawy() {
        return opcja_dostawy;
    }

    public void setOpcja_dostawy(String opcja_dostawy) {
        this.opcja_dostawy = opcja_dostawy;
    }

    public BigDecimal getKoszt_do_zaplaty() {
        return koszt_do_zaplaty;
    }

    public void setKoszt_do_zaplaty(BigDecimal koszt_do_zaplaty) {
        this.koszt_do_zaplaty = koszt_do_zaplaty;
    }

    public LocalDate getData_nadania() {
        return data_nadania;
    }

    public void setData_nadania(LocalDate data_nadania) {
        this.data_nadania = data_nadania;
    }

    public boolean isNa_liscie_rozwozowej() {
        return na_liscie_rozwozowej;
    }

    public void setNa_liscie_rozwozowej(boolean na_liscie_rozwozowej) {
        this.na_liscie_rozwozowej = na_liscie_rozwozowej;
    }

    public int getProba_dostarczenia() {
        return proba_dostarczenia;
    }

    public void setProba_dostarczenia(int proba_dostarczenia) {
        this.proba_dostarczenia = proba_dostarczenia;
    }

    public LocalDate getOstatnia_zmiana_statusu() {
        return ostatnia_zmiana_statusu;
    }

    public void setOstatnia_zmiana_statusu(LocalDate ostatnia_zmiana_statusu) {
        this.ostatnia_zmiana_statusu = ostatnia_zmiana_statusu;
    }

    public int getLista_rozwozowa_id() {
        return lista_rozwozowa_id;
    }

    public void setLista_rozwozowa_id(int lista_rozwozowa_id) {
        this.lista_rozwozowa_id = lista_rozwozowa_id;
    }

    public int getNadawca_id() {
        return nadawca_id;
    }

    public void setNadawca_id(int nadawca_id) {
        this.nadawca_id = nadawca_id;
    }

    public int getOdbiorca_id() {
        return odbiorca_id;
    }

    public void setOdbiorca_id(int odbiorca_id) {
        this.odbiorca_id = odbiorca_id;
    }
}
