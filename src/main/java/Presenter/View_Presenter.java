<<<<<<< HEAD
package Presenter;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Kacper on 12.01.2019.
 */
public class View_Presenter extends Application {


    @FXML
    Button wprowadz_przesylke_btn, utworz_liste_rozwozowa_btn, nadaj_przesylke_zwrotna_btn;

    @FXML
    javafx.scene.image.ImageView koerta_imageView;


    @FXML
    public void wprowadzPrzesylkeDoSystemuClicked() throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/Package_NewEdit.fxml"));
        Stage stage = (Stage) wprowadz_przesylke_btn.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    public void utworzListeRozwozowaClicked() throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/DistList_New.fxml"));
        Stage stage = (Stage) utworz_liste_rozwozowa_btn.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    public void nadajPrzesylkeZwrotnaClicked() throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/ReturnOfPackage/ID_Choice.fxml"));
        Stage stage = (Stage) nadaj_przesylke_zwrotna_btn.getScene().getWindow();
        stage.setScene(new Scene(root));
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        //I'll try it
        //URL url = new File("View/View.fxml").toURL();
        //Parent root = FXMLLoader.load(url);
        //Not working
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("/View/View.fxml"));
        primaryStage.setTitle("Aplikacja kurierska");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }

}
=======
package Presenter;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Kacper on 12.01.2019.
 */
public class View_Presenter extends Application {


    @FXML
    Button wprowadz_przesylke_btn, utworz_liste_rozwozowa_btn, nadaj_przesylke_zwrotna_btn;

    @FXML
    javafx.scene.image.ImageView koerta_imageView;


    @FXML
    public void wprowadzPrzesylkeDoSystemuClicked() throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/Package_NewEdit.fxml"));
        Stage stage = (Stage) wprowadz_przesylke_btn.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    public void utworzListeRozwozowaClicked() throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/DistList_New.fxml"));
        Stage stage = (Stage) utworz_liste_rozwozowa_btn.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    public void nadajPrzesylkeZwrotnaClicked() throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/ReturnOfPackage/ID_Choice.fxml"));
        Stage stage = (Stage) nadaj_przesylke_zwrotna_btn.getScene().getWindow();
        stage.setScene(new Scene(root));
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/View.fxml"));
        primaryStage.setTitle("Aplikacja kurierska");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }

}
>>>>>>> refs/remotes/origin/master
