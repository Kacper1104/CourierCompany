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

/**
 * Prezenter obsługujący zwrot paczki
 */
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
            miejscowosc_od_przed, imie_i_naz_od_po, ulica_od_po, kod_odb_po, miejscowosc_od_po, status_przed, status_po, numer_id;


    /**
     * metoda inicjalizująca
     */
    @FXML
    public void initialize()
    {
        id = ReturnOfPackage_Presenter.package_id_to_return;
        paczka  = findPackage(id);


        nadawca = findSender(id);
        odbiorca = findRecpient(id);

        setContent();
    }

    /**
     * obsługa guzika OK
     * @throws IOException error
     */
    @FXML
    private void onClickOkButton() throws IOException {

        zmienStatusPaczki();

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/View.fxml"));
        Stage stage = (Stage) ok_btn.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    /**
     * obsługa guzika Anuluj
     * @throws IOException error
     */
    @FXML
    private void onClickAnulujButton() throws IOException {

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/View.fxml"));
        Stage stage = (Stage) ok_btn.getScene().getWindow();
        stage.setScene(new Scene(root));
    }


    /**
     * znajdowanie nadawcy wg id
     * @param id identyfikator
     * @return nadawca
     */
    private Nadawca findSender(int id)
    {
        RestTemplate restTemplate = new RestTemplate();
        String nad = restTemplate.getForObject("http://localhost:8080/rest/nadawca/" + id, String.class);

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Nadawca toReturn = objectMapper.readValue(nad, Nadawca.class);
            return toReturn;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * snajdowanie odbiorcy wg id
     * @param id identyfikator
     * @return odbiorca
     */
    private Odbiorca findRecpient(int id)
    {

        RestTemplate restTemplate = new RestTemplate();
        String odb = restTemplate.getForObject("http://localhost:8080/rest/odbiorca/" + id, String.class);

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Odbiorca toReturn = objectMapper.readValue(odb, Odbiorca.class);
            return toReturn;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * znajdowanie paczki wg id
     * @param id identyfikator
     * @return przesyłka
     */
    private Przesylka findPackage(int id)
    {

        RestTemplate restTemplate = new RestTemplate();
        String prze = restTemplate.getForObject("http://localhost:8080/rest/przesylka/" + id, String.class);

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Przesylka toReturn = objectMapper.readValue(prze, Przesylka.class);
            return toReturn;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * ustawianie kontentu na ekran
     */
    private void setContent()
    {
        setOdbiorcaPrzed();
        setNadawcaPrzed();
        setNadawcaPo();
        setOdbiorcaPo();
        setStatusy();
    }

    /**
     * ustawniwanie na ekran odbiorcy przed zmianą
     */
    private void setOdbiorcaPrzed()
    {
        imie_i_naz_od_przed.setText(odbiorca.getImie_I_Nazwisko());
        ulica_od_przed.setText(odbiorca.getAdres());
        kod_odb_przed.setText(odbiorca.getKod_Pocztowy());
        miejscowosc_od_przed.setText(odbiorca.getMiejscowosc());
    }

    /**
     * ustawniwanie na ekran nadawcy przed zmianą
     */
    private void setNadawcaPrzed()
    {
        imie_i_naz_nad_przed.setText(nadawca.getImie_I_Nazwisko());
        ulica_nad_przed.setText(nadawca.getAdres());
        kod_nad_przed.setText(nadawca.getKod_Pocztowy());
        miejscowosc_nad_przed.setText(nadawca.getMiejscowosc());
    }

    /**
     * ustawniwanie na ekran odbiorcy po zmianie
     */
    private void setOdbiorcaPo()
    {
        imie_i_naz_od_po.setText(nadawca.getImie_I_Nazwisko());
        ulica_od_po.setText(nadawca.getAdres());
        kod_odb_po.setText(nadawca.getKod_Pocztowy());
        miejscowosc_od_po.setText(nadawca.getMiejscowosc());
    }

    /**
     * ustawniwanie na ekran nadawcy po zmianie
     */
    private void setNadawcaPo()
    {
        imie_i_naz_nad_po.setText(odbiorca.getImie_I_Nazwisko());
        ulica_nad_po.setText(odbiorca.getAdres());
        kod_nad_po.setText(odbiorca.getKod_Pocztowy());
        miejscowosc_nad_po.setText(odbiorca.getMiejscowosc());
    }

    /**
     * ustawianie na ekranie statusó paczki
     */
    private void setStatusy()
    {
        status_przed.setText(paczka.getStatus_przesylki());
        status_po.setText("Zwrot");
        numer_id.setText(paczka.getID().toString());
    }

    private boolean udaloSieZmienic = true;

    /**
     * zmiana statusu przesyłki
     */
    private void zmienStatusPaczki()
    {
        Odbiorca nowyOdbiorca = new Odbiorca(nadawca.getImie_I_Nazwisko(), nadawca.getAdres(), nadawca.getKod_Pocztowy(), nadawca.getMiejscowosc(), nadawca.getLogin(), nadawca.getHaslo());
        Nadawca nowyNadawca = new Nadawca(odbiorca.getImie_I_Nazwisko(), odbiorca.getAdres(), odbiorca.getKod_Pocztowy(), odbiorca.getMiejscowosc(), nadawca.getLogin(), nadawca.getHaslo());
        paczka.setStatus_przesylki("zwrot");

        //trzeba wysłać na serwer nowych nadawcę i odbiorcę, żeby tam im nadać id, a potem zwrócić te id do programu, żeby móc je przypisać paczce
        //wyslać na serwer zmodyfikowaną przesyłke

        nadawca = senderREST_POST(nowyNadawca);
        odbiorca = recipientREST_POST(nowyOdbiorca);

        paczka.setNadawca_ID(nadawca.getID());
        paczka.setOdbiorca_ID(odbiorca.getID());


        //modyfikacja przesylki na serwerze
        RestTemplate restTemplate = new RestTemplate();
        try{
            Przesylka result = restTemplate.postForObject("http://localhost:8080/rest/przesylka", paczka, Przesylka.class);
            System.out.println(result.getOdbiorca_ID() + " " + result.getNadawca_ID() + " " + result.getStatus_przesylki());
        }catch(Exception e){
            e.printStackTrace();
        }

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

    /**
     * wysyłąnei na serwer odbiorcy do zmiany
     * @param odbiorca odbiorca do zmiany
     * @return odpowiedź serwera
     */
    private Odbiorca recipientREST_POST(Odbiorca odbiorca){
        RestTemplate restTemplate = new RestTemplate();

        try{
            Odbiorca result = restTemplate.postForObject("http://localhost:8080/rest/odbiorca", odbiorca, Odbiorca.class);
            //System.out.println("Posted package ID: "+result.getID());

            return result;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * wysyłąnei na serwer nadawcy do zmiany
     * @param nadawca nadawca do zmiany
     * @return odpowiedź serwera
     */
    private Nadawca senderREST_POST(Nadawca nadawca){
        RestTemplate restTemplate = new RestTemplate();

        try{
            Nadawca result = restTemplate.postForObject("http://localhost:8080/rest/nadawca", nadawca, Nadawca.class);
            //System.out.println("Posted package ID: "+result.getID());

            return result;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
