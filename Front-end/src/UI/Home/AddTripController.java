package UI.Home;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by acer on 12/7/2017.
 */
public class AddTripController implements Initializable {

    @FXML
    public ComboBox<String> cmbbox;
    public ComboBox<String> cmbbox2;
    public ComboBox<String> cmbbox3;
    public ComboBox<String> cmbbox4;
    public TextField txt_En;
    public TextField txt_Dr;
    public TextField Txt_Ag;
    public TextField Txt_En2;
    public TextField Txt_Dr2;
    public TextField Txt_En3;
    public TextField Txt_Dr3;
    public TextField Txt_Ag3;
    public TextField Txt_En4;
    public TextField Txt_Dr4;
    public TextField Txt_Ag4;
    public TextField Txt_Ag2;
    public Button btn_sub;

    ObservableList<String> list = FXCollections.observableArrayList("M", "W", "S");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cmbbox.setItems(list);
        cmbbox2.setItems(list);
        cmbbox3.setItems(list);
        cmbbox4.setItems(list);

    }

    private boolean ValidateFields() {
        if (txt_En.getText().isEmpty() | txt_Dr.getText().isEmpty()| Txt_Ag.getText().isEmpty() |cmbbox.getSelectionModel().isEmpty()|
                Txt_En2.getText().isEmpty()| Txt_Dr2.getText().isEmpty()| Txt_Ag2.getText().isEmpty()|cmbbox2.getSelectionModel().isEmpty()|
                Txt_En3.getText().isEmpty()| Txt_Dr3.getText().isEmpty()| Txt_Ag3.getText().isEmpty()|cmbbox3.getSelectionModel().isEmpty()|
                Txt_En4.getText().isEmpty()| Txt_Dr4.getText().isEmpty()| Txt_Ag4.getText().isEmpty()|cmbbox4.getSelectionModel().isEmpty()){




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

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}

public void Reset(ActionEvent actionEvent){
    txt_En.setText("");
    txt_Dr.setText("");
    Txt_Ag.setText("");
    Txt_En2.setText("");
    Txt_Dr2.setText("");
    Txt_Ag2.setText("");
    Txt_En3.setText("");
    Txt_Dr3.setText("");
    Txt_Ag3.setText("");
    Txt_En4.setText("");
    Txt_Dr4.setText("");
    Txt_Ag4.setText("");
    cmbbox.setItems(null);
    cmbbox2.setItems(null);
    cmbbox3.setItems(null);
    cmbbox4.setItems(null);
}




}
