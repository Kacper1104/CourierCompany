package Model;

import java.util.Date;

/**
 * Created by Kacper on 12.01.2019.
 */
public class Advice {
    private int id;
    private Date data_zostawienia;
    private Package przesylka_id;

    public Advice(int id, Date data_zostawienia, Package przesylka_id) {
        this.id = id;
        this.data_zostawienia = data_zostawienia;
        this.przesylka_id = przesylka_id;
    }

    public Date getData_zostawienia() {
        return data_zostawienia;
    }

    public void setData_zostawienia(Date data_zostawienia) {
        this.data_zostawienia = data_zostawienia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Package getPrzesylka_id() {
        return przesylka_id;
    }

    public void setPrzesylka_id(Package przesylka_id) {
        this.przesylka_id = przesylka_id;
    }
}
