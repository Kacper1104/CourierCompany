package Model;

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


    public Recipient(int id, String adnotacje, String imie_i_nazwisko, String adres, String kod_pocztowy, String miejscowosc, String login, String haslo) {
        this.id = id;
        this.adnotacje = adnotacje;
        this.imie_i_nazwisko = imie_i_nazwisko;
        this.adres = adres;
        this.kod_pocztowy = kod_pocztowy;
        this.miejscowosc = miejscowosc;
        this.login = login;
        this.haslo = haslo;
    }

    public Recipient() {

    }
}
