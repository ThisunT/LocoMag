package UI.Dashboard.Failure;

import Connection.DeleteRequest;
import Connection.ObjectToJson;
import Connection.PostRequest;
import Models.FailureOccured;
import UI.setGlobals;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import static UI.loginController.infoBox;

/**
 * Created by Thisun Pathirage on 12/13/2017.
 */
public class ReviewFailureController {

    @FXML
    public TextArea txtReview;

    @FXML
    public Button addReview;

    JSONObject jsonObject=FailureProfile.failureJsonObject;
    private static String deleteUrl = "http://localhost:3000/api/failure/";

    public void reviewFailure() throws JSONException, IOException {
        FailureOccured failureOccured = new FailureOccured();
        if((setGlobals.user).substring(0,1).equals("F")){
            System.out.println("dsfa");
            failureOccured.setLocoID(jsonObject.getInt("loco_ID"));
            failureOccured.setFailureId(jsonObject.getString("failure_ID"));
            failureOccured.setTripId(jsonObject.getInt("trip_ID"));
            failureOccured.setPlace(jsonObject.getString("place"));
            failureOccured.setNearestYard(jsonObject.getString("nearest_yard"));
            failureOccured.setDate(jsonObject.getString("date"));
            failureOccured.setTime(jsonObject.getString("occured_time"));
            failureOccured.setEmployeeId(jsonObject.getString("emp_ID"));
            failureOccured.setDriverNote(jsonObject.getString("driver_note"));
            failureOccured.setFailureDescription(jsonObject.getString("failure_description"));
            failureOccured.setCounteraction(jsonObject.getString("recovery_option"));
            failureOccured.setForemanNote(txtReview.getText());
            failureOccured.setATEReview(jsonObject.getString("ATEs_review"));
            failureOccured.setChiefEngineerReview(jsonObject.getString("chief_engs_justification"));
            failureOccured.setCurrentState(jsonObject.getString(jsonObject.getString("current_state_of_loco")));

            DeleteRequest.sendDeleteRequest(deleteUrl+String.valueOf(jsonObject.getInt("ID")));
            PostRequest.sendPostRequest(deleteUrl,ObjectToJson.converter(failureOccured));
            infoBox("Update Successful", "Success", null);
        }
        else if((setGlobals.user).substring(0,1).equals("A")){
            failureOccured.setLocoID(jsonObject.getInt("loco_ID"));
            failureOccured.setFailureId(jsonObject.getString("failure_ID"));
            failureOccured.setTripId(jsonObject.getInt("trip_ID"));
            failureOccured.setPlace(jsonObject.getString("place"));
            failureOccured.setNearestYard(jsonObject.getString("nearest_yard"));
            failureOccured.setDate(jsonObject.getString("date"));
            failureOccured.setTime(jsonObject.getString("occured_time"));
            failureOccured.setEmployeeId(jsonObject.getString("emp_ID"));
            failureOccured.setDriverNote(jsonObject.getString("driver_note"));
            failureOccured.setFailureDescription(jsonObject.getString("failure_description"));
            failureOccured.setCounteraction(jsonObject.getString("recovery_option"));
            failureOccured.setForemanNote("foremans_note");
            failureOccured.setATEReview(jsonObject.getString(txtReview.getText()));
            failureOccured.setChiefEngineerReview(jsonObject.getString("chief_engs_justification"));
            failureOccured.setCurrentState(jsonObject.getString(jsonObject.getString("current_state_of_loco")));

            DeleteRequest.sendDeleteRequest(deleteUrl+String.valueOf(jsonObject.getInt("ID")));
            PostRequest.sendPostRequest(deleteUrl,ObjectToJson.converter(failureOccured));
            infoBox("Update Successful", "Success", null);
        }
        else if((setGlobals.user).substring(0,1).equals("C")){
            failureOccured.setLocoID(jsonObject.getInt("loco_ID"));
            failureOccured.setFailureId(jsonObject.getString("failure_ID"));
            failureOccured.setTripId(jsonObject.getInt("trip_ID"));
            failureOccured.setPlace(jsonObject.getString("place"));
            failureOccured.setNearestYard(jsonObject.getString("nearest_yard"));
            failureOccured.setDate(jsonObject.getString("date"));
            failureOccured.setTime(jsonObject.getString("occured_time"));
            failureOccured.setEmployeeId(jsonObject.getString("emp_ID"));
            failureOccured.setDriverNote(jsonObject.getString("driver_note"));
            failureOccured.setFailureDescription(jsonObject.getString("failure_description"));
            failureOccured.setCounteraction(jsonObject.getString("recovery_option"));
            failureOccured.setForemanNote("foremans_note");
            failureOccured.setATEReview(jsonObject.getString("ATEs_review"));
            failureOccured.setChiefEngineerReview(jsonObject.getString(txtReview.getText()));
            failureOccured.setCurrentState(jsonObject.getString(jsonObject.getString("current_state_of_loco")));

            DeleteRequest.sendDeleteRequest(deleteUrl+String.valueOf(jsonObject.getInt("ID")));
            PostRequest.sendPostRequest(deleteUrl,ObjectToJson.converter(failureOccured));

            infoBox("Update Successful", "Success", null);
        }
    }
}
