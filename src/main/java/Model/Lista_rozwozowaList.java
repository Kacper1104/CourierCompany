package Model;
import java.util.ArrayList;
import java.util.List;

public class Lista_rozwozowaList {
    List<Lista_rozwozowa> listy;

    public Lista_rozwozowaList(){
        listy = new ArrayList<>();
    }
    public Lista_rozwozowaList(List<Lista_rozwozowa> listy) {
        this.listy = listy;
    }

    public List<Lista_rozwozowa> getListy() {
        return listy;
    }

    public void setListy(List<Lista_rozwozowa> listy) {
        this.listy = listy;
    }
}
