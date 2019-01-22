package Model;

import java.util.List;

/**
 * Created by Kacper on 12.01.2019.
 */
public class Sender {

    private Integer id;
    private Integer nr_konta;
    private String imie_i_nazwisko;
    private String adres;
    private String kod_pocztowy;
    private String miejscowosc;
    private String login;
    private String haslo;
    private List<Package> przesylka;

    public Sender(int id, int nr_konta, String imie_i_nazwisko, String adres, String kod_pocztowy, String miejscowosc, String login, String haslo, List<Package> przesylka)
    {
        this.id = id;
        this.nr_konta = nr_konta;
        this.imie_i_nazwisko = imie_i_nazwisko;
        this.adres = adres;
        this.kod_pocztowy = kod_pocztowy;
        this.miejscowosc = miejscowosc;
        this.login = login;
        this.haslo = haslo;
        this.przesylka=przesylka;
    }



    public Sender() {

    }
    public int getId() {
        return id;
    }
    public int getNr_konta() {
        return nr_konta;
    }
    public String getImie_i_nazwisko() {
        return imie_i_nazwisko;
    }
    public void setImie_i_nazwisko(String imie_i_nazwisko) {
        this.imie_i_nazwisko = imie_i_nazwisko;
    }
    public String getAdres() {
        return adres;
    }
    public void setAdres(String adres) {
        this.adres = adres;
    }
    public String getKod_pocztowy() {
        return kod_pocztowy;
    }
    public void setKod_pocztowy(String kod_pocztowy) {
        this.kod_pocztowy = kod_pocztowy;
    }
    public String getMiejscowosc() {
        return miejscowosc;
    }
    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
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
    public List<Package> getPrzesylka() {
        return przesylka;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setNr_konta(Integer nr_konta) {
        this.nr_konta = nr_konta;
    }
    public void setPrzesylka(List<Package> przesylka) {
        this.przesylka = przesylka;
    }
}
