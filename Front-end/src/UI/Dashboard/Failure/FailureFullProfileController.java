package UI.Dashboard.Failure;

import javafx.fxml.FXML;
import org.json.JSONObject;

/**
 * Created by Thisun Pathirage on 12/13/2017.
 */
<<<<<<< HEAD
public class FailureFullProfileController {
=======
public class FailureFullProfileController implements Initializable {


        @FXML
        private Label labelFailureID;

        @FXML
        private Label labelDate;

        @FXML
        private Label labelTime;

        @FXML
        private Label labelLocoID;

        @FXML
        private Label labelDriverID;

        @FXML
        private Label labelTripID;

        @FXML
        private Label labelRoute;

        @FXML
        private Label labelPlace;

        @FXML
        private Label labelLocoStateAtFailure;

        @FXML
        private Label labelNearestYard;

        @FXML
        private Label labelDriverNote;

        @FXML
        private Label labelCounteraction;

        @FXML
        private Label labelForemanNote;

        @FXML
        private Label labelFailureDescription;

        @FXML
        private Label labelRecoveryOption;

        @FXML
        private Label labelATEReview;

        @FXML
        private Label labelChiefEngineerJustification;

        @FXML
        private Label labelCurrentStateLoco;

        @FXML
        public String EngineNumber= VarFailure.EngineNo;


    @Override
        public void initialize(URL location, ResourceBundle resources) {

            try {
                JSONArray response = DBReader.returnFailures();

                for (int i = 0; i < response.length(); i++) {

                    if ((EngineNumber.equals(String.valueOf(response.getJSONObject(i).getInt("loco_ID")))) ){

                        labelFailureID.setText(response.getJSONObject(i).getString("failure_ID"));
                        labelDate.setText(String.valueOf(response.getJSONObject(i).getString("date")));
                        labelTime.setText(response.getJSONObject(i).getString("occured_time"));
                        labelTripID.setText(String.valueOf(response.getJSONObject(i).getInt("trip_ID")));
                        labelRoute.setText(response.getJSONObject(i).getString("place"));
                        labelLocoID.setText(String.valueOf(response.getJSONObject(i).getInt("loco_ID")));
                        labelDriverID.setText(response.getJSONObject(i).getString("emp_ID"));
                        labelPlace.setText(response.getJSONObject(i).getString("place"));
                        labelLocoStateAtFailure.setText(response.getJSONObject(i).getString("current_state_of_loco"));
                        labelLocoStateAtFailure.setText(response.getJSONObject(i).getString("nearest_yard"));
                        labelNearestYard.setText(response.getJSONObject(i).getString("nearest_yard"));
                        labelDriverNote.setText(response.getJSONObject(i).getString("driver_note"));
                        //labelCounteraction.setText(response.getJSONObject(i).getString("place"));
                        labelForemanNote.setText(response.getJSONObject(i).getString("foremans_note"));
                        labelFailureDescription.setText(response.getJSONObject(i).getString("failure_description"));
                        labelRecoveryOption.setText(response.getJSONObject(i).getString("recovery_option"));
                        labelATEReview.setText(response.getJSONObject(i).getString("ATEs_review"));
                        labelChiefEngineerJustification.setText(response.getJSONObject(i).getString("chief_engs_justification"));
                        labelCurrentStateLoco.setText(response.getJSONObject(i).getString("current_state_of_loco"));
                    }
                }


            } catch (Exception e) {
                System.out.println(e);
            }





>>>>>>> f7e7e983095ab0bed350bb6e449c1dac2d9d8c2b



}
