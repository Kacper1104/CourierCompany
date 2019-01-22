package Model;

import java.util.List;

/**
 * Created by Kacper on 12.01.2019.
 */
public class Recipient {
    private int id;
    private String adnotacje;
    private String imie_i_nazwisko;
    private String adres;
    private String kod_pocztowy;
    private String miejscowosc;
    private String login;
    private String haslo;
    private List<Package> przesylka;


    public Recipient(int id, String adnotacje, String imie_i_nazwisko, String adres, String kod_pocztowy, String miejscowosc, String login, String haslo, List<Package> przesylka) {
        this.id = id;
        this.adnotacje = adnotacje;
        this.imie_i_nazwisko = imie_i_nazwisko;
        this.adres = adres;
        this.kod_pocztowy = kod_pocztowy;
        this.miejscowosc = miejscowosc;
        this.login = login;
        this.haslo = haslo;
        this.przesylka=przesylka;
    }

    public Recipient(String imie_i_nazwisko, String adres, String kod_pocztowy, String miejscowosc) {
        this.imie_i_nazwisko = imie_i_nazwisko;
        this.adres = adres;
        this.kod_pocztowy = kod_pocztowy;
        this.miejscowosc = miejscowosc;
    }

    public Recipient() {

    }


    public List<Package> getPrzesylka() {
        return przesylka;
    }
    public void setPrzesylka(List<Package> przesylka) {
        this.przesylka = przesylka;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAdnotacje() {
        return adnotacje;
    }
    public void setAdnotacje(String adnotacje) {
        this.adnotacje = adnotacje;
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
}
