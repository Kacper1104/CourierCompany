package Model;

import java.util.ArrayList;
import java.util.List;

public class PrzesylkaList {
    List<Przesylka> przesylki;

    public PrzesylkaList(){
        przesylki = new ArrayList<>();
    }
    public PrzesylkaList(List<Przesylka> przesylki) {
        this.przesylki = przesylki;
    }

    public List<Przesylka> getPrzesylki() {
        return przesylki;
    }

    public void setPrzesylki(List<Przesylka> przesylki) {
        this.przesylki = przesylki;
    }
}
