package View;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Paint;

/**
 * Created by Kacper on 09.01.2019.
 */
public class View {
    public Group group;
    public Scene scene;
    public Paint color;
    public String title;

    public View(){};

    public void setColor(Paint color){
        this.color = color;
        this.scene.setFill(color);
    }
    public void setTitle(String title){
        this.title = title;
    }
}
