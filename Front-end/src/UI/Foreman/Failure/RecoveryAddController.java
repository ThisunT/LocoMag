package UI.Foreman.Failure;

//import Model.FailureOccured;
//import UI.Index.Connect;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static java.util.Arrays.asList;


/**
 * Created by piumiindeevari on 10/20/2017.
 */
public class RecoveryAddController implements Initializable {

    List<String> listComboE = new ArrayList<>(asList("M4","M5","M8","M9","M10"));
    List<String> listComboS = new ArrayList<>(asList("Dead","Idle","Active","Running"));
    List<String> listComboF = new ArrayList<>(asList("Ground relay tripped","Hot engine","Low oil pressure","Crankcase exhauster failure","Traction motor blower failure","No battery charge","Diesel engine overspeed","other"));

    public ComboBox<String> combo_engineType;
    public ComboBox<String> combo_engineState;
    public Button btn_submit;
    public TextField txt_engineNo;
    public ComboBox<String> combo_failureName;
    public DatePicker date_done;
    public TextArea txt_recoveryOption;
    public TextArea txt_note ;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.fillCombo_failureName();
        this.fillCombo_engineType();
        this.fillCombo_engineState();

    }
//Set Combo box lists: Engine Class, Failure Name, Route, Engine State

    void fillCombo_failureName(){ combo_failureName.setItems(FXCollections.observableArrayList(listComboF));}


    void fillCombo_engineType(){
        combo_engineType.setItems(FXCollections.observableArrayList(listComboE));
    }


    void fillCombo_engineState(){
        combo_engineState.setItems(FXCollections.observableArrayList(listComboS));
    }



}