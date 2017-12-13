package UI.ChiefEngineer.Locomotive;

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
public class LocoTabController implements Initializable {

    @FXML
    private Tab viewLocoTab;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            AnchorPane locoBase = FXMLLoader.load(getClass().getResource("locoView.fxml"));
            UI.Index.IndexController.setNodeLoco(locoBase);
            viewLocoTab.setContent(locoBase);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}