package Model;

import java.util.ArrayList;
import java.util.List;

public class AwizoList {
    List<Awizo> awiza;

    public AwizoList(){
        awiza = new ArrayList<>();
    }
    public AwizoList(List<Awizo> awiza) {
        this.awiza = awiza;
    }

    public List<Awizo> getPrzesylki() {
        return awiza;
    }

    public void setAwiza(List<Awizo> awiza) {
        this.awiza = awiza;
    }
}
