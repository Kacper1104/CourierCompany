package Presenter;

import Model.Courier;
import Model.Package;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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

    private List<Package> listaPaczekDoRozwiezienia;
    private List<Package> paczkiNaLiscieRozwozowej = new ArrayList<>();
    private List<Courier> listaKurierow;



    @FXML
    public void initialize()
    {
        //setKurierzy();
        setPaczkiDoRozwiezienia();

        do_rozwiezienia_listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        na_liscie_listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }

    @FXML
    private void onButtonLeftClicked()
    {
        ObservableList<String> choosed = do_rozwiezienia_listView.getSelectionModel().getSelectedItems();

        for (String s: choosed)
        {
            int id = Integer.parseInt( s.substring(17,s.length()));
            Package p = null;
            boolean znaleziono = false;

            for (int i=0; i< listaPaczekDoRozwiezienia.size() && !znaleziono; i++)
            {
                if (listaPaczekDoRozwiezienia.get(i).getId() == id)
                {
                    p = listaPaczekDoRozwiezienia.remove(i);
                    znaleziono = true;
                }
            }
            paczkiNaLiscieRozwozowej.add(p);
        }
        setNaLiscieListview();
        aktualizujPaczkiDoRozwiezienia();

    }

    private void setNaLiscieListview()
    {
        ObservableList<String> items = FXCollections.observableArrayList();

        for (Package p: paczkiNaLiscieRozwozowej)
        {
            items.add("Przesylka numer: " + p.getId());
        }

        na_liscie_listView.setItems(items);
    }


    @FXML
    private void onButtonRightClicked()
    {
        ObservableList<String> choosed = na_liscie_listView.getSelectionModel().getSelectedItems();

        for (String s: choosed)
        {
            int id = Integer.parseInt( s.substring(17,s.length()));
            Package p = null;
            boolean znaleziono = false;

            for (int i=0; i< paczkiNaLiscieRozwozowej.size() && !znaleziono; i++)
            {
                if (paczkiNaLiscieRozwozowej.get(i).getId() == id)
                {
                    p = paczkiNaLiscieRozwozowej.remove(i);
                    znaleziono = true;
                }
            }
            listaPaczekDoRozwiezienia.add(p);
        }
        setNaLiscieListview();
        aktualizujPaczkiDoRozwiezienia();

    }



    @FXML
    private void onOkButtonClicked()
    {

    }

    @FXML
    private void onAnulujButtonClicked()
    {

    }

    private void listOfCourier()
    {
        // to do
        // dodaj do listKurierow
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
    }

    private void setKurierzy()
    {
        listOfCourier();
        ObservableList<String> options = FXCollections.observableArrayList();
        for (Courier c: listaKurierow)
        {
            options.add(c.getImie_i_nazwisko());
        }

        kurierzy_combo_box.setItems(options);
    }


    private void listOfPackages()
    {
        // jesli są paczki to daj saPaczki na true
        // to do
        //////////////////wersja robocza
        listaPaczekDoRozwiezienia = new ArrayList<>();
        for (int i=0; i<5; i++)
        {
            listaPaczekDoRozwiezienia.add(new Package(i));
        }

        saPaczki = true;
        /////////////////////////////

        if(!saPaczki)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText("Brak paczek do rozwiezienia");
            alert.showAndWait();

            onAnulujButtonClicked();
        }
    }

    private void setPaczkiDoRozwiezienia()
    {
        listOfPackages();
        ObservableList<String> items = FXCollections.observableArrayList();

        for (Package p: listaPaczekDoRozwiezienia)
        {
            items.add("Przesylka numer: " + p.getId());
        }

        do_rozwiezienia_listView.setItems(items);
    }

    private void aktualizujPaczkiDoRozwiezienia()
    {
        ObservableList<String> items = FXCollections.observableArrayList();

        for (Package p: listaPaczekDoRozwiezienia)
        {
            items.add("Przesylka numer: " + p.getId());
        }

        do_rozwiezienia_listView.setItems(items);
    }





}
