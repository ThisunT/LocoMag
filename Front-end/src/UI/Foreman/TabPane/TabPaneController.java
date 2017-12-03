package UI.Foreman.TabPane;

import UI.Index.IndexController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class TabPaneController implements Initializable {

    @FXML
    public TabPane foremanTabPane;

    @FXML
    public Tab homeTab;

    public void initialize(URL url, ResourceBundle rb){

    }


    public void getSelectionModel(MouseEvent event){
        IndexController UI = new IndexController();
        UI.transPane();
    }
}