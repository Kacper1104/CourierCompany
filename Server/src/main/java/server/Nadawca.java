package server;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Nadawca {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;

    private Integer Numer_konta;

    private String Imie_I_Nazwisko;

    private String Adres;

    private String Kod_Pocztowy;

    private String Miejscowosc;

    private String Login;

    private String Haslo;

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
}