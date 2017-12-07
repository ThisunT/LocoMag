package UI.Index;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import UI.Dashboard.Failure.FailureViewer;
import UI.Dashboard.Locomotive.LocomotiveViewer;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 * Created by Thisun Pathirage on 9/7/2017.
 */
public class IndexController implements Initializable{

    @FXML
    public  AnchorPane holderPane;

    @FXML
    public AnchorPane home;

    @FXML
    public AnchorPane failures;

    @FXML
    public AnchorPane schedule;

    @FXML
    public AnchorPane locomotives,trips,delays,maintenance, employees, locoposition;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Load all fxmls in a cache
        try {
            home = FXMLLoader.load(getClass().getResource("home.fxml"));
            schedule = FXMLLoader.load(getClass().getResource("../Dashboard/Schedule/schedule.fxml"));
            //trips = FXMLLoader.load(getClass().getResource("Pricing.fxml"));
            //delays = FXMLLoader.load(getClass().getResource("Profiles.fxml"));
            //schedule = FXMLLoader.load(getClass().getResource("Widgets.fxml"));
            //maintenance = FXMLLoader.load(getClass().getResource("Controls.fxml"));
            //employees = FXMLLoader.load(getClass().getResource("Controls.fxml"));
            //locoposition = FXMLLoader.load(getClass().getResource("Controls.fxml"));
            //setNode(home);

        } catch (IOException ex) {
            Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Set selected node to a content holder

    public void transPane(){
        holderPane.getChildren().clear();
    }

    private void setNode(Node node) {
        holderPane.getChildren().clear();
        holderPane.getChildren().add((Node) node);


        FadeTransition ft = new FadeTransition(Duration.millis(500));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }

    private void setNodeLoco(){
        LocomotiveViewer locoView = new LocomotiveViewer();
        AnchorPane locoViewerAnchor = new AnchorPane();
        locoViewerAnchor.getChildren().add(locoView.pages());
        holderPane.getChildren().clear();
        holderPane.getChildren().add(locoViewerAnchor);

        FadeTransition ft = new FadeTransition(Duration.millis(1000));
        ft.setNode(locoViewerAnchor);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }

    private void setNodeFailure(){
        FailureViewer failureViewer = new FailureViewer();
        AnchorPane failureViewerAnchor = new AnchorPane();
        failureViewerAnchor.getChildren().add(failureViewer.pages());
        holderPane.getChildren().clear();
        holderPane.getChildren().add(failureViewerAnchor);

        FadeTransition ft = new FadeTransition(Duration.millis(1000));
        ft.setNode(failureViewerAnchor);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }



    @FXML
    private void switchLocomotives(ActionEvent event) {
        setNodeLoco();
    }

    @FXML
    private void switchHome(ActionEvent event) {
        setNode(home);
    }

    /*@FXML
    private void switchContacts(ActionEvent event) {
        setNode(contacts);
    }
    @FXML
    private void switchWidget(ActionEvent event) {
        setNode(widgets);
    }
    @FXML
    private void switchProfile(ActionEvent event) {
        setNode(profiles);
    }
    @FXML
    private void switchAlert(ActionEvent event) {
        setNode(alerts);
    }
    @FXML
    private void switchControls(ActionEvent event) {
        setNode(controls);
    }
    */

    /*@FXML
    private void switchTab(ActionEvent event){
        transPane();
    }*/

    @FXML
    private void switchFailures(ActionEvent event){
        try {

            setNodeFailure();
        }
        catch (Exception e){
            System.out.println("vv");
        }

    }

    @FXML
    private void switchSchedule(ActionEvent event){
        try {

            setNode(schedule);
        }
        catch (Exception e){
            System.out.println("vv");
        }

    }
}