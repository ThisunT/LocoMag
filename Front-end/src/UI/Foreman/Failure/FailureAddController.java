package UI.Foreman.Failure;

import Models.FailureOccured;
import Models.MaintenanceDone;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.json.JSONArray;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import static java.util.Arrays.asList;
import Connection.*;


public class FailureAddController implements Initializable {

    List<String> listComboS = new ArrayList<>(asList("Dead","Idle","Active","Running"));
    @FXML
    public ComboBox<String> combo_engineState;
    @FXML
    public Button btn_submit;
    @FXML
    public TextField txt_engineNo;
    @FXML
    public TextField txt_failure;
    @FXML
    public TextField txt_trip;
    @FXML
    public TextField txt_time;
    @FXML
    public TextField txt_emp;
    @FXML
    public DatePicker date;
    @FXML
    public TextField txt_place;
    @FXML
    public TextField txt_nearestYard;
    @FXML
    public TextArea txt_counteraction;
    @FXML
    public TextArea txt_description;

    private String failureOccuredUrl = "http://localhost:3000/api/failure/";

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.fillCombo_engineState();
    }
//Set Combo box lists: Engine State

    void fillCombo_engineState(){
        combo_engineState.setItems(FXCollections.observableArrayList(listComboS));
    }

    void setTime(){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        txt_time.setText(dateFormat.format(date));
    }


    public void OnSubmitButtonPress(){
        FailureOccured failureOccured= new FailureOccured(); //create a object from FailureOccured model class

        LocalDate localDate = date.getValue();
        Date date_today1 = java.sql.Date.valueOf(localDate);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String date_today = df.format(date_today1);
        failureOccured.setDate(date_today) ;
        failureOccured.setLocoID(Integer.parseInt(txt_engineNo.getText()));
        failureOccured.setFailureId(txt_failure.getText());
        failureOccured.setTripId(Integer.parseInt(txt_trip.getText()));
        failureOccured.setPlace(txt_place.getText());
        failureOccured.setNearestYard(txt_nearestYard.getText());
        failureOccured.setTime(txt_time.getText());
        failureOccured.setEmployeeId(txt_emp.getText());
        failureOccured.setFailureDescription(txt_failure.getText());
        failureOccured.setCounteraction(txt_counteraction.getText());
        failureOccured.setCurrentState(combo_engineState.getValue());

        String userObject = ObjectToJson.converter(failureOccured);
        System.out.println(userObject);
        try {
            validation();
            PostRequest.sendPostRequest(failureOccuredUrl, userObject);

            //clear input data
            txt_engineNo.clear();
            txt_counteraction.clear();
            txt_failure.clear();
            txt_time.clear();
            txt_description.clear();
            txt_place.clear();
            txt_trip.clear();
            txt_nearestYard.clear();
            txt_emp.clear();
            combo_engineState.setValue(null);
            date.getEditor().clear();

        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
    public void validation(){
        if (( txt_engineNo.getText().isEmpty()|| txt_engineNo.getText() == null )|| (txt_counteraction.getText().isEmpty()||txt_counteraction.getText().isEmpty())||( txt_failure.getText().isEmpty()
                ||txt_failure.getText() == null )||(txt_time.getText().isEmpty() || txt_time.getText()==null)||(combo_engineState.getValue() == null || combo_engineState.getValue().isEmpty())
                ||(date.getEditor() == null )||(txt_description.getText().isEmpty()||txt_description.getText()==null)||(txt_place.getText().isEmpty()|| txt_place.getText()==null)||(txt_trip.getText().isEmpty()||txt_trip.getText()==null))

        {
            Alert fail = new Alert(Alert.AlertType.INFORMATION);
            fail.setHeaderText("failure");
            fail.setContentText("you havent typed something");
            fail.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Success");
            alert.setContentText("Account succesfully created!");
            alert.showAndWait();

        }
    }
}