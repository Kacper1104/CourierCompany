package Presenter;

import Model.Package;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        //sprawdz czy są paczki i czy są kurierzy

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


        String statusPrzesylki = "nadana";
        String opcja_dostawy = "oplacona";
        cena = koszt_txt.getText();
        LocalDate dataNadania = LocalDate.now();
        boolean na_liscie = false;
        int probaDostarczenia = 0;
        //data nadania
        imie_i_nazwisko = imie_nazwisko_txt.getText();
        ulica = ulica_txt.getText();
        kod = kod_txt.getText();
        miejscowosc = miejscowosc_txt.getText();

        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

//        String status_przesylki, String opcja_dostawy, BigDecimal koszt_do_zaplaty, LocalDate data_nadania,
//        boolean na_liscie_rozwozowej, int proba_dostarczenia, LocalDate ostatnia_zmiana_statusu, int nadawca_id, int odbiorca_id)
//


        return null;
    }

    private boolean checkFormatOfCode(String code)
    {
        return code.matches("\\d{2}-\\d{3}");
    }

    private boolean checkCena(String cena)
    {
        String decimalPattern = "([0-9]*)\\.([0-9]*)";
        return Pattern.matches(decimalPattern, cena);
    }


}
