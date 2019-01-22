package Presenter;

import Model.Kurier;
import Model.Lista_rozwozowa;
import Model.Przesylka;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.springframework.web.client.RestTemplate;

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

    private List<Przesylka> listaPaczekDoRozwiezienia;
    private List<Przesylka> paczkiNaLiscieRozwozowej = new ArrayList<>();
    private List<Kurier> listaKurierow;

    private Lista_rozwozowa listaRozwozowa;

    private Kurier wybranyKurier;

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

        listaRozwozowa = new Lista_rozwozowa(dd,null, wybranyKurier, paczkiNaLiscieRozwozowej);
    }

    private void ustawPaczkaListeRozwozowa()
    {
        for (Przesylka p: paczkiNaLiscieRozwozowej)
        {
            p.setLista_rozwozowa_ID(listaRozwozowa);
            p.setNa_liscie_rozwozowej(true);
        }
    }

    private void przypiszKurierowiListe()
    {
        getSelectedCourier().setLista_rozwozowa_ID(listaRozwozowa);
    }


    @FXML
    private void onButtonLeftClicked()
    {
        ObservableList<String> choosed = do_rozwiezienia_listView.getSelectionModel().getSelectedItems();

        for (String s: choosed)
        {
            int id = Integer.parseInt( s.substring(17,s.length()));
            Przesylka p = null;
            boolean znaleziono = false;

            for (int i=0; i< listaPaczekDoRozwiezienia.size() && !znaleziono; i++)
            {
                if (listaPaczekDoRozwiezienia.get(i).getID() == id)
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

        for (Przesylka p: paczkiNaLiscieRozwozowej)
        {
            items.add("Przesylka numer: " + p.getID());
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
            Przesylka p = null;
            boolean znaleziono = false;

            for (int i=0; i< paczkiNaLiscieRozwozowej.size() && !znaleziono; i++)
            {
                if (paczkiNaLiscieRozwozowej.get(i).getID() == id)
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
        for(Kurier iterator: listaKurierow){
            if(iterator.getLista_rozwozowa_ID() != null){
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
        for (Kurier c: listaKurierow)
        {
            options.add(c.getImie_I_Nazwisko());
        }

        kurierzy_combo_box.setItems(options);
    }


    private void listOfPackages()
    {

        listaPaczekDoRozwiezienia = PackageREST_GET();
        for(Przesylka iterator: listaPaczekDoRozwiezienia){
            if(iterator.getLista_rozwozowa_ID() != null){
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

        for (Przesylka p: listaPaczekDoRozwiezienia)
        {
            items.add("Przesylka numer: " + p.getID());
        }

        do_rozwiezienia_listView.setItems(items);
    }

    private void aktualizujPaczkiDoRozwiezienia()
    {
        ObservableList<String> items = FXCollections.observableArrayList();

        for (Przesylka p: listaPaczekDoRozwiezienia)
        {
            items.add("Przesylka numer: " + p.getID());
        }

        do_rozwiezienia_listView.setItems(items);
    }

    private List<Kurier> CourierREST_GET(){
        RestTemplate restTemplate = new RestTemplate();
        List<Kurier> couriers = restTemplate.getForObject("http://localhost:8080/rest/kurier", List.class);
        return couriers;
    }
    private List<Przesylka> PackageREST_GET(){
        RestTemplate restTemplate = new RestTemplate();
        List<Przesylka> packages = restTemplate.getForObject("http://localhost:8080/rest/paczka", List.class);
        return packages;
    }

    private Kurier getSelectedCourier()
    {
        Kurier toReturn = null;


        String k;
        k = kurierzy_combo_box.getSelectionModel().getSelectedItem().toString();

        for (Kurier c: listaKurierow)
        {
            if (c.getImie_I_Nazwisko().equals(k))
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
