package Model;

import java.util.Date;


public class Awizo {
    private Integer ID;
    private Date Data_zostawienia;
    private Integer Przesylka_ID;

    //constructors
    public Awizo(Integer ID, Date data_zostawienia, Integer przesylka_ID) {
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
    public Integer getPrzesylka_ID() {
        return Przesylka_ID;
    }
    public void setPrzesylka_ID(Integer Przesylka_ID) {
        this.Przesylka_ID = Przesylka_ID;
    }
    public void setID(Integer ID) {
        this.ID = ID;
    }
    public Integer getID() {
        return ID;
    }
}
