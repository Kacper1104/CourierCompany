package Model;

/**
 * Created by Kacper on 12.01.2019.
 */
public class Sender {

    private int id;
    private int nr_konta;
    private String imie_i_nazwisko;
    private String adres;
    private String kod_pocztowy;
    private String miejscowosc;
    private String login;
    private String haslo;

    public Sender(int id, int nr_konta, String imie_i_nazwisko, String adres, String kod_pocztowy, String miejscowosc, String login, String haslo)
    {
        this.id = id;
        this.nr_konta = nr_konta;
        this.imie_i_nazwisko = imie_i_nazwisko;
        this.adres = adres;
        this.kod_pocztowy = kod_pocztowy;
        this.miejscowosc = miejscowosc;
        this.login = login;
        this.haslo = haslo;
    }

    public Sender() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNr_konta() {
        return nr_konta;
    }

    public void setNr_konta(int nr_konta) {
        this.nr_konta = nr_konta;
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
