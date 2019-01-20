package Presenter;

import Model.Recipient;
import Model.Sender;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class Package_Return_Presenter {


    private Sender nadawca;
    private Recipient odbiorca;
    private Package paczka;
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
        nadawca = findSender(id);
        odbiorca = findRecpient(id);
        paczka  = findPackage(id);

        setContent();
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

        zmienStatusPaczki();

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/View.fxml"));
        Stage stage = (Stage) ok_btn.getScene().getWindow();
        stage.setScene(new Scene(root));
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

    private Package findPackage(int id)
    {

        // to do
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
        imie_i_naz_od_przed.setText(odbiorca.getImie_i_nazwisko());
        ulica_od_przed.setText(odbiorca.getAdres());
        kod_odb_przed.setText(odbiorca.getKod_pocztowy());
        miejscowosc_od_przed.setText(odbiorca.getMiejscowosc());
    }

    private void setNadawcaPrzed()
    {
        imie_i_naz_nad_przed.setText(nadawca.getImie_i_nazwisko());
        ulica_nad_przed.setText(nadawca.getAdres());
        kod_nad_przed.setText(nadawca.getKod_pocztowy());
        miejscowosc_nad_przed.setText(nadawca.getMiejscowosc());
    }

    private void setOdbiorcaPo()
    {
        imie_i_naz_od_po.setText(nadawca.getImie_i_nazwisko());
        ulica_od_po.setText(nadawca.getAdres());
        kod_odb_po.setText(nadawca.getKod_pocztowy());
        miejscowosc_od_po.setText(nadawca.getMiejscowosc());
    }

    private void setNadawcaPo()
    {
        imie_i_naz_od_po.setText(odbiorca.getImie_i_nazwisko());
        ulica_od_po.setText(odbiorca.getAdres());
        kod_odb_po.setText(odbiorca.getKod_pocztowy());
        miejscowosc_od_po.setText(odbiorca.getMiejscowosc());
    }

    private void setStatusy()
    {
        //do odkomentowania po implemetacji pozostałych metod
        //status_przed.setText(paczka.getStatus_przesylki());
        status_po.setText("Zwrot");
    }

    private void zmienStatusPaczki()
    {
        // to do
    }



}
