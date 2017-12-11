package UI.Dashboard.Maintenance;

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
public class MaintenanceProfile {

    private AnchorPane anchor =  new AnchorPane();
    private Label locoNumber = new Label();
    private Label routeID = new Label();
    private Label driverId = new Label();
    private Label date = new Label();
    private Label tripDetails  = new Label();

    private Label time = new Label();

    public void setLocoNumber(String locoNumber) {
        this.locoNumber.setText(locoNumber);
    }

    public void setDate(String date) {
        this.date.setText(date);
    }

    public void setTime(String time) {
        this.time.setText(time);
    }


    public void setRouteID(String failureType) {
        this.routeID.setText(failureType);
    }

    public void setDriverId(String place) {
        this.driverId.setText(place);
    }

    public void setTripDetails(String place) {
        this.tripDetails.setText(place);
    }



    public AnchorPane createTripProfile() {

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

        driverId.setLayoutX(30.0); driverId.setLayoutY(112.0); driverId.prefHeight(30.0); driverId.prefWidth(246.0); driverId.setStyle("-fx-text-fill: #73879C; -fx-font-weight: bold;");
        FontAwesomeIconView fAiv = new FontAwesomeIconView();
        fAiv.setFill(Paint.valueOf("#73879c"));
        fAiv.setGlyphName("USER");
        fAiv.setSize("16.0");
        fAiv.setWrappingWidth(22.0);
        driverId.setGraphic(fAiv);

        tripDetails.setLayoutX(30.0); tripDetails.setLayoutY(172.0); tripDetails.prefHeight(30.0); tripDetails.prefWidth(246.0); tripDetails.setStyle("-fx-text-fill: #73879C; -fx-font-weight: bold;");
        FontAwesomeIconView fAviv = new FontAwesomeIconView();
        fAviv.setFill(Paint.valueOf("#73879c"));
        fAviv.setGlyphName("EXCLAMATION_TRIANGLE");
        fAviv.setSize("16.0");
        fAviv.setWrappingWidth(22.0);
        tripDetails.setGraphic(fAviv);


        anchor.getChildren().addAll(locoNumber, date, time, tripDetails, driverId);

        return anchor;
    }



}
