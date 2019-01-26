package Presenter;

import Model.Kurier;
import Model.Lista_rozwozowa;
import Model.Przesylka;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
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
    public void initialize() throws IOException {
        setKurierzy();
        setPaczkiDoRozwiezienia();

        //SPIKE
//        Date date = createDate(2018, 10, 20);
//        Lista_rozwozowa lista = new Lista_rozwozowa(5, date,2);
//        RestTemplate restTemplate = new RestTemplate();
//
//        try{
//            Lista_rozwozowa result = restTemplate.postForObject("http://localhost:8080/rest/lista_rozwozowa", lista, Lista_rozwozowa.class);
//            System.out.println("ID: "+result.getID()+" Data: "+result.getData().toString()+" Magazynier: "+result.getMagazynier_ID());
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//
//        do_rozwiezienia_listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//        na_liscie_listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}

	private Date createDate(int year, int month, int day){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

	private void utworzListeRozwozowa()
    {
        wybranyKurier = getSelectedCourier();
        LocalDate date = LocalDate.now();
        Date dd = new Date(date.getYear(), date.getMonthValue(), date.getDayOfMonth());

        //WPISAC DANE
        listaRozwozowa = new Lista_rozwozowa();
    }

    private void ustawPaczkaListeRozwozowa()
    {
        for (Przesylka p: paczkiNaLiscieRozwozowej)
        {
            p.setLista_rozwozowa_ID(listaRozwozowa.getID());
            p.setNa_liscie_rozwozowej(true);
        }
    }

    private void przypiszKurierowiListe()
    {
        getSelectedCourier().setLista_rozwozowa_ID(listaRozwozowa.getID());
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
    private void onOkButtonClicked() throws IOException {
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
            //wyslać na serwer, odebrać id
            ustawPaczkaListeRozwozowa(); //ustaw nowe id
            przypiszKurierowiListe(); // ustaw nowe id

            //
            //wysłać do serwera wybranyKurier, listaRozwozowa, paczkiNaLiscieRozwozowej do zmiany
            //




            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText("Utworzono nową listę");
            alert.showAndWait();

            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/View.fxml"));
            Stage stage = (Stage) ok_btn.getScene().getWindow();
            stage.setScene(new Scene(root));
        }
    }

    @FXML
    private void onAnulujButtonClicked() throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/View.fxml"));
        Stage stage = (Stage) ok_btn.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    private void listOfCourier() throws IOException {
        listaKurierow= CourierREST_GET();

        List<Kurier> cleanList = new ArrayList<>();

        for(int i =0; i< listaKurierow.size(); i++){
            if(listaKurierow.get(i).getLista_rozwozowa_ID() == null){
                cleanList.add(listaKurierow.get(i));
            }
        }
        listaKurierow = cleanList;

        if(listaKurierow.isEmpty())
            saKurierzy = false;
        else
            saKurierzy = true;


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

    private void setKurierzy() throws IOException {
        listOfCourier();
        ObservableList<String> options = FXCollections.observableArrayList();
        for (Kurier c: listaKurierow)
        {
            options.add(c.getImie_I_Nazwisko());
        }

        kurierzy_combo_box.setItems(options);
    }


    private void listOfPackages() throws IOException {

        listaPaczekDoRozwiezienia = PackageREST_GET();

        List<Przesylka> cleanList = new ArrayList<>();

        for(Przesylka  iterator: listaPaczekDoRozwiezienia){
            if(iterator.getLista_rozwozowa_ID() == null){
                cleanList.add(iterator);
            }
        }

        listaPaczekDoRozwiezienia = cleanList;

        if(listaPaczekDoRozwiezienia.isEmpty())
            saPaczki = false;
        else
            saPaczki = true;


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

    private void setPaczkiDoRozwiezienia() throws IOException {

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
        String couriers = restTemplate.getForObject("http://localhost:8080/rest/kurier", String.class);

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            List<Kurier> items = objectMapper.readValue(
                    couriers,
                    objectMapper.getTypeFactory().constructParametricType(List.class, Kurier.class));

            return items;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<Przesylka> PackageREST_GET(){

        RestTemplate restTemplate = new RestTemplate();
        String packages = restTemplate.getForObject("http://localhost:8080/rest/przesylka", String.class);

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            List<Przesylka> items = objectMapper.readValue(
                    packages,
                    objectMapper.getTypeFactory().constructParametricType(List.class, Przesylka.class));

            return items;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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
