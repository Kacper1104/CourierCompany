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
        //setKurierzy();
        //setPaczkiDoRozwiezienia();
        Przesylka p = new Przesylka(1, "Stat", "Opc", 5.20, createDate(2018, 11, 31), false, 2, createDate(2019, 0, 1), 2, 3, 4);
        System.out.println("POST successful for ID: "+packageREST_POST(p).getID());
        //do_rozwiezienia_listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        //na_liscie_listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
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
            ustawPaczkaListeRozwozowa();
            przypiszKurierowiListe();

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
        listaKurierow=courierREST_GET();
        for(Kurier iterator: listaKurierow){
            if(iterator.getLista_rozwozowa_ID() != null){
                listaKurierow.remove(iterator);
            }
        }
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

        listaPaczekDoRozwiezienia = packageREST_GET();

        for(Przesylka  iterator: listaPaczekDoRozwiezienia){
            if(iterator.getLista_rozwozowa_ID() != null){
                listaPaczekDoRozwiezienia.remove(iterator);
            }
        }


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


    //REST

    //Przesylka

    private Przesylka packageREST_POST(Przesylka przesylka){
        RestTemplate restTemplate = new RestTemplate();

        try{
            Przesylka result = restTemplate.postForObject("http://localhost:8080/rest/przesylka", przesylka, Przesylka.class);
            //System.out.println("Posted package ID: "+result.getID());

            return result;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private List<Przesylka> packageREST_GET(){

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

    private Przesylka packageREST_GET(Integer id){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/rest/przesylka/" + id ;

        try {
            Przesylka przesylka = restTemplate.getForObject(url, Przesylka.class);
            //System.out.println("Przesylka id: "+przesylka.getID());
            return przesylka;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Kurier

    private Kurier courierREST_POST(Kurier kurier){
        RestTemplate restTemplate = new RestTemplate();
        try{
            Kurier result = restTemplate.postForObject("http://localhost:8080/rest/kurier", kurier, Kurier.class);
            //System.out.println("Posted courier ID: "+result.getID());

            return result;
        } catch(Exception e){
            e. printStackTrace();
        }
        return null;
    }

    private List<Kurier> courierREST_GET(){
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

    private Kurier courierREST_GET(Integer id){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/rest/kurier/" + id ;
        try{
            Kurier result = restTemplate.getForObject(url, Kurier.class);
            return result;
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //Lista rozwozowa

    private Lista_rozwozowa distListREST_POST(Lista_rozwozowa lista){
        RestTemplate restTemplate = new RestTemplate();
        try {
            Lista_rozwozowa result = restTemplate.postForObject("http://localhost:8080/rest/lista_rozwozowa", lista, Lista_rozwozowa.class);
            System.out.println("Posted dist list ID: "+result.getID());

            return result;
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private List<Lista_rozwozowa> distListREST_GET(){
        RestTemplate restTemplate = new RestTemplate();
        String lists = restTemplate.getForObject("http://localhost:8080/rest/lista_rozwozowa", String.class);

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            List<Lista_rozwozowa> items = objectMapper.readValue(
                    lists,
                    objectMapper.getTypeFactory().constructParametricType(List.class, Lista_rozwozowa.class));

            return items;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Lista_rozwozowa distListREST_GET(Integer id){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/rest/lista_rozwozowa/" + id ;
        try{
            Lista_rozwozowa result = restTemplate.getForObject(url, Lista_rozwozowa.class);
            return result;
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
