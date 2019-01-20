package Presenter;

import Model.Courier;
import Model.Package;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
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

    @FXML
    public void initialize()
    {
        setKurierzy(listOfCourier());
        setPaczkiDoRozwiezienia();
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

        return null;
    }

    private void setKurierzy(List<Courier> kurierzy)
    {
        List<String> toInsert = new ArrayList<>();
        for (Courier c: kurierzy)
        {
            toInsert.add(c.getLogin() + " " );
        }

        ObservableList<String> options = FXCollections.observableArrayList(toInsert);
        kurierzy_combo_box.setItems(options);
    }

    private List<Package> listOfPackages()
    {
        // to do

        return null;
    }

    private void setPaczkiDoRozwiezienia()
    {
        List<Package> paczki = listOfPackages();
        ObservableList<String> items = FXCollections.observableArrayList();

        for (Package p: paczki)
        {
            items.add("ID: " + p.getId());
        }

        do_rozwiezienia_listView.setItems(items);
    }


}
