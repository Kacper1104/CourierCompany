package Model;

import java.util.ArrayList;
import java.util.List;

public class KurierList {
    List<Kurier> kuriery;

    public KurierList(){
        kuriery = new ArrayList<>();
    }
    public KurierList(List<Kurier> kuriery) {
        this.kuriery = kuriery;
    }

    public List<Kurier> getKuriery() {
        return kuriery;
    }

    public void setKuriery(List<Kurier> kuriery) {
        this.kuriery = kuriery;
    }
}
