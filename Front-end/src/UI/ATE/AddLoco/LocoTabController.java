package UI.ATE.AddLoco;

//import Model.FailureOccured;
//import UI.Index.Connect;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
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