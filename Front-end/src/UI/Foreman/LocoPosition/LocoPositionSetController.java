package UI.Foreman.LocoPosition;

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
public class LocoPositionSetController implements Initializable {

    List<String> listComboE = new ArrayList<>(asList("M4","M5","M8","M9","M10"));

    public ComboBox<String> combo_engineClass;
    public Button btn_submit;
    public DatePicker date_today;
    public TextField txt_running;
    public TextField txt_active;
    public TextField txt_idle;
    public TextField txt_dead;

    @Override
    public void initialize(URL location, ResourceBundle resources) { this.fillCombo_engineClass();}

//Set Combo box lists: Engine Class

    void fillCombo_engineClass(){
        combo_engineClass.setItems(FXCollections.observableArrayList(listComboE));
    }

}