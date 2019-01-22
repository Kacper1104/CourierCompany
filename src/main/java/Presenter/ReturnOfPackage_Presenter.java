package Presenter;

import Model.Recipient;
import Model.Sender;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

/**
 * Created by Kacper on 12.01.2019.
 */
public class ReturnOfPackage_Presenter {

    @FXML
    Button wybierz_btn, powrot_btn;

    @FXML
    TextField identyfikator_txt;




    boolean okId = false;
    static int package_id_to_return;


    @FXML
    public void onClickWybierz() throws IOException {

        int id = checkId(identyfikator_txt.getText());

        if (existInBase(id) && okId)
        {
            package_id_to_return = id;



            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/ReturnOfPackage/Package_Return.fxml"));
            Stage stage = (Stage) wybierz_btn.getScene().getWindow();
            stage.setScene(new Scene(root));
        }
        else
        {
            if (okId)
                showAlert();
        }
    }

    @FXML
    private void onClickPowrot() throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/View.fxml"));
        Stage stage = (Stage) wybierz_btn.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    private void showAlert()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Błąd");
        alert.setHeaderText(null);
        alert.setContentText("Podany identyfikator nie istnieje w bazie");

        alert.showAndWait();
    }

    public int checkId(String id)
    {
        int toReturn;
        try
        {
            toReturn = Integer.parseInt(id);
            okId = true;
            return toReturn;
        }
        catch (Exception e)
        {
            okId = false;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Błąd");
            alert.setHeaderText(null);
            alert.setContentText("Niepoprawny identyfikator");

            alert.showAndWait();
        }
        return -1;
    }

    public boolean existInBase(int id)
    {
        //TO DO

        return true;
    }





}
