package Model;

import java.util.ArrayList;
import java.util.List;

public class ListaPaczek {
    List<Przesylka> przesylki;

    public ListaPaczek(){
        przesylki = new ArrayList<>();
    }
    public ListaPaczek(List<Przesylka> przesylki) {
        this.przesylki = przesylki;
    }

    public List<Przesylka> getPrzesylki() {
        return przesylki;
    }

    public void setPrzesylki(List<Przesylka> przesylki) {
        this.przesylki = przesylki;
    }
}
