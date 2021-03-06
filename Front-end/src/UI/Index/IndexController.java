package UI.Index;

import Connection.DBReader;
import Connection.GetRequest;
import Connection.Synchronising;
import Connection.Update;
import UI.Dashboard.Employee.EmployeeViewer;
import UI.Dashboard.Failure.FailureViewer;
import UI.Dashboard.Locomotive.LocomotiveViewer;
import UI.Dashboard.Maintenance.MaintenanceViewer;
import UI.Dashboard.Trips.TripViewer;
import UI.setGlobals;
import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.json.JSONArray;
import org.json.JSONException;

import javax.rmi.CORBA.Util;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import static UI.loginController.infoBox;

/**
 * Created by Thisun Pathirage on 9/7/2017.
 */
public class IndexController implements Initializable{

    @FXML
    public  AnchorPane holderPane;

    @FXML
    public Pane searchPane;

    @FXML
    public JFXButton btnSearchDummy, btnSync;

    @FXML
    public ComboBox searchField;

    @FXML
    public ComboBox searchBy;

    @FXML
    public TextField searchValue;

    @FXML
    private Label labl_username;

    @FXML
    public AnchorPane home,failures,schedule,locomotives,trips,delays,maintenance, employees, locoposition, locoBase,report;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //Starting synchronise thread

        Synchronising synchronising = new Synchronising();
        synchronising.synchronise();

        //Starting listening to synchronise thread
        Timeline fiveSecondsWonder = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    if (synchronising.synId == Integer.parseInt(DBReader.syncState())){
                        btnSync.setStyle("-fx-background-color: #388E3C ");
                        btnSync.setText("Updated");
                    }
                    else{
                        btnSync.setStyle("-fx-background-color: #EC7063");
                        btnSync.setText("Updates Available");
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }));
        fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);
        fiveSecondsWonder.play();



        //selecting the user
        String switchUser = (setGlobals.user).substring(0,1);

<<<<<<< HEAD
        //Load all fxmls in a cache
=======
        try {
            schedule = FXMLLoader.load(getClass().getResource("../Dashboard/Schedule/schedule.fxml"));
            locoposition = FXMLLoader.load(getClass().getResource("../Foreman/LocoPosition/locoPositionSet.fxml"));
            report= FXMLLoader.load(getClass().getResource("../Dashboard/Reports/reportView.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

>>>>>>> f7e7e983095ab0bed350bb6e449c1dac2d9d8c2b
        if (switchUser.equals("F")) {
            labl_username.setText("Foreman");
            try {
                home = FXMLLoader.load(getClass().getResource("../Foreman/foremanTab.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


        else if (switchUser.equals("A")) {
            labl_username.setText("ATE");
            try {
                home = FXMLLoader.load(getClass().getResource("../ATE/ATETab.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        else if (switchUser.equals("C")) {
            labl_username.setText("Chief Engineer");
            try {
                home = FXMLLoader.load(getClass().getResource("../ChiefEngineer/chiefTab.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }

    //Set selected node to a content holder

    @FXML
    private void switchLocomotives(ActionEvent event) {
        searchPane.setVisible(false);
        setNodeLoco();
    }

    @FXML
    private void switchHome(ActionEvent event) {
        searchPane.setVisible(false);
        setNode(home);
    }


    @FXML
    private void switchFailures(ActionEvent event){
        setNodeFailure();
    }

    @FXML
    private void switchSchedule(ActionEvent event){
        searchPane.setVisible(false);
        setNode(schedule);}

    @FXML
    private void switchTrips(ActionEvent event){
        searchPane.setVisible(false);
        setNodeTrips();}



    @FXML
    private void switchMaintenance(ActionEvent event){
        searchPane.setVisible(false);
        setNodeMaintenance();}

    @FXML
    private void switchLocoPosition(ActionEvent event){
        searchPane.setVisible(false);
        setNode(locoposition);}

    @FXML
    private void switchDelays(ActionEvent event){
        searchPane.setVisible(false);
        setNodeTrips();}

    @FXML
    private void switchEmployee(ActionEvent event){
        searchPane.setVisible(false);
        setNodeEmployee();}


    @FXML
    private void switchReports(ActionEvent event){
        searchPane.setVisible(false);
        setNode(report);}

    @FXML
    private void syncButtonClicked(ActionEvent event){
        Update.updateAll();
        infoBox("Update Successful", "Success", null);
    }

    //Changing the anchorpane set to the holderpane

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

    public void setNodeFailure(){

        FailureViewer failureViewer = new FailureViewer();
        AnchorPane failureViewereAnchor = new AnchorPane();
        failureViewereAnchor.getChildren().add(failureViewer.pages());
        holderPane.getChildren().clear();
        holderPane.getChildren().add(failureViewereAnchor);

        FadeTransition ft = new FadeTransition(Duration.millis(1000));
        ft.setNode(failureViewereAnchor);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }

    public void setNodeTrips(){

        TripViewer tripViewer = new TripViewer();
        AnchorPane tripViewereAnchor = new AnchorPane();
        tripViewereAnchor.getChildren().add(tripViewer.pages());
        holderPane.getChildren().clear();
        holderPane.getChildren().add(tripViewereAnchor);

        FadeTransition ft = new FadeTransition(Duration.millis(1000));
        ft.setNode(tripViewereAnchor);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }

    public void setNodeMaintenance(){

        MaintenanceViewer maintenanceViewer = new MaintenanceViewer();
        AnchorPane maintenanceViewerAnchor = new AnchorPane();
        maintenanceViewerAnchor.getChildren().add(maintenanceViewer.pages());
        holderPane.getChildren().clear();
        holderPane.getChildren().add(maintenanceViewerAnchor);

        FadeTransition ft = new FadeTransition(Duration.millis(1000));
        ft.setNode(maintenanceViewerAnchor);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }

    public  void setNodeEmployee(){

        EmployeeViewer employeeView = new EmployeeViewer();
        AnchorPane employeeViewerAnchor = new AnchorPane();
        employeeViewerAnchor.getChildren().add(employeeView.pages());

        holderPane.getChildren().clear();
        holderPane.getChildren().add(employeeViewerAnchor);

        FadeTransition ft = new FadeTransition(Duration.millis(1000));
        ft.setNode(employeeViewerAnchor);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }


    public static void setNodeLoco(AnchorPane loco){

        LocomotiveViewer locoView = new LocomotiveViewer();
        AnchorPane locoViewerAnchor = new AnchorPane();
        locoViewerAnchor.getChildren().add(locoView.pages());
        loco.getChildren().clear();
        loco.getChildren().add(locoViewerAnchor);

        FadeTransition ft = new FadeTransition(Duration.millis(1000));
        ft.setNode(locoViewerAnchor);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }

    public void setNodeLoco(){
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

    //Start of the coding of search function

    boolean visibility = false;

    @FXML
    private void searchDummyClicked(){
        if(!visibility){
            searchPane.setVisible(true);
            visibility=true;
        }
        else {
            searchPane.setVisible(false);
            visibility = false;
        }

    }

    @FXML
    private void searchByCompositeClicked(){
        if(searchBy.getValue().toString().equals("SeachBy")){

        }
        else if(searchBy.getValue().toString().equals("Locomotives")){
            ObservableList<String> list = FXCollections.observableArrayList("EngineNumber","EngineType","Shed","State");
            searchField.setItems(list);
        }

        else if(searchBy.getValue().toString().equals("Failures")){
            ObservableList<String> list = FXCollections.observableArrayList("ID","loco_ID","failure_ID","trip_ID","nearest_yard");
            searchField.setItems(list);
        }

        else if(searchBy.getValue().toString().equals("Employees")){
            ObservableList<String> list = FXCollections.observableArrayList("employee_ID","profession","nic");
            searchField.setItems(list);
        }

        else if(searchBy.getValue().toString().equals("Trips")){
            ObservableList<String> list = FXCollections.observableArrayList("ID","route_ID","loco_ID","driver_ID","");
            searchField.setItems(list);
        }
    }

    @FXML
    private void btnSearchClicked(){
        if(searchBy.getValue().toString().equals("SearchBy")){

        }
        else if(searchBy.getValue().toString().equals("Locomotives")){
            LocomotiveViewer locomotiveViewer = new LocomotiveViewer();
            if (searchField.getValue().toString().equals("") || searchValue.getText().equals("")){
                setNode(locomotiveViewer.pages(DBReader.returnLocomotives()));
            }
            else {
                JSONArray response1=DBReader.readByFields("Locomotives", searchField.getValue().toString(), searchValue.getText());
                if(response1.toString().equals("[]")){
                    AnchorPane emptyResponse = new AnchorPane(); emptyResponse.setPrefHeight(400.0); emptyResponse.setPrefWidth(600.0);
                    Label label = new Label("Error 404: Files not found"); label.setLayoutY(122.0); label.setLayoutX(120.0); label.setPrefHeight(122.0); label.setPrefWidth(375.0); label.setStyle("-fx-font-size: 28");
                    emptyResponse.getChildren().add(label);
                    setNode(emptyResponse);
                }
                else {
                    setNode(locomotiveViewer.pages(response1));
                }
            }

        }
        else if(searchBy.getValue().toString().equals("Failures")){
            FailureViewer failureViewer = new FailureViewer();
            if (searchField.getValue().toString().equals("") || searchValue.getText().equals("")){
                setNode(failureViewer.pages(DBReader.returnFailures()));
            }else {
                JSONArray response = DBReader.readByFields("Failures",searchField.getValue().toString(),searchValue.getText());
                if(response.toString().equals("[]")){
                    AnchorPane emptyResponse = new AnchorPane(); emptyResponse.setPrefHeight(400.0); emptyResponse.setPrefWidth(600.0);
                    Label label = new Label("Error 404: Files not found"); label.setLayoutY(122.0); label.setLayoutX(120.0); label.setPrefHeight(122.0); label.setPrefWidth(375.0); label.setStyle("-fx-font-size: 28");
                    emptyResponse.getChildren().add(label);
                    setNode(emptyResponse);
                }
                else {
                    setNode(failureViewer.pages(response));
                }
            }
        }
        /*
        else if(searchBy.getValue().toString().equals("Employees")){
            if (searchField.getValue().toString().equals("") || searchValue.getText().equals("")){
                setNode(LocomotiveViewer.pages(DBReader.returnLocomotives()));
            }else {
                JSONArray response = DBReader.readByFields("Employees",searchField.getValue().toString(),searchValue.getText());
                if(response.toString().equals("[]")){
                    AnchorPane emptyResponse = new AnchorPane(); emptyResponse.setPrefHeight(400.0); emptyResponse.setPrefWidth(600.0);
                    Label label = new Label("Error 404: Files not found"); label.setLayoutY(122.0); label.setLayoutX(120.0); label.setPrefHeight(122.0); label.setPrefWidth(375.0); label.setStyle("-fx-font-size: 28");
                    emptyResponse.getChildren().add(label);
                    setNode(emptyResponse);
                }
                else {
                    setNode(employeeViewer.pages(response));
                }
            }
        }

        else if(searchBy.getValue().toString().equals("Trips")){
            if (searchField.getValue().toString().equals("") || searchValue.getText().equals("")){
                setNode(TripViewer.pages(DBReader.returnTrips()));
            }else {
                JSONArray response = DBReader.readByFields("Trips",searchField.getValue().toString(),searchValue.getText());
                if(response.toString().equals("[]")){
                    AnchorPane emptyResponse = new AnchorPane(); emptyResponse.setPrefHeight(400.0); emptyResponse.setPrefWidth(600.0);
                    Label label = new Label("Error 404: Files not found"); label.setLayoutY(122.0); label.setLayoutX(120.0); label.setPrefHeight(122.0); label.setPrefWidth(375.0); label.setStyle("-fx-font-size: 28");
                    emptyResponse.getChildren().add(label);
                    setNode(emptyResponse);
                }
                else {
                    setNode(tripViewer.pages(response));
                }
            }
        }*/
    }



    //Logout code

    @FXML
    private void logoutPressed(ActionEvent event) throws Exception{
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Logout ");
        alert.setContentText("Are you sure you want to logout?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("../login.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Login");
            stage.show();
        } else {
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("index.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Sri Lanka Railways Motive Power sub Department - Engine Failure management System");
            stage.show();
        }


    }


}