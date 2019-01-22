package Model;

import java.io.Serializable;
import java.util.Date;


public class Awizo {
    private Integer ID;
    private Date Data_zostawienia;
    private Przesylka Przesylka_ID;

    public Awizo(){};
    public Awizo(Integer ID, Date data_zostawienia, Przesylka przesylka_ID) {
        this.ID = ID;
        Data_zostawienia = data_zostawienia;
        Przesylka_ID = przesylka_ID;
    }

    //getters & setters
    public Date getData_zostawienia() {
        return Data_zostawienia;
    }
    public void setData_zostawienia(Date Data_zostawienia) {
        this.Data_zostawienia = Data_zostawienia;
    }
    public Przesylka getPrzesylka_ID() {
        return Przesylka_ID;
    }
    public void setPrzesylka_ID(Przesylka Przesylka_ID) {
        this.Przesylka_ID = Przesylka_ID;
    }
    public void setID(Integer ID) {
        this.ID = ID;
    }
    public Integer getID() {
        return ID;
    }
}
