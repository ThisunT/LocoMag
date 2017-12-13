package UI.Dashboard.Locomotive;

import Connection.DBReader;
import Models.FailureTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.json.JSONArray;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by piumiindeevari on 12/9/2017.
 */
public class locomotiveProfileController implements Initializable {

        @FXML
        private Label labelDateBought;

        @FXML
        private Label labelLocoID;

        @FXML
        private Label labelEngineNo;

        @FXML
        private Label labelEngineType;

        @FXML
        private Label labelManufacturer;

        @FXML
        private Label labelTopSpeed;

        @FXML
        private Label labelManufacturedDate;

        @FXML
        private Label labelCurrentStateLoco;

        @FXML
        private ImageView imageLoco;

        @FXML
        private TableView tableFailure;

        @FXML
        private TableColumn eNo;

        @FXML
        private TableColumn fNo;

        @FXML
        private TableColumn fTy;

        @FXML
        private TableColumn sol;

        @FXML
        private TableColumn des;


        @FXML
        public String EngineType = VarLoco.EngineTyp;
        @FXML
        public String EngineNumber= VarLoco.EngineNo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            JSONArray response = DBReader.returnLocomotives();
            JSONArray failureResponse = DBReader.readByFields("Failures","loco_ID",EngineNumber);
            for (int i = 0; i < response.length(); i++) {

                if ((EngineType.equals(response.getJSONObject(i).getString("EngineType"))) && (EngineNumber.equals(String.valueOf(response.getJSONObject(i).getInt("EngineNumber"))))) {

                    labelEngineType.setText(response.getJSONObject(i).getString("EngineType"));
                    labelEngineNo.setText(String.valueOf(response.getJSONObject(i).getInt("EngineNumber")));
                    labelDateBought.setText(response.getJSONObject(i).getString("Today"));
                    labelManufacturer.setText(response.getJSONObject(i).getString("Manufacturer"));
                    labelTopSpeed.setText(String.valueOf(response.getJSONObject(i).getInt("TopSpeed")));
                    labelManufacturedDate.setText(response.getJSONObject(i).getString("ManufacturedDay"));
                    labelCurrentStateLoco.setText(response.getJSONObject(i).getString("State"));
                    setTrueImage("UI/Images/locos/" + String.valueOf(response.getJSONObject(i).getInt("EngineNumber")) + ".png");
                }
            }
            ArrayList<FailureTable> listFails = new ArrayList<>();
            for(int j=0;j<failureResponse.length();j++){
                FailureTable failureTable =new FailureTable(failureResponse.getJSONObject(j).getInt("loco_ID"), failureResponse.getJSONObject(j).getString("failure_ID"),failureResponse.getJSONObject(j).getInt("ID"),failureResponse.getJSONObject(j).getString("failure_description"),failureResponse.getJSONObject(j).getString("recovery_option"));
                listFails.add(failureTable);
            }
            ObservableList<FailureTable> oListFails = FXCollections.observableArrayList(listFails);


            eNo.setCellValueFactory(
                    new PropertyValueFactory<>("engineNumber")
            );
            fNo.setCellValueFactory(
                    new PropertyValueFactory<>("failureId")
            );
            fTy.setCellValueFactory(
                    new PropertyValueFactory<>("failureIdVal")
            );
            sol.setCellValueFactory(
                    new PropertyValueFactory<>("failureDescription")
            );
            des.setCellValueFactory(
                    new PropertyValueFactory<>("recoveryOption")
            );

            tableFailure.setItems(oListFails);

        } catch (Exception e) {
            System.out.println(e);
        }



    }

    public void setTrueImage(String url) {

        if(url=="UI/Images/train.png"){
            imageLoco.setFitHeight(100.0); imageLoco.setFitWidth(100.0); imageLoco.setLayoutX(160.0); imageLoco.setLayoutY(50.0); imageLoco.setPickOnBounds(true); imageLoco.setPreserveRatio(true);
        }
        else {
            imageLoco.setFitHeight(125.0); imageLoco.setFitWidth(125.0); imageLoco.setLayoutX(148.0); imageLoco.setLayoutY(40.0); imageLoco.setPickOnBounds(true); imageLoco.setPreserveRatio(true);
        }
        Image img = new Image(url);
        imageLoco.setImage(img);

    }

}
