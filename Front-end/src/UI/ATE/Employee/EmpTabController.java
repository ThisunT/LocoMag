package UI.ATE.Employee;

//import Model.FailureOccured;
//import UI.Index.Connect;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * Created by piumiindeevari on 10/20/2017.
 */
public class EmpTabController implements Initializable {

    @FXML
    private Tab viewEmpTab;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            AnchorPane locoBase = FXMLLoader.load(getClass().getResource("../../Dashboard/emptyView.fxml"));
            UI.Index.IndexController.setNodeEmployee(locoBase);

            viewEmpTab.setContent(locoBase);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}