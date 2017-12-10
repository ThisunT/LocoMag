package UI.Foreman.Trip;

import Connection.ObjectToJson;
import Connection.PostRequest;
import Models.Trip;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Created by acer on 12/7/2017.
 */
public class AddTripController implements Initializable {

    @FXML
    public ComboBox<String> cmbbox;

    public TextField txt_En;
    public TextField txt_Dr;
    public TextField Txt_Ag;

    public Button btn_sub;
    public DatePicker date;
    public TextField Txt_Rid;


    private String addTripUrl = "http://localhost:3000/api/trip/";



    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    private boolean ValidateFields() {
        if (txt_En.getText().isEmpty() | txt_Dr.getText().isEmpty()| Txt_Ag.getText().isEmpty() |Txt_Rid.getText().isEmpty()

               ){




            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate Fields");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter Into The Fields");
            alert.showAndWait();

            return false;
        }
        return true;

    }

public void Submit(ActionEvent actionEvent)throws Exception{
    if (ValidateFields()){
        try {
            Trip trip=new Trip();

            LocalDate localDate = date.getValue();
            Date date_today1 = java.sql.Date.valueOf(localDate);
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            String date_today = df.format(date_today1);
            trip.setDate(date_today);
            trip.setLocoId(Integer.parseInt(txt_En.getText()));
            trip.setRouteId(Integer.parseInt(Txt_Rid.getText()));
            trip.setDriverId(Integer.parseInt(txt_Dr.getText()));
            trip.setGuardId(Integer.parseInt(Txt_Ag.getText()));
            trip.setRouteId(Integer.parseInt(Txt_Rid.getText()));









            String tripObject = ObjectToJson.converter(trip);
            System.out.println(tripObject);

            try {
                PostRequest.sendPostRequest(addTripUrl,tripObject);
            }catch (IOException e){
                System.out.println(e.getMessage());
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}

public void Reset(ActionEvent actionEvent){
    txt_En.setText("");
    txt_Dr.setText("");
    Txt_Ag.setText("");
    Txt_Rid.setText("");

}







}
