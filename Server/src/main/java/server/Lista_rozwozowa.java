package server;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class
public class Lista_rozwozowa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;

    private Date Data;

    private Integer Magazynier_ID;

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