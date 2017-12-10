package UI.Foreman.Maintenance;

//import Model.FailureOccured;
//import UI.Index.Connect;

import Connection.ObjectToJson;
import Connection.PostRequest;
import Models.MaintenanceDone;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import static java.util.Arrays.asList;


public class MaintenanceAddController implements Initializable {


    List<String> listComboN = new ArrayList<>(asList("MName1","MName2","MName3","MName4"));
    List<String> listComboT = new ArrayList<>(asList("MType1","MType2","MType3","MType4"));
    List<String> listComboE = new ArrayList<>(asList("M4","M5","M8","M9","M10"));
    List<String> listComboS = new ArrayList<>(asList("Dead","Idle","Active","Running"));

    @FXML
    public ComboBox<String> combo_engineClass;
    @FXML
    public ComboBox<String> combo_name;
    @FXML
    public ComboBox<String> combo_type;
    @FXML
    public ComboBox<String> combo_engineState;
    @FXML
    public Button btn_submit;
    @FXML
    public TextField txt_engineNo;
    @FXML
    public DatePicker date_done;
    @FXML
    public TextArea txt_note;
    @FXML
    public TextArea txt_sugessions;

    private String addMaintenanceUrl = "http://localhost:3000/api/maintenance/";


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.fillCombo_name();
        this.fillCombo_type();
        this.fillCombo_engineClass();
        this.fillCombo_engineState();
    }
//Set Combo box lists: Engine Class, Name, Type, Engine State

    void fillCombo_name(){
        combo_name.setItems(FXCollections.observableArrayList(listComboN));
    }

    void fillCombo_type(){ combo_type.setItems(FXCollections.observableArrayList(listComboT)); }

    void fillCombo_engineClass(){
        combo_engineClass.setItems(FXCollections.observableArrayList(listComboE));
    }

    void fillCombo_engineState(){
        combo_engineState.setItems(FXCollections.observableArrayList(listComboS));
    }


    public void submit(){//ooooooooooooooooooooo
        MaintenanceDone maintenance= new MaintenanceDone(); //create a object from MaintenanceDone model class

        LocalDate localDate = date_done.getValue();
        Date date_today1 = java.sql.Date.valueOf(localDate);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String date_today = df.format(date_today1);
        maintenance.setDate(date_today) ;
        maintenance.setNote(txt_note.getText());
        maintenance.setSuggestion(txt_sugessions.getText());
        maintenance.setEngineNo(txt_engineNo.getText());
        maintenance.setType(combo_type.getValue());
        maintenance.setName(combo_name.getValue());
        maintenance.setEngineClass(combo_engineClass.getValue());
        maintenance.setCurrentState(combo_engineState.getValue());

        String userObject = ObjectToJson.converter(maintenance);
        System.out.println(userObject);
     try {
         validation();
         PostRequest.sendPostRequest(addMaintenanceUrl, userObject);


         // JOptionPane.showMessageDialog(null, "Successfully");

         //clear input data
         txt_sugessions.clear();
         txt_engineNo.clear();
         txt_note.clear();
         date_done.getEditor().clear();
         combo_engineClass.setValue(null);
         combo_engineState.setValue(null);
         combo_name.setValue(null);
         combo_type.setValue(null);


     }
     catch (IOException e){
        System.out.println(e.getMessage());
     }



    }
    public void validation(){
        if (( txt_note.getText().isEmpty())|| txt_engineNo.getText() == null || txt_note.getText().isEmpty()
            ||(txt_sugessions.getText() == null || txt_sugessions.getText().isEmpty())||(combo_type.getValue() == null || combo_type.getValue().isEmpty()
        )||(combo_name.getValue() == null || combo_name.getValue().isEmpty())||(combo_engineState.getValue() == null || combo_engineState.getValue().isEmpty()
        )||(combo_engineClass.getValue() == null || combo_engineClass.getValue().isEmpty())||(date_done.getEditor() == null )
                )

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

