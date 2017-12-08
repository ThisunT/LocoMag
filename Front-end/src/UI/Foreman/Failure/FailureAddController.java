package UI.Foreman.Failure;

//import Model.FailureOccured;
//import UI.Index.Connect;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.json.JSONArray;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import static java.util.Arrays.asList;
import Connection.*;


/**
 * Created by piumiindeevari on 10/20/2017.
 */
public class FailureAddController implements Initializable {


    List<String> listComboF = new ArrayList<>(asList("Ground relay tripped","Hot engine","Low oil pressure","Crankcase exhauster failure","Traction motor blower failure","No battery charge","Diesel engine overspeed","other"));
    List<String> listComboR = new ArrayList<>(asList("Main Line","Matale Line","Puttlam Line","Nothern Line","Coastal Line","Kelaniweli Line"));
    List<String> listComboE = new ArrayList<>(asList("M4","M5","M8","M9","M10"));
    List<String> listComboS = new ArrayList<>(asList("Dead","Idle","Active","Running"));

    public ComboBox<String> combo_failureName;
    public ComboBox<String> combo_route;
    public ComboBox<String> combo_engineClass;
    public ComboBox<String> combo_engineState;
    public Button btn_submit;
    public TextField txt_engineNo;
    public TextField txt_time;
    public TextField txt_place;
    public TextField txt_nearestYard;
    public TextArea txt_counteraction;
    public TextArea txt_driverNote;
    public TextArea txt_description;


    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.fillCombo_failureName();
        this.fillCombo_route();
        this.fillCombo_engineClass();
        this.fillCombo_engineState();
        this.setTime();

    }
//Set Combo box lists: Engine Class, Failure Name, Route, Engine State

    void fillCombo_failureName(){
        combo_failureName.setItems(FXCollections.observableArrayList(listComboF));
    }

    void fillCombo_route(){
        combo_route.setItems(FXCollections.observableArrayList(listComboR));
    }

    void fillCombo_engineClass(){
        combo_engineClass.setItems(FXCollections.observableArrayList(listComboE));
    }


    void fillCombo_engineState(){
        combo_engineState.setItems(FXCollections.observableArrayList(listComboS));
    }

    void setTime(){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        txt_time.setText(dateFormat.format(date));
    }


    
}