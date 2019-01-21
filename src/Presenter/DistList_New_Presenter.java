package Presenter;

import Model.Courier;
import Model.Package;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kacper on 12.01.2019.
 */
public class DistList_New_Presenter {

    @FXML
    Button ok_btn, anuluj_btn, left_btn, right_btn;

    @FXML
    ListView do_rozwiezienia_listView, na_liscie_listView;

    @FXML
    ComboBox kurierzy_combo_box;

    private boolean saPaczki = false;
    private boolean saKurierzy = false;


    @FXML
    public void initialize()
    {
        //setKurierzy();
        //setPaczkiDoRozwiezienia();



    }

    @FXML
    private void onOkButtonClicked()
    {

    }

    @FXML
    private void onAnulujButtonClicked()
    {

    }

    private List<Courier> listOfCourier()
    {
        // to do
        //jesli znalazlo, to zmien saKurierzy na true

        if (!saKurierzy)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd kurierów");
            alert.setHeaderText(null);
            alert.setContentText("W tej chwili brak wolnych kurierów!");
            alert.showAndWait();

            onAnulujButtonClicked();
        }

        return null;
    }

    private void setKurierzy()
    {
        List<Courier> kurierzy = listOfCourier();
        ObservableList<String> options = FXCollections.observableArrayList();
        for (Courier c: kurierzy)
        {
            options.add(c.getImie_i_nazwisko());
        }

        kurierzy_combo_box.setItems(options);
    }

    private List<Package> listOfPackages()
    {
        // jesli są paczki to daj saPaczki na true
        // to do

        if(!saPaczki)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText("Brak paczek do rozwiezienia");
            alert.showAndWait();

            onAnulujButtonClicked();
        }
        return null;
    }

    private void setPaczkiDoRozwiezienia()
    {
        List<Package> paczki = listOfPackages();
        ObservableList<String> items = FXCollections.observableArrayList();

        for (Package p: paczki)
        {
            items.add("Przesylka numer: " + p.getId());
        }

        do_rozwiezienia_listView.setItems(items);
    }


}
