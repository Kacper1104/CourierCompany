package Model;


import sun.rmi.runtime.Log;

public class Odbiorca{
    private Integer ID;
    private String Adnotacje;
    private String Imie_I_Nazwisko;
    private String Adres;
    private String Kod_Pocztowy;
    private String Miejscowosc;
    private String Login;
    private String Haslo;


    //constructors
    public Odbiorca() {}
    public Odbiorca(String imie_I_Nazwisko, String adres, String kod_Pocztowy, String miejscowosc) {
        Imie_I_Nazwisko = imie_I_Nazwisko;
        Adres = adres;
        Kod_Pocztowy = kod_Pocztowy;
        Miejscowosc = miejscowosc;
    }

    public Odbiorca(String imie_I_Nazwisko, String adres, String kod_Pocztowy, String miejscowosc, String login, String haslo) {
        Imie_I_Nazwisko = imie_I_Nazwisko;
        Adres = adres;
        Kod_Pocztowy = kod_Pocztowy;
        Miejscowosc = miejscowosc;
        Login = login;
        Haslo = haslo;
    }
    public Odbiorca(Integer ID, String adnotacje, String imie_I_Nazwisko, String adres, String kod_Pocztowy, String miejscowosc, String login, String haslo) {
        this.ID = ID;
        Adnotacje = adnotacje;
        Imie_I_Nazwisko = imie_I_Nazwisko;
        Adres = adres;
        Kod_Pocztowy = kod_Pocztowy;
        Miejscowosc = miejscowosc;
        Login = login;
        Haslo = haslo;
    }


    //getters & setters
    public Integer getID() {
        return ID;
    }
    public void setID(Integer ID) {
        this.ID = ID;
    }
    public String getAdnotacje() {
        return Adnotacje;
    }
    public void setAdnotacje(String adnotacje) {
        Adnotacje = adnotacje;
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
}