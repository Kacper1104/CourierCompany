package Presenter;

import Model.Odbiorca;
import Model.Przesylka;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by Kacper on 12.01.2019.
 */
public class Package_New_Edit_Presenter {
    @FXML
    private ComboBox combo;

    @FXML
    private TextField imie_nazwisko_txt, ulica_txt, kod_txt, miejscowosc_txt, koszt_txt;




    @FXML
    public void initialize()
    {
        //trzeba tutaj podać dane z DeliveryCosts
        //najpierw utworzyć odbiorcę, a następnie go pobrać z bazy i zapisać jego id do paczki i paczkę zapisać w bazie


        ArrayList<String> test = new ArrayList<>();
        test.add("Opłacona");
        test.add("Za pobraniem");
        setDataToCombo(test);

    }

    private Odbiorca newRecipient()
    {
        String imie_i_nazwisko = imie_nazwisko_txt.getText();
        String adres = ulica_txt.getText();
        String kod = kod_txt.getText();
        String miejscowosc = miejscowosc_txt.getText();

        Odbiorca toReturn = new Odbiorca(imie_i_nazwisko, adres, kod, miejscowosc);

        return toReturn;
    }


    private void setDataToCombo(List<String> toLoad)
    {
        ObservableList<String> options = FXCollections.observableArrayList(toLoad);
        combo.setItems(options);
    }

    private Przesylka newPackage(int recipient_id)
    {
        double koszt = Double.parseDouble(koszt_txt.getText());

       LocalDate now_lc = LocalDate.now();
       Date now = new Date(now_lc.getYear(), now_lc.getMonth().getValue(), now_lc.getDayOfMonth());

        Przesylka toReturn = new Przesylka("nadana", getSelectedItem(), koszt, now, now, recipient_id);

        return toReturn;
    }

    private boolean checkFormatOfCode(String code)
    {
        return code.matches("\\d{2}-\\d{3}");
    }

    private boolean checkFormatOfCena(String cena)
    {
        String decimalPattern = "([0-9]*)\\.([0-9]*)";
        return Pattern.matches(decimalPattern, cena);
    }
    private String getSelectedItem()
    {
        return combo.getSelectionModel().getSelectedItem().toString();
    }

    @FXML
    private void onOkButtonClicked() throws IOException {
        //if wszystkie pola są wypełnione
        if (!(imie_nazwisko_txt.getText().trim().isEmpty() || ulica_txt.getText().trim().isEmpty() ||
                kod_txt.getText().trim().isEmpty() || miejscowosc_txt.getText().trim().isEmpty() || koszt_txt.getText().trim().isEmpty() || combo.getSelectionModel().isEmpty()))
        {
            if (! checkFormatOfCode(kod_txt.getText()))
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle(null);
                alert.setHeaderText(null);
                alert.setContentText("Zły format kodu");
                alert.showAndWait();
            }
            else if (! checkFormatOfCena(koszt_txt.getText()))
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle(null);
                alert.setHeaderText(null);
                alert.setContentText("Zły format kwoty pieniędzy");
                alert.showAndWait();
            }
            else
            {
                //wpisz odbiorcę do bazy, pobierz wygenerowane id
                 Odbiorca odbiorca = newRecipient();
                //utwórz paczkę z id odbiorcy
                newPackage(odbiorca.getID());
                //to do
                //dodaj do bazy paczke


                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(null);
                alert.setHeaderText(null);
                alert.setContentText("Dodano nową paczkę");
                alert.showAndWait();

                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/View.fxml"));
                Stage stage = (Stage) combo.getScene().getWindow();
                stage.setScene(new Scene(root));


            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText("Niektóre wymagane pola są puste!");
            alert.showAndWait();
        }


    }

    @FXML
    private void onAnulujButtonClicked() throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/View.fxml"));
        Stage stage = (Stage) combo.getScene().getWindow();
        stage.setScene(new Scene(root));
    }


}
