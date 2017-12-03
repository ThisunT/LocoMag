package UI.Dashboard.Locomotive;

/**
 * Created by Thisun Pathirage on 10/13/2017.
 */
import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import de.jensd.fx.glyphs.materialicons.MaterialIconView;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.ImageView;

public class LocoProfile {

    private AnchorPane anchor =  new AnchorPane();
    private Label locoNumber = new Label();
    private Label locoType = new Label();
    private Label locoState = new Label();
    private Label locoPosition = new Label();
    private Label manufacturer = new Label();
    private Pane pane = new Pane();
    private JFXButton profile = new JFXButton();
    private ImageView imageView = new ImageView();

    public void setLocoNumber(int locoNumber) {
        this.locoNumber.setText(Integer.toString(locoNumber));
    }

    public void setLocoType(String locoType) {
        this.locoType.setText(locoType);
    }

    public void setLocoState(String locoState) {
        this.locoState.setText(locoState);
    }

    public void setLocoPosition(String locoPosition) {
        this.locoPosition.setText(locoPosition);
    }

    public void setTrueImage(String url){
        if(url=="UI/Images/train.png"){
            imageView.setFitHeight(100.0); imageView.setFitWidth(100.0); imageView.setLayoutX(160.0); imageView.setLayoutY(50.0); imageView.setPickOnBounds(true); imageView.setPreserveRatio(true);
        }
        else {
            imageView.setFitHeight(125.0); imageView.setFitWidth(125.0); imageView.setLayoutX(148.0); imageView.setLayoutY(40.0); imageView.setPickOnBounds(true); imageView.setPreserveRatio(true);
        }
        Image img = new Image(url);
        imageView.setImage(img);

    }

    public AnchorPane createLocoProfile() {

        anchor.prefHeight(250.0); anchor.prefWidth(300.0); anchor.setStyle("-fx-background-radius: 3; -fx-border-radius: 3; -fx-border-color: #c3c3c3;");

        locoNumber.setLayoutX(14.0); locoNumber.setLayoutY(14.0); locoNumber.prefHeight(30.0); locoNumber.prefWidth(246.0); locoNumber.setStyle("-fx-text-fill: #73879C; -fx-font-size: 18");

        locoType.setLayoutX(30.0); locoType.setLayoutY(52.0); locoType.prefHeight(30.0); locoType.prefWidth(246.0); locoType.setStyle("-fx-text-fill: #73879C; -fx-font-weight: bold;");
        MaterialDesignIconView fAit = new MaterialDesignIconView();
        fAit.setFill(Paint.valueOf("#73879c"));
        fAit.setGlyphName("TRAIN");
        fAit.setSize("16.0");
        fAit.setWrappingWidth(22.0);
        locoType.setGraphic(fAit);

        locoState.setLayoutX(30.0); locoState.setLayoutY(82.0); locoState.prefHeight(30.0); locoState.prefWidth(246.0); locoState.setStyle("-fx-text-fill: #73879C; -fx-font-weight: bold;");
        FontAwesomeIconView fAis = new FontAwesomeIconView();
        fAis.setFill(Paint.valueOf("#73879c"));
        fAis.setGlyphName("SPINNER");
        fAis.setSize("16.0");
        fAis.setWrappingWidth(22.0);
        locoState.setGraphic(fAis);

        locoPosition.setLayoutX(30.0); locoPosition.setLayoutY(125.0); locoPosition.prefHeight(30.0); locoPosition.prefWidth(246.0); locoPosition.setStyle("-fx-text-fill: #73879C; -fx-font-weight: bold;");
        FontAwesomeIconView fAiv = new FontAwesomeIconView();
        fAiv.setFill(Paint.valueOf("#73879c"));
        fAiv.setGlyphName("HOME");
        fAiv.setSize("16.0");
        fAiv.setWrappingWidth(22.0);
        locoPosition.setGraphic(fAiv);

        pane.setLayoutY(200.0); pane.prefHeight(50.0); pane.prefWidth(300.0); pane.setStyle("-fx-border-radius: 0 0 3 3; -fx-background-color: #E5E8EB; -fx-border-color: #C3C3C3; -fx-border-width: 1 0 0 1;");
        profile.setLayoutX(168.0); profile.setLayoutY(9.0); profile.prefHeight(32.0); profile.prefWidth(118.0); profile.setStyle("-fx-background-color: #337AB7; -fx-text-fill: white; -fx-font-size: 14;");
        profile.setText("View Profile");
        MaterialDesignIconView mDiv = new MaterialDesignIconView();
        mDiv.setFill(Paint.valueOf("#fffdfd"));
        mDiv.setGlyphName("TRAIN");
        mDiv.setSize("16.0");
        mDiv.setWrappingWidth(21.0);
        profile.setGraphic(mDiv);

        pane.getChildren().add(profile);

        Circle circle = new Circle();
        circle.setFill(Paint.valueOf("#e5e8eb")); circle.setLayoutX(210.0); circle.setLayoutY(104.0); circle.setRadius(70.0); circle.setStroke(Paint.valueOf("#c3c3c3")); circle.setStrokeType(StrokeType.INSIDE);

        anchor.getChildren().addAll(locoNumber, locoType, locoState, locoPosition, pane, circle, imageView);

        return anchor;
    }
}

