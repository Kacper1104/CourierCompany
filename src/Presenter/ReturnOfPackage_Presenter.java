package Presenter;

import Model.Recipient;
import Model.Sender;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Kacper on 12.01.2019.
 */
public class ReturnOfPackage_Presenter {

    @FXML
    Button wybierz_btn;

    @FXML
    TextField identyfikator_txt;

    static int package_id_to_return;
    private Sender nadawca;
    private Recipient odbiorca;

    @FXML
    public void onClickWybierz() throws IOException {

        int id = checkId(identyfikator_txt.getText());

        if (existInBase(id))
        {
            package_id_to_return = id;
            nadawca = findSender(id);
            odbiorca = findRecpient(id);


            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/ReturnOfPackage/Package_Return.fxml"));
            Stage stage = (Stage) wybierz_btn.getScene().getWindow();
            stage.setScene(new Scene(root));
        }
        else
        {
            //okno o niepoprawności
        }
    }

    public int checkId(String id)
    {
        int toReturn;
        try
        {
            toReturn = Integer.parseInt(id);
            return toReturn;
        }
        catch (Exception e)
        {
            //pokaż okno o niepoprawności
        }
        return -1;
    }

    public boolean existInBase(int id)
    {
        //TO DO

        return true;
    }


    private Sender findSender(int id)
    {
        //to do
        return new Sender();
    }

    private Recipient findRecpient(int id)
    {
        //to do
        return new Recipient();
    }


}
