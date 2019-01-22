package Model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by Kacper on 12.01.2019.
 */
public class Package {
    private Integer id;
    private String status_przesylki;
    private String opcja_dostawy;
    private double koszt_do_zaplaty;
    private Date data_nadania;
    private boolean na_liscie_rozwozowej = false;
    private Integer proba_dostarczenia = 0;
    private Date ostatnia_zmiana_statusu;
    private DistList lista_rozwozowa_id;
    private Sender nadawca_id;
    private Recipient odbiorca_id;



    public Package(Integer id, String status_przesylki, String opcja_dostawy, double koszt_do_zaplaty, Date data_nadania,
                   boolean na_liscie_rozwozowej, Integer proba_dostarczenia, Date ostatnia_zmiana_statusu, DistList lista_rozwozowa_id, Sender nadawca_id, Recipient odbiorca_id)
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

    public Package(String status_przesylki, String opcja_dostawy, double koszt_do_zaplaty, Date data_nadania,
                   Date ostatnia_zmiana_statusu, Recipient odbiorca_id)
    {
        this.id = id;
        this.status_przesylki = status_przesylki;
        this.opcja_dostawy = opcja_dostawy;
        this.koszt_do_zaplaty = koszt_do_zaplaty;
        this.data_nadania = data_nadania;
        this.ostatnia_zmiana_statusu = ostatnia_zmiana_statusu;
        this.odbiorca_id = odbiorca_id;
    }

    public Package(){

    }

    public Integer getId() {
        return id;
    }

    public Date getOstatnia_zmiana_statusu() {
        return ostatnia_zmiana_statusu;
    }

    public Date getData_nadania() {
        return data_nadania;
    }

    public Integer getProba_dostarczenia() {
        return proba_dostarczenia;
    }

    public String getStatus_przesylki() {
        return status_przesylki;
    }

    public String getOpcja_dostawy() {
        return opcja_dostawy;
    }

    public DistList getLista_rozwozowa_id() {
        return lista_rozwozowa_id;
    }

    public double getKoszt_do_zaplaty() {
        return koszt_do_zaplaty;
    }

    public Recipient getOdbiorca_id() {
        return odbiorca_id;
    }

    public Sender getNadawca_id() {
        return nadawca_id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setProba_dostarczenia(Integer proba_dostarczenia) {
        this.proba_dostarczenia = proba_dostarczenia;
    }

    public void setOstatnia_zmiana_statusu(Date ostatnia_zmiana_statusu) {
        this.ostatnia_zmiana_statusu = ostatnia_zmiana_statusu;
    }

    public void setNa_liscie_rozwozowej(boolean na_liscie_rozwozowej) {
        this.na_liscie_rozwozowej = na_liscie_rozwozowej;
    }

    public void setData_nadania(Date data_nadania) {
        this.data_nadania = data_nadania;
    }

    public void setStatus_przesylki(String status_przesylki) {
        this.status_przesylki = status_przesylki;
    }

    public void setOpcja_dostawy(String opcja_dostawy) {
        this.opcja_dostawy = opcja_dostawy;
    }

    public void setKoszt_do_zaplaty(double koszt_do_zaplaty) {
        this.koszt_do_zaplaty = koszt_do_zaplaty;
    }

    public void setLista_rozwozowa_id(DistList lista_rozwozowa_id) {
        this.lista_rozwozowa_id = lista_rozwozowa_id;
    }

    public void setNadawca_id(Sender nadawca_id) {
        this.nadawca_id = nadawca_id;
    }

    public void setOdbiorca_id(Recipient odbiorca_id) {
        this.odbiorca_id = odbiorca_id;
    }
}
