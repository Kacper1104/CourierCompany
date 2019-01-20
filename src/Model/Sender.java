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
}
