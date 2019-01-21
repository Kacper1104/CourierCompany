package Presenter;

import Model.Package;
import Model.Recipient;
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
        //najpierw utworzyć odbiorcę, a następnie go pobrać z bazy i zapisać jego id do paczki i paczkę zapisać w bazie


        ArrayList<String> test = new ArrayList<>();
        test.add("aaa");
        test.add("Bbb");
        setDataToCombo(test);

    }

    private Recipient newRecipient()
    {
        String imie_i_nazwisko = imie_nazwisko_txt.getText();
        String adres = ulica_txt.getText();
        String kod = kod_txt.getText();
        String miejscowosc = miejscowosc_txt.getText();

        Recipient toReturn = new Recipient(imie_i_nazwisko, adres, kod, miejscowosc);

        return toReturn;
    }


    private void setDataToCombo(List<String> toLoad)
    {
        ObservableList<String> options = FXCollections.observableArrayList(toLoad);
        combo.setItems(options);
    }

    private Package newPackage(int recipient_id)
    {
        BigDecimal koszt = new BigDecimal(koszt_txt.getText());

       LocalDate now = LocalDate.now();

        Package toReturn = new Package("nadana", getSelectedItem(), koszt, now, now, recipient_id);

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

}
