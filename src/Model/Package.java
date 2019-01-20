package Model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Kacper on 12.01.2019.
 */
public class Package {
    private int id;
    private String status_przesylki;
    private String opcja_dostawy;
    private BigDecimal koszt_do_zaplaty;
    private Date data_nadania;
    private boolean na_liscie_rozwozowej;
    private int proba_dostarczenia;
    private Date ostatnia_zmiana_statusu;
    private int lista_rozwozowa_id;
    private int nadawca_id;
    private int odbiorca_id;

    public Package(int id, String status_przesylki, String opcja_dostawy, BigDecimal koszt_do_zaplaty, Date data_nadania,
                   boolean na_liscie_rozwozowej, int proba_dostarczenia, Date ostatnia_zmiana_statusu, int lista_rozwozowa_id, int nadawca_id, int odbiorca_id)
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


    public Package(String status_przesylki, String opcja_dostawy, BigDecimal koszt_do_zaplaty)
    {
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
}
