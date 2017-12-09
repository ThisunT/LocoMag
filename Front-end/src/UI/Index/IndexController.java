package UI.Index;

import UI.Dashboard.Locomotive.LocomotiveViewer;
import UI.setGlobals;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Thisun Pathirage on 9/7/2017.
 */
public class IndexController implements Initializable{

    @FXML
    public  AnchorPane holderPane;

    @FXML
    private Label labl_username;

    @FXML
    public AnchorPane home,failures,schedule,locomotives,trips,delays,maintenance, employees, locoposition, locoBase,report;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Load all fxmls in a cache
        String switchUser = (setGlobals.user).substring(0,1);


        if (switchUser.equals("F")) {
            labl_username.setText("Foreman");
            try {
                home = FXMLLoader.load(getClass().getResource("home.fxml"));
                try {
                    locoBase = FXMLLoader.load(getClass().getResource("../Dashboard/emptyView.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                setNodeLoco(locoBase);
                locomotives = locoBase;
                failures = FXMLLoader.load(getClass().getResource("../Foreman/Failure/failureTab.fxml"));
                trips = FXMLLoader.load(getClass().getResource("../Foreman/Trip/AddTrip.fxml"));
                delays = FXMLLoader.load(getClass().getResource("../Dashboard/emptyView.fxml"));
                schedule = FXMLLoader.load(getClass().getResource("../Dashboard/Schedule/schedule.fxml"));
                maintenance = FXMLLoader.load(getClass().getResource("../Foreman/Maintenance/maintenanceTab.fxml"));
                employees = FXMLLoader.load(getClass().getResource("../Foreman/Employee/employeeView.fxml"));
                locoposition = FXMLLoader.load(getClass().getResource("../Foreman/LocoPosition/locoPositionTab.fxml"));
                report= FXMLLoader.load(getClass().getResource("../Dashboard/Reports/reportView.fxml"));


            } catch (IOException ex) {
                Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


        else if (switchUser.equals("A")) {
            labl_username.setText("ATE");
            try {
                home = FXMLLoader.load(getClass().getResource("home.fxml"));
                locomotives = FXMLLoader.load(getClass().getResource("../ATE/AddLoco/locoTab.fxml"));
                trips = FXMLLoader.load(getClass().getResource("../Dashboard/emptyView.fxml"));
                delays = FXMLLoader.load(getClass().getResource("../Dashboard/emptyView.fxml"));
                failures = FXMLLoader.load(getClass().getResource("../Dashboard/emptyView.fxml"));
                schedule = FXMLLoader.load(getClass().getResource("../Dashboard/Schedule/schedule.fxml"));
                maintenance = FXMLLoader.load(getClass().getResource("../Dashboard/emptyView.fxml"));
                employees = FXMLLoader.load(getClass().getResource("../ATE/Employee/employeeTab.fxml"));
                locoposition = FXMLLoader.load(getClass().getResource("../Dashboard/emptyView.fxml"));
                report= FXMLLoader.load(getClass().getResource("../Dashboard/Reports/reportView.fxml"));


            } catch (IOException ex) {
                Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        else if (switchUser.equals("C")) {
            labl_username.setText("Chief Engineer");
            try {
                home = FXMLLoader.load(getClass().getResource("home.fxml"));
                trips = FXMLLoader.load(getClass().getResource("../Dashboard/emptyView.fxml"));
                delays = FXMLLoader.load(getClass().getResource("../Dashboard/emptyView.fxml"));
                locomotives = FXMLLoader.load(getClass().getResource("../ChiefEngineer/Locomotive/locoTab.fxml"));
                failures = FXMLLoader.load(getClass().getResource("../Dashboard/emptyView.fxml"));
                schedule = FXMLLoader.load(getClass().getResource("../Dashboard/Schedule/schedule.fxml"));
                maintenance = FXMLLoader.load(getClass().getResource("../Dashboard/emptyView.fxml"));
                employees = FXMLLoader.load(getClass().getResource("../Dashboard/emptyView.fxml"));
                locoposition = FXMLLoader.load(getClass().getResource("../Dashboard/emptyView.fxml"));
                report= FXMLLoader.load(getClass().getResource("../Dashboard/Reports/reportView.fxml"));


            } catch (IOException ex) {
                Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
            }
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



    @FXML
    private void switchLocomotives(ActionEvent event) {
        setNode(locomotives);
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
    private void switchFailures(ActionEvent event){setNode(failures);}

    @FXML
    private void switchSchedule(ActionEvent event){setNode(schedule);}

    @FXML
    private void switchTrips(ActionEvent event){ setNode(trips);}

    @FXML
    private void switchMaintenance(ActionEvent event){ setNode(maintenance);}

    @FXML
    private void switchLocoPosition(ActionEvent event){ setNode(locoposition);}

    @FXML
    private void switchEmployee(ActionEvent event){ setNode(employees);}


    @FXML
    private void switchReports(ActionEvent event){ setNode(report);}



    @FXML
    private void logoutPressed(ActionEvent event) throws Exception{
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Logout ");
        alert.setContentText("Are you sure you want to logout?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
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