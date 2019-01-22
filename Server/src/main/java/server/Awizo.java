package server;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class
public class Awizo{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer ID;

    private Date Data_zostawienia;

    private Integer Przesylka_ID;

    public Integer getId() {
        return ID;
    }

    public void setId(Integer ID) {
        this.ID = ID;
    }

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
}
