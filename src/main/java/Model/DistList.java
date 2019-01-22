package Model;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.util.Date;
import java.util.List;

/**
 * Created by Kacper on 12.01.2019.
 */
public class DistList {
    private Integer id;
    private Date data;
    private WarehouseKeeper magazynier_id;
    private Courier courier;
    private List<Package> przesylki;

    public DistList(Integer id, Date data, WarehouseKeeper magazynier_id, Courier courier, List<Package>przesylki) {
        this.id = id;
        this.data = data;
        this.magazynier_id = magazynier_id;
        this.courier=courier;
        this.przesylki = przesylki;
    }
    public DistList(Date data, WarehouseKeeper magazynier_id, Courier courier, List<Package>przesylki) {
        this.data = data;
        this.magazynier_id = magazynier_id;
        this.courier=courier;
        this.przesylki = przesylki;
    }




    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public Courier getCourier() {
        return courier;
    }
    public void setCourier(Courier courier) {
        this.courier = courier;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public List<Package> getPrzesylki() {
        return przesylki;
    }
    public void setPrzesylki(List<Package> przesylki) {
        this.przesylki = przesylki;
    }
    public void setMagazyniej_id(WarehouseKeeper magazyniej_id) {
        this.magazynier_id = magazyniej_id;
    }
    public WarehouseKeeper getMagazyniej_id() {
        return magazynier_id;
    }
}
