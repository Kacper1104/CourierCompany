package Model;

import java.util.Date;

/**
 * Created by Kacper on 12.01.2019.
 */
public class DistList {
    private int id;
    private Date data;
    private int magazyniej_id;

    public DistList(int id, Date data, int magazyniej_id) {
        this.id = id;
        this.data = data;
        this.magazyniej_id = magazyniej_id;
    }
}
