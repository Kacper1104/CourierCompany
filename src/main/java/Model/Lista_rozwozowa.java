package Model;

import java.util.Date;


public class Lista_rozwozowa {
    private Integer ID;
    private Date Data;
    //fk
    private Integer Magazynier_ID;


    //constructors
    public Lista_rozwozowa() {
    }
    public Lista_rozwozowa(Integer ID, Date data, Integer Magazynier_ID) {
        this.ID = ID;
        Data = data;
        Magazynier_ID = Magazynier_ID;
    }
    public Lista_rozwozowa(Date data, Magazynier Magazynier_ID) {
        Data = data;
        Magazynier_ID = Magazynier_ID;
    }


    //getters & setters
    public Integer getID() {
        return ID;
    }
    public void setID(Integer ID) {
        this.ID = ID;
    }
    public Date getData() {
        return Data;
    }
    public void setData(Date data) {
        Data = data;
    }
    public Integer getMagazynier_ID() {
        return Magazynier_ID;
    }
    public void setMagazynier_ID(Integer magazynier_ID) {
        Magazynier_ID = magazynier_ID;
    }
}
