package UI.Dashboard.Employee;

import Connection.DBReader;
import UI.Dashboard.Locomotive.VarLoco;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.json.JSONArray;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by piumiindeevari on 12/9/2017.
 */
public class employeeProfileController implements Initializable {

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
        public String EngineType = VarLoco.EngineTyp;
        @FXML
        public String EngineNumber= VarLoco.EngineNo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            JSONArray response = DBReader.returnLocomotives();
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
