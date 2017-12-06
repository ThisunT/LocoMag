package UI.Dashboard.Failure;

import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;

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
    private Pane pane = new Pane();
    private JFXButton profile = new JFXButton();
    private JFXButton resolvedOrNot = new JFXButton();

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

    public void setResolvedColor(String bool){
        if(bool=="1"){
            resolvedOrNot.setStyle("-fx-background-color: #66BB6A; -fx-text-fill: white; -fx-font-size: 14;");
            resolvedOrNot.setText("Failure Resolved");
            resolvedOrNot.setLayoutX(10.0); resolvedOrNot.setLayoutY(9.0); resolvedOrNot.prefHeight(32.0); resolvedOrNot.prefWidth(118.0);
        }
        else {
            resolvedOrNot.setStyle("-fx-background-color: #EF5350   ; -fx-text-fill: white; -fx-font-size: 14;");
            resolvedOrNot.setText("Not Resolved Yet");
            resolvedOrNot.setLayoutX(10.0); resolvedOrNot.setLayoutY(9.0); resolvedOrNot.prefHeight(32.0); resolvedOrNot.prefWidth(118.0);
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
        profile.setLayoutX(168.0); profile.setLayoutY(9.0); profile.prefHeight(32.0); profile.prefWidth(118.0); profile.setStyle("-fx-background-color: #337AB7; -fx-text-fill: white; -fx-font-size: 14;");
        profile.setText("View More");


        pane.getChildren().addAll(profile,resolvedOrNot);

        anchor.getChildren().addAll(locoNumber, date, time, place, recordedEmployee, failureType, pane);

        return anchor;
    }



}
