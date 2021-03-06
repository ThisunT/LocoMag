package UI.Dashboard.Failure;

import UI.Dashboard.Locomotive.VarLoco;
import UI.setGlobals;
import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import static UI.loginController.infoBox;

/**
 * Created by Thisun Pathirage on 12/6/2017.
 */
public class FailureProfile {

    private AnchorPane anchor =  new AnchorPane();
    private Label locoNumber = new Label();
    private Label date = new Label();
    private Label time = new Label();
    private Label recordedEmployee = new Label();
    private Label failureType = new Label();
    private Label place = new Label();
    private Label space = new Label();
    private Pane pane = new Pane();
    private Label ID = new Label();
    private JFXButton profile = new JFXButton();
    private JFXButton resolvedOrNot = new JFXButton();
    public static int failureID;
    public static JSONObject failureJsonObject = new JSONObject();

    public void setFailureJsonObject(JSONObject jsonObject){
        this.failureJsonObject=jsonObject;
    }

    public JSONObject getFailureJsonObject(){
        return failureJsonObject;
    }

    public void setLocoNumber(String locoNumber) {
        this.locoNumber.setText(locoNumber);
    }

    public void setDate(String date) {
        this.date.setText(date);
    }

    public void setTime(String time) {
        this.time.setText(time);
    }

    public void setRecordedEmployee(String recordedEmployee) {
        this.recordedEmployee.setText(recordedEmployee);
    }

    public void setFailureType(String failureType) {
        this.failureType.setText(failureType);
    }

    public void setPlace(String place) {
        this.place.setText(place);
    }

    public void showReviewWindow(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("reviewFailure.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Sri Lanka Railways Motive Power sub Department - Engine Failure management System");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //return anchor;
    }

    public void resolvedOrNotClicked() throws JSONException {

        if((setGlobals.user).substring(0,1).equals("F") && getFailureJsonObject().getString("foremans_note").equals("")){
            showReviewWindow();
        }
        else if((setGlobals.user).substring(0,1).equals("A") && getFailureJsonObject().getString("ATEs_review").equals("")){
            showReviewWindow();
        }
        else if((setGlobals.user).substring(0,1).equals("C") && getFailureJsonObject().getString("chief_engs_justification").equals("")){
            showReviewWindow();
        }
        else {
            infoBox("Its already reviewed.", "Success", null);
        }

    }

    public void profileClicked(){

        try {


            VarFailure.EngineNo=locoNumber.getText();
            Parent root = FXMLLoader.load(getClass().getResource("FailureFullProfile.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Sri Lanka Railways Motive Power sub Department - Engine Failure management System");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setResolvedColor(String bool){
        if(bool.equals("0")){
            resolvedOrNot.setStyle("-fx-background-color: #E74C3C; -fx-text-fill: white; -fx-font-size: 14;");
            resolvedOrNot.setText("No one has reviewed");
            resolvedOrNot.setLayoutX(5.0); resolvedOrNot.setLayoutY(9.0); resolvedOrNot.prefHeight(32.0); resolvedOrNot.prefWidth(118.0);
        }
        else if(bool.equals("1")){
            resolvedOrNot.setStyle("-fx-background-color: #A569BD; -fx-text-fill: white; -fx-font-size: 14;");
            resolvedOrNot.setText("Foreman has not reviewed");
            resolvedOrNot.setLayoutX(5.0); resolvedOrNot.setLayoutY(9.0); resolvedOrNot.prefHeight(32.0); resolvedOrNot.prefWidth(118.0);
        }

        else if(bool.equals("2")){
            resolvedOrNot.setStyle("-fx-background-color: #85929E; -fx-text-fill: white; -fx-font-size: 14;");
            resolvedOrNot.setText("ATE has not reviewed");
            resolvedOrNot.setLayoutX(5.0); resolvedOrNot.setLayoutY(9.0); resolvedOrNot.prefHeight(32.0); resolvedOrNot.prefWidth(118.0);
        }

        else if(bool.equals("3")){
            resolvedOrNot.setStyle("-fx-background-color: #F4D03F ; -fx-text-fill: white; -fx-font-size: 11;");
            resolvedOrNot.setText("Chief Engineer has not reviewed");
            resolvedOrNot.setLayoutX(5.0); resolvedOrNot.setLayoutY(9.0); resolvedOrNot.prefHeight(32.0); resolvedOrNot.prefWidth(118.0);
        }

        else {
            resolvedOrNot.setStyle("-fx-background-color: #66BB6A; -fx-text-fill: white; -fx-font-size: 14;");
            resolvedOrNot.setText("Failure Resolved");
            resolvedOrNot.setLayoutX(5.0); resolvedOrNot.setLayoutY(9.0); resolvedOrNot.prefHeight(32.0); resolvedOrNot.prefWidth(118.0);
        }
    }

    public AnchorPane createFailureProfile() {

        anchor.prefHeight(250.0); anchor.prefWidth(300.0); anchor.setStyle("-fx-background-radius: 3; -fx-border-radius: 3; -fx-border-color: #c3c3c3;");

        locoNumber.setLayoutX(40.0); locoNumber.setLayoutY(14.0); locoNumber.prefHeight(30.0); locoNumber.prefWidth(246.0); locoNumber.setStyle("-fx-text-fill: #73879C; -fx-font-size: 20; -fx-font-weight: bold");
        MaterialDesignIconView mDiv = new MaterialDesignIconView();
        mDiv.setFill(Paint.valueOf("#73879c"));
        mDiv.setGlyphName("TRAIN");
        mDiv.setSize("16.0");
        mDiv.setWrappingWidth(21.0);
        locoNumber.setGraphic(mDiv);

        date.setLayoutX(30.0); date.setLayoutY(52.0); date.prefHeight(30.0); date.prefWidth(246.0); date.setStyle("-fx-text-fill: #73879C; -fx-font-weight: bold;");
        MaterialDesignIconView fAit = new MaterialDesignIconView();
        fAit.setFill(Paint.valueOf("#73879c"));
        fAit.setGlyphName("CALENDAR_TODAY");
        fAit.setSize("16.0");
        fAit.setWrappingWidth(22.0);
        date.setGraphic(fAit);

        time.setLayoutX(30.0); time.setLayoutY(82.0); time.prefHeight(30.0); time.prefWidth(246.0); time.setStyle("-fx-text-fill: #73879C; -fx-font-weight: bold;");
        FontAwesomeIconView fAis = new FontAwesomeIconView();
        fAis.setFill(Paint.valueOf("#73879c"));
        fAis.setGlyphName("HOURGLASS_3");
        fAis.setSize("16.0");
        fAis.setWrappingWidth(22.0);
        time.setGraphic(fAis);

        recordedEmployee.setLayoutX(30.0); recordedEmployee.setLayoutY(112.0); recordedEmployee.prefHeight(30.0); recordedEmployee.prefWidth(246.0); recordedEmployee.setStyle("-fx-text-fill: #73879C; -fx-font-weight: bold;");
        FontAwesomeIconView fAiv = new FontAwesomeIconView();
        fAiv.setFill(Paint.valueOf("#73879c"));
        fAiv.setGlyphName("USER");
        fAiv.setSize("16.0");
        fAiv.setWrappingWidth(22.0);
        recordedEmployee.setGraphic(fAiv);

        place.setLayoutX(30.0); place.setLayoutY(142.0); place.prefHeight(30.0); place.prefWidth(246.0); place.setStyle("-fx-text-fill: #73879C; -fx-font-weight: bold;");
        FontAwesomeIconView fAvi = new FontAwesomeIconView();
        fAvi.setFill(Paint.valueOf("#73879c"));
        fAvi.setGlyphName("FLAG");
        fAvi.setSize("16.0");
        fAvi.setWrappingWidth(22.0);
        place.setGraphic(fAvi);

        failureType.setLayoutX(30.0); failureType.setLayoutY(172.0); failureType.prefHeight(30.0); failureType.prefWidth(246.0); failureType.setStyle("-fx-text-fill: #73879C; -fx-font-weight: bold;");
        FontAwesomeIconView fAviv = new FontAwesomeIconView();
        fAviv.setFill(Paint.valueOf("#73879c"));
        fAviv.setGlyphName("EXCLAMATION_TRIANGLE");
        fAviv.setSize("16.0");
        fAviv.setWrappingWidth(22.0);
        failureType.setGraphic(fAviv);



        pane.setLayoutY(200.0); pane.prefHeight(50.0); pane.prefWidth(300.0); pane.setStyle("-fx-border-radius: 0 0 3 3; -fx-background-color: #E5E8EB; -fx-border-color: #C3C3C3; -fx-border-width: 1 0 0 1;");
        profile.setLayoutX(200.0); profile.setLayoutY(9.0); profile.prefHeight(32.0); profile.prefWidth(118.0); profile.setStyle("-fx-background-color: #337AB7; -fx-text-fill: white; -fx-font-size: 14;");
        profile.setText("More");

        resolvedOrNot.setOnAction(e->{
            try {
                resolvedOrNotClicked();
            } catch (JSONException e1) {
                e1.printStackTrace();
            }
        });

        profile.setOnAction(e->{
            try {
                profileClicked();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        pane.getChildren().addAll(profile,space,resolvedOrNot);

        anchor.getChildren().addAll(locoNumber, date, time, place, recordedEmployee, failureType, pane);

        return anchor;
    }


    public void setID(String ID) {
        this.ID.setText(ID);
    }

}
