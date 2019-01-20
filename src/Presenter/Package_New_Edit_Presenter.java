package Presenter;

import Model.Package;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

        ArrayList<String> test = new ArrayList<>();
        test.add("aaa");
        test.add("Bbb");
        setDataToCombo(test);
    }

    public void setDataToCombo(List<String> toLoad)
    {
        ObservableList<String> options = FXCollections.observableArrayList(toLoad);
        combo.setItems(options);
    }

    public Package newPackage()
    {
        Package toReturn;
        String imie_i_nazwisko, ulica, kod, miejscowosc, cena;

        imie_i_nazwisko = imie_nazwisko_txt.getText();
        ulica = ulica_txt.getText();
        kod = kod_txt.getText();
        miejscowosc = miejscowosc_txt.getText();
        cena = koszt_txt.getText();

        //utworz nowa paczka

        return toReturn;
    }


}
