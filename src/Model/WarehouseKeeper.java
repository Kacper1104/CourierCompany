package Model;

/**
 * Created by Kacper on 12.01.2019.
 */
public class WarehouseKeeper {
    private int id;
    private String login;
    private String haslo;
    private String imie_i_nazwisko;

    public WarehouseKeeper(int id, String login, String haslo, String imie_i_nazwisko)
    {
        this.id = id;
        this.login = login;
        this.haslo = haslo;
        this.imie_i_nazwisko = imie_i_nazwisko;
    }
}
