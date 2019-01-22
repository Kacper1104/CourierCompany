package Model;

import java.util.List;

public class Nadawca {
    private Integer ID;
    private Integer Numer_konta;
    private String Imie_I_Nazwisko;
    private String Adres;
    private String Kod_Pocztowy;
    private String Miejscowosc;
    private String Login;
    private String Haslo;
    List<Przesylka> przesylka;

    public Nadawca(){}
    public Nadawca(Integer ID, Integer numer_konta, String imie_I_Nazwisko, String adres, String kod_Pocztowy, String miejscowosc, String login, String haslo, List<Przesylka> przesylka) {
        this.ID = ID;
        Numer_konta = numer_konta;
        Imie_I_Nazwisko = imie_I_Nazwisko;
        Adres = adres;
        Kod_Pocztowy = kod_Pocztowy;
        Miejscowosc = miejscowosc;
        Login = login;
        Haslo = haslo;
        this.przesylka = przesylka;
    }

    //getters & setters
    public Integer getID() {
        return ID;
    }
    public void setID(Integer ID) {
        this.ID = ID;
    }
    public Integer getNumer_konta() {
        return Numer_konta;
    }
    public void setNumer_konta(Integer numer_konta) {
        Numer_konta = numer_konta;
    }
    public String getImie_I_Nazwisko() {
        return Imie_I_Nazwisko;
    }
    public void setImie_I_Nazwisko(String imie_I_Nazwisko) {
        Imie_I_Nazwisko = imie_I_Nazwisko;
    }
    public String getAdres() {
        return Adres;
    }
    public void setAdres(String adres) {
        Adres = adres;
    }
    public String getKod_Pocztowy() {
        return Kod_Pocztowy;
    }
    public void setKod_Pocztowy(String kod_Pocztowy) {
        Kod_Pocztowy = kod_Pocztowy;
    }
    public String getMiejscowosc() {
        return Miejscowosc;
    }
    public void setMiejscowosc(String miejscowosc) {
        Miejscowosc = miejscowosc;
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
    public List<Przesylka> getPrzesylka() {
        return przesylka;
    }
    public void setPrzesylka(List<Przesylka> przesylka) {
        this.przesylka = przesylka;
    }
}