package Presenter;

import Model.Nadawca;
import Model.Odbiorca;
import Model.Przesylka;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Package_Return_Presenter {


    private Nadawca nadawca;
    private Odbiorca odbiorca;
    private Przesylka paczka;
    private int id;

    @FXML
    Button ok_btn, anuluj_btn;

    @FXML
    Label imie_i_naz_nad_przed, ulica_nad_przed, kod_nad_przed, miejscowosc_nad_przed, imie_i_naz_nad_po,
            ulica_nad_po, kod_nad_po, miejscowosc_nad_po, imie_i_naz_od_przed, ulica_od_przed,  kod_odb_przed,
            miejscowosc_od_przed, imie_i_naz_od_po, ulica_od_po, kod_odb_po, miejscowosc_od_po, status_przed, status_po;


    @FXML
    public void initialize()
    {
        id = ReturnOfPackage_Presenter.package_id_to_return;
        paczka  = findPackage(id);

        nadawca = findSender(id);
        odbiorca = findRecpient(id);

        //setContent();
    }

    @FXML
    private void onClickOkButton() throws IOException {

        zmienStatusPaczki();

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/View.fxml"));
        Stage stage = (Stage) ok_btn.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    private void onClickAnulujButton() throws IOException {

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/View.fxml"));
        Stage stage = (Stage) ok_btn.getScene().getWindow();
        stage.setScene(new Scene(root));
    }



    private Nadawca findSender(int id)
    {
        //return paczka.getNadawca_ID();
        return null;
    }

    private Odbiorca findRecpient(int id)
    {
        //return paczka.getOdbiorca_ID();
        return null;
    }

    private Przesylka findPackage(int id)
    {

        RestTemplate restTemplate = new RestTemplate();
        String packages = restTemplate.getForObject("http://localhost:8080/rest/przesylka", String.class);

        ObjectMapper objectMapper = new ObjectMapper();

        List<Przesylka> items = new ArrayList<>();

        try {
            items = objectMapper.readValue(
                    packages,
                    objectMapper.getTypeFactory().constructParametricType(List.class, Przesylka.class));


        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Przesylka p: items)
            if (p.getID() == id)
            {
                return p;
            }

        return null;
    }

    private void setContent()
    {
        setOdbiorcaPrzed();
        setNadawcaPrzed();
        setNadawcaPo();
        setOdbiorcaPo();
        setStatusy();
    }

    private void setOdbiorcaPrzed()
    {
        imie_i_naz_od_przed.setText(odbiorca.getImie_I_Nazwisko());
        ulica_od_przed.setText(odbiorca.getAdres());
        kod_odb_przed.setText(odbiorca.getKod_Pocztowy());
        miejscowosc_od_przed.setText(odbiorca.getMiejscowosc());
    }

    private void setNadawcaPrzed()
    {
        imie_i_naz_nad_przed.setText(nadawca.getImie_I_Nazwisko());
        ulica_nad_przed.setText(nadawca.getAdres());
        kod_nad_przed.setText(nadawca.getKod_Pocztowy());
        miejscowosc_nad_przed.setText(nadawca.getMiejscowosc());
    }

    private void setOdbiorcaPo()
    {
        imie_i_naz_od_po.setText(nadawca.getImie_I_Nazwisko());
        ulica_od_po.setText(nadawca.getAdres());
        kod_odb_po.setText(nadawca.getKod_Pocztowy());
        miejscowosc_od_po.setText(nadawca.getMiejscowosc());
    }

    private void setNadawcaPo()
    {
        imie_i_naz_od_po.setText(odbiorca.getImie_I_Nazwisko());
        ulica_od_po.setText(odbiorca.getAdres());
        kod_odb_po.setText(odbiorca.getKod_Pocztowy());
        miejscowosc_od_po.setText(odbiorca.getMiejscowosc());
    }

    private void setStatusy()
    {
        //do odkomentowania po implementacji
        status_przed.setText(paczka.getStatus_przesylki());
        status_po.setText("Zwrot");
    }

    private boolean udaloSieZmienic = true;

    private void zmienStatusPaczki()
    {
        // to do wyslac na serwer zmodyfikowana przesylke

        if(udaloSieZmienic)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText("Pomyślnie dokonano zmian");
            alert.showAndWait();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText("Wystąpił błąd, nie udało się dokonać zmian");
            alert.showAndWait();

        }

    }
}
