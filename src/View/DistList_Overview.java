package View;


import javafx.scene.Group;
import javafx.scene.Scene;

/**
 * Created by Kacper on 09.01.2019.
 */
public class DistList_Overview extends View{

    public DistList_Overview(int w, int h){
        super.group = new Group();
        super.scene= new Scene(group, w, h);
    }

}
