package UI.Dashboard.Employee;

/**
 * Created by Thisun Pathirage on 10/13/2017.
 */

import UI.Dashboard.Locomotive.VarLoco;
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
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

import java.io.IOException;

public class EmployeeProfile {

    private AnchorPane anchor =  new AnchorPane();
    private Label employee_ID = new Label();
    private Label profession = new Label();
    private Label name = new Label();
    private Label age = new Label();

    private Pane pane = new Pane();
    private JFXButton profile = new JFXButton();
    private ImageView imageView = new ImageView();


    public void setEmployee_ID(String employee_ID) {this.employee_ID.setText(employee_ID);
    }

    public void setProfession(String profession) {
        this.profession.setText(profession);
    }

    public void setName(String name) {
        this.name.setText(name);
    }

    public void setAge(int age) { this.age.setText(String.valueOf(age)); }



    public void setTrueImage(String url){
        if(url=="UI/Images/emp.jpg"){
            imageView.setFitHeight(100.0); imageView.setFitWidth(100.0); imageView.setLayoutX(160.0); imageView.setLayoutY(50.0); imageView.setPickOnBounds(true); imageView.setPreserveRatio(true);
        }
        else {
            imageView.setFitHeight(125.0); imageView.setFitWidth(125.0); imageView.setLayoutX(148.0); imageView.setLayoutY(40.0); imageView.setPickOnBounds(true); imageView.setPreserveRatio(true);
        }
        Image img = new Image(url);
        imageView.setImage(img);

    }

    public AnchorPane profileClicked(){

        /*try {

            VarEmp.EmpID= employee_ID.getText();
            System.out.println(VarEmp.EmpID);

            Parent root = FXMLLoader.load(getClass().getResource("locomotiveProfile.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Sri Lanka Railways Motive Power sub Department - Engine Failure management System");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        return null;
    }

    public AnchorPane createEmpProfile() {

        anchor.prefHeight(250.0); anchor.prefWidth(300.0); anchor.setStyle("-fx-background-radius: 3; -fx-border-radius: 3; -fx-border-color: #c3c3c3;");

        employee_ID.setLayoutX(14.0); employee_ID.setLayoutY(14.0); employee_ID.prefHeight(30.0); employee_ID.prefWidth(246.0); employee_ID.setStyle("-fx-text-fill: #73879C; -fx-font-size: 18");

        profession.setLayoutX(30.0); profession.setLayoutY(52.0); profession.prefHeight(30.0); profession.prefWidth(246.0); profession.setStyle("-fx-text-fill: #73879C; -fx-font-weight: bold;");
        MaterialDesignIconView fAit = new MaterialDesignIconView();
        fAit.setFill(Paint.valueOf("#73879c"));
        fAit.setGlyphName("TRAIN");
        fAit.setSize("16.0");
        fAit.setWrappingWidth(22.0);
        profession.setGraphic(fAit);

        name.setLayoutX(30.0); name.setLayoutY(82.0); name.prefHeight(30.0); name.prefWidth(246.0); name.setStyle("-fx-text-fill: #73879C; -fx-font-weight: bold;");
        FontAwesomeIconView fAis = new FontAwesomeIconView();
        fAis.setFill(Paint.valueOf("#73879c"));
        fAis.setGlyphName("SPINNER");
        fAis.setSize("16.0");
        fAis.setWrappingWidth(22.0);
        name.setGraphic(fAis);

        age.setLayoutX(30.0); age.setLayoutY(125.0); age.prefHeight(30.0); age.prefWidth(246.0); age.setStyle("-fx-text-fill: #73879C; -fx-font-weight: bold;");
        FontAwesomeIconView fAiv = new FontAwesomeIconView();
        fAiv.setFill(Paint.valueOf("#73879c"));
        fAiv.setGlyphName("HOME");
        fAiv.setSize("16.0");
        fAiv.setWrappingWidth(22.0);
        age.setGraphic(fAiv);



        pane.setLayoutY(200.0); pane.prefHeight(50.0); pane.prefWidth(300.0); pane.setStyle("-fx-border-radius: 0 0 3 3; -fx-background-color: #E5E8EB; -fx-border-color: #C3C3C3; -fx-border-width: 1 0 0 1;");

        profile.setOnAction(e -> {
            profileClicked();
        });

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

        anchor.getChildren().addAll(employee_ID, profession, name, age, pane, circle, imageView);


        profile.setOnAction(e->{
            profileClicked();
        });

        return anchor;
    }



}

