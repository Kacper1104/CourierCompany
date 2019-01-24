package Presenter;

import Model.Przesylka;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kacper on 12.01.2019.
 */
public class ReturnOfPackage_Presenter {

    @FXML
    Button wybierz_btn, powrot_btn;

    @FXML
    TextField identyfikator_txt;




    boolean okId = false;
    static int package_id_to_return;


    @FXML
    public void onClickWybierz() throws IOException {

        int id = checkId(identyfikator_txt.getText());

        if (existInBase(id) && okId)
        {
            package_id_to_return = id;



            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/ReturnOfPackage/Package_Return.fxml"));
            Stage stage = (Stage) wybierz_btn.getScene().getWindow();
            stage.setScene(new Scene(root));
        }
        else
        {
            if (okId)
                showAlert();
        }
    }

    @FXML
    private void onClickPowrot() throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/View.fxml"));
        Stage stage = (Stage) wybierz_btn.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    private void showAlert()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Błąd");
        alert.setHeaderText(null);
        alert.setContentText("Podany identyfikator nie istnieje w bazie");

        alert.showAndWait();
    }

    public int checkId(String id)
    {
        int toReturn;
        try
        {
            toReturn = Integer.parseInt(id);
            okId = true;
            return toReturn;
        }
        catch (Exception e)
        {
            okId = false;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Błąd");
            alert.setHeaderText(null);
            alert.setContentText("Niepoprawny identyfikator");

            alert.showAndWait();
        }
        return -1;
    }

    public boolean existInBase(int id)
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

        if (items.size() != 0)
        {
            for (Przesylka p : items)
                if (p.getID() == id)
                {
                    return true;
                }
        }


        return false;
    }





}
