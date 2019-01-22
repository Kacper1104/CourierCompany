package Presenter;

import Model.Courier;
import Model.DistList;
import Model.Package;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.Normalizer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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

    private DistList listaRozwozowa;

    private Courier wybranyKurier;

    @FXML
    public void initialize()
    {
        setKurierzy();
        setPaczkiDoRozwiezienia();

        do_rozwiezienia_listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        na_liscie_listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}

	private void utworzListeRozwozowa()
    {
        wybranyKurier = getSelectedCourier();
        LocalDate date = LocalDate.now();
        Date dd = new Date(date.getYear(), date.getMonthValue(), date.getDayOfMonth());

        listaRozwozowa = new DistList(dd,null, wybranyKurier, paczkiNaLiscieRozwozowej);
    }

    private void ustawPaczkaListeRozwozowa()
    {
        for (Package p: paczkiNaLiscieRozwozowej)
        {
            p.setLista_rozwozowa_id(listaRozwozowa);
            p.setNa_liscie_rozwozowej(true);
        }
    }

    private void przypiszKurierowiListe()
    {
        getSelectedCourier().setLista_rozwozowa(listaRozwozowa);
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
        if (!saPaczkiNaLiscieRozwozowej())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText("Brak paczek na liście rozwozowej!");
            alert.showAndWait();
        }
        else if (! isSelectedCourier())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText("Brak wybranego kuriera!");
            alert.showAndWait();
        }
        else
        {

            utworzListeRozwozowa();
            ustawPaczkaListeRozwozowa();
            przypiszKurierowiListe();

            //
            //wysłać postem wybrany kurier, liste rozwozowa, paczki do zmiany
            //




            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText("Utworzono nową listę");
            alert.showAndWait();
        }
    }

    @FXML
    private void onAnulujButtonClicked()
    {

    }

    private void listOfCourier()
    {
        listaKurierow=CourierREST_GET();
        for(Courier iterator: listaKurierow){
            if(iterator.getLista_rozwozowa() != null){
                listaKurierow.remove(iterator);
            }
        }
        if(listaKurierow.isEmpty())
            saKurierzy = false;


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

        listaPaczekDoRozwiezienia = PackageREST_GET();
        for(Package iterator: listaPaczekDoRozwiezienia){
            if(iterator.getLista_rozwozowa_id() != null){
                listaPaczekDoRozwiezienia.remove(iterator);
            }
        }
        if(listaPaczekDoRozwiezienia.isEmpty())
            saPaczki = false;


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

    private List<Courier> CourierREST_GET(){
        RestTemplate restTemplate = new RestTemplate();
        List<Courier> couriers = restTemplate.getForObject("http://localhost:8080/rest/kurier", List.class);
        return couriers;
    }
    private List<Package> PackageREST_GET(){
        RestTemplate restTemplate = new RestTemplate();
        List<Package> packages = restTemplate.getForObject("http://localhost:8080/rest/paczka", List.class);
        return packages;
    }

    private Courier getSelectedCourier()
    {
        Courier toReturn = null;


        String k;
        k = kurierzy_combo_box.getSelectionModel().getSelectedItem().toString();

        for (Courier c: listaKurierow)
        {
            if (c.getImie_i_nazwisko().equals(k))
                toReturn = c;
        }
        return toReturn;
    }

    private boolean isSelectedCourier()
    {
        return !kurierzy_combo_box.getSelectionModel().isEmpty();
    }

    private boolean saPaczkiNaLiscieRozwozowej()
    {
        return paczkiNaLiscieRozwozowej.size() !=0;
    }



}
