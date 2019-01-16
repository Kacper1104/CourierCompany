package Model;

import java.util.Date;

/**
 * Created by Kacper on 12.01.2019.
 */
public class Advice {
    private int id;
    private Date data_zostawienia;
    private int przesylka_id;

    public Advice(int id, Date data_zostawienia, int przesylka_id) {
        this.id = id;
        this.data_zostawienia = data_zostawienia;
        this.przesylka_id = przesylka_id;
    }
}
