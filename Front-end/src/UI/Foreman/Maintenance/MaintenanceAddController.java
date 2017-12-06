package UI.Foreman.Maintenance;

//import Model.FailureOccured;
//import UI.Index.Connect;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

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


/**
 * Created by piumiindeevari on 10/20/2017.
 */
public class MaintenanceAddController implements Initializable {


    List<String> listComboN = new ArrayList<>(asList("MName1","MName2","MName3","MName4"));
    List<String> listComboT = new ArrayList<>(asList("MType1","MType2","MType3","MType4"));
    List<String> listComboE = new ArrayList<>(asList("M4","M5","M8","M9","M10"));
    List<String> listComboS = new ArrayList<>(asList("Dead","Idle","Active","Running"));

    public ComboBox<String> combo_engineType;
    public ComboBox<String> combo_name;
    public ComboBox<String> combo_type;
    public ComboBox<String> combo_engineState;
    public Button btn_submit;
    public TextField txt_engineNo;
    public DatePicker date_done;
    public TextArea txt_note;
    public TextArea txt_sugessions;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.fillCombo_name();
        this.fillCombo_type();
        this.fillCombo_engineType();
        this.fillCombo_engineState();
    }
//Set Combo box lists: Engine Class, Name, Type, Engine State

    void fillCombo_name(){
        combo_name.setItems(FXCollections.observableArrayList(listComboN));
    }

    void fillCombo_type(){ combo_type.setItems(FXCollections.observableArrayList(listComboT)); }

    void fillCombo_engineType(){
        combo_engineType.setItems(FXCollections.observableArrayList(listComboE));
    }

    void fillCombo_engineState(){
        combo_engineState.setItems(FXCollections.observableArrayList(listComboS));
    }


}