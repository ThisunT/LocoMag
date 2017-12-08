package UI.ATE.Employee;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by acer on 12/7/2017.
 */
public class AddEmpController implements Initializable {
    public TextField Txt_ID;
    public TextField Txt_Name;
    public TextField Txt_Ag;
    public TextField Txt_No;
    public TextField Txt_Email;
    public TextArea TA_add;
    public Button btn_Sub;
    public ComboBox<String> Cmb_Pro;

    @FXML
    ObservableList<String> list = FXCollections.observableArrayList("Chief Engineer", "ATE", "Forman", "Driver", "Gaurd");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Cmb_Pro.setItems(list);

    }

    private boolean ValidateFields() {
        if (Txt_ID.getText().isEmpty() | Txt_Name.getText().isEmpty() | Txt_Ag.getText().isEmpty() |
                Txt_No.getText().isEmpty() | Txt_Email.getText().isEmpty() | TA_add.getText().isEmpty()|
                Cmb_Pro.getSelectionModel().isEmpty()


                ) {

            Warning("Validate Fields",null,"Please Enter Into The Fields");


            return false;
        }
        return true;

    }

    public void ValidateNo(ActionEvent actionEvent) {
        Txt_No.setOnKeyReleased(e -> {
            int length = Txt_No.getText().length();
            final int Max = 11;
            if (Txt_No.getText().matches("[0-9]*") && (length < Max)) {


            }else{
                Warning("Validate Fields",null,"Not a Valid Phone Number");
            }

        });
    }



    public void Submit(ActionEvent actionEvent){
        if (ValidateFields()){
            try {

            }catch (Exception e){
                e.printStackTrace();

            }

        }

    }
public static void Warning(String Title, String Header, String Content){
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle(Title);
    alert.setHeaderText(Header);
    alert.setContentText(Content);
    alert.showAndWait();

}
    public void Reset(ActionEvent actionEvent){
        Txt_ID.setText("");
        Txt_Email.setText("");
        Txt_No.setText("");
        Txt_Ag.setText("");
        TA_add.setText("");
        Txt_Name.setText("");
        Cmb_Pro.setItems(null);

    }
}
