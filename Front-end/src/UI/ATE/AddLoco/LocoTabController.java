package UI.ATE.AddLoco;

//import Model.FailureOccured;
//import UI.Index.Connect;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * Created by piumiindeevari on 10/20/2017.
 */
public class LocoTabController {

    @FXML
    private Tab viewLocoTab;

    public void initialize() {
        try {
            AnchorPane locoBase = FXMLLoader.load(getClass().getResource("/UI/Index/home.fxml"));
            viewLocoTab.setContent(locoBase);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}