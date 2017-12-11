package UI.Dashboard.Maintenance;

import Connection.DBReader;
import javafx.scene.Node;
import javafx.scene.control.Pagination;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by Thisun Pathirage on 12/6/2017.
 */
public class MaintenanceViewer {
    Pagination pagination = new Pagination();

    public AnchorPane createPage(int numberOfObjects, int pageIndex, JSONArray failureResponse) {
        AnchorPane boxAnchor = new AnchorPane();
        boxAnchor.prefWidth(1090.0); boxAnchor.prefHeight(740.0); boxAnchor.setStyle("-fx-background-color: #f1f1f1;"); boxAnchor.setLayoutY(10.0);

        VBox box1 = new VBox(5);
        box1.setLayoutX(39.0); box1.setLayoutY(80.0); box1.setSpacing(15.0);
        boolean var = false;


        for (int i = pageIndex*6; i < 2+pageIndex*6; i++) {
            if(i==numberOfObjects){
                var = true;
                break;
            }
            else {
                VBox element = new VBox();
                MaintenanceProfile maintenanceProfile = new MaintenanceProfile();
                try {
                    maintenanceProfile.setLocoNumber(String.valueOf(failureResponse.getJSONObject(i).getInt("loco_ID")));
                    maintenanceProfile.setDate(failureResponse.getJSONObject(i).getString("date"));
                    maintenanceProfile.setRouteID(String.valueOf(failureResponse.getJSONObject(i).getInt("maintenance_ID")));
                    maintenanceProfile.setTripDetails(failureResponse.getJSONObject(i).getString("note"));
                    maintenanceProfile.setDriverId(failureResponse.getJSONObject(i).getString("suggestion"));
                } catch (JSONException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                AnchorPane obj = maintenanceProfile.createTripProfile();
                element.getChildren().add(obj);
                box1.getChildren().add(element);
            }

        }

        VBox box2 = new VBox(5);
        box2.setLayoutX(385.0); box2.setLayoutY(80.0); box2.setSpacing(15.0);

        for (int j = 2+pageIndex*6; j < 4+pageIndex*6; j++) {
            if(var){
                break;
            }
            if(j==numberOfObjects){
                var = true;
                break;
            }
            else {
                VBox element = new VBox();
                MaintenanceProfile maintenanceProfile = new MaintenanceProfile();
                try {
                    maintenanceProfile.setLocoNumber(String.valueOf(failureResponse.getJSONObject(j).getInt("loco_ID")));
                    maintenanceProfile.setDate(failureResponse.getJSONObject(j).getString("date"));
                    maintenanceProfile.setRouteID(String.valueOf(failureResponse.getJSONObject(j).getInt("maintenance_ID")));
                    maintenanceProfile.setTripDetails(failureResponse.getJSONObject(j).getString("note"));
                    maintenanceProfile.setDriverId(failureResponse.getJSONObject(j).getString("suggestion"));
                } catch (JSONException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                AnchorPane obj = maintenanceProfile.createTripProfile();
                element.getChildren().add(obj);
                box1.getChildren().add(element);
            }
        }

        VBox box3 = new VBox(5);
        box3.setLayoutX(730.0); box3.setLayoutY(80.0); box3.setSpacing(15.0);

        for (int k = 4+pageIndex*6; k < 6+pageIndex*6; k++) {
            if(var){
                break;
            }
            if(k==numberOfObjects){
                break;
            }
            else {
                VBox element = new VBox();
                MaintenanceProfile maintenanceProfile = new MaintenanceProfile();
                try {
                    maintenanceProfile.setLocoNumber(String.valueOf(failureResponse.getJSONObject(k).getInt("loco_ID")));
                    maintenanceProfile.setDate(failureResponse.getJSONObject(k).getString("date"));
                    maintenanceProfile.setRouteID(String.valueOf(failureResponse.getJSONObject(k).getInt("maintenance_ID\t")));
                    maintenanceProfile.setTripDetails(failureResponse.getJSONObject(k).getString("note"));
                    maintenanceProfile.setDriverId(failureResponse.getJSONObject(k).getString("suggestion"));
                } catch (JSONException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                AnchorPane obj = maintenanceProfile.createTripProfile();
                element.getChildren().add(obj);
                box1.getChildren().add(element);
            }
        }
        boxAnchor.getChildren().addAll(box1,box2,box3);

        return boxAnchor;
    }

    public AnchorPane pages(){
        JSONArray failureResponse = DBReader.returnMaintenance();

        int limitingFac = (failureResponse.length())%6;
        int var;
        if(limitingFac==0){
            var=0;
        }
        else{
            var=1;
        }
        int pageCount=((failureResponse.length())/6+var);

        int numberOfObjects = failureResponse.length();

        pagination = new Pagination(pageCount, 0);
        pagination.setPrefHeight(720.0); pagination.setPrefWidth(1090.0);
        pagination.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer pageIndex) {
                return createPage(numberOfObjects, pageIndex, failureResponse);
            }
        });

        AnchorPane anchor = new AnchorPane();
        anchor.prefWidth(1090.0); anchor.prefHeight(740.0); anchor.setStyle("-fx-background-color: #f1f1f1;");
        AnchorPane.setTopAnchor(pagination, 10.0);
        AnchorPane.setRightAnchor(pagination, 10.0);
        AnchorPane.setBottomAnchor(pagination, 50.0);
        AnchorPane.setLeftAnchor(pagination, 10.0);
        anchor.getChildren().add(pagination);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setLayoutX(0.0); scrollPane.setLayoutY(0.0);
        scrollPane.setPrefHeight(740.0); scrollPane.setPrefWidth(1090.0);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setContent(anchor);

        AnchorPane anchor1 = new AnchorPane();
        anchor.prefWidth(1090.0); anchor.prefHeight(740.0); anchor.setStyle("-fx-background-color: #f1f1f1;");
        anchor1.getChildren().add(scrollPane);
        return anchor1;
    }

    public AnchorPane pages(JSONArray failureResponse){

        int limitingFac = (failureResponse.length())%6;
        int var;
        if(limitingFac==0){
            var=0;
        }
        else{
            var=1;
        }
        int pageCount=((failureResponse.length())/6+var);

        int numberOfObjects = failureResponse.length();

        pagination = new Pagination(pageCount, 0);
        pagination.setPrefHeight(740.0); pagination.setPrefWidth(1090.0);
        pagination.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer pageIndex) {
                return createPage(numberOfObjects, pageIndex, failureResponse);
            }
        });

        AnchorPane anchor = new AnchorPane();
        anchor.prefWidth(1090.0); anchor.prefHeight(740.0); anchor.setStyle("-fx-background-color: #f1f1f1;");
        AnchorPane.setTopAnchor(pagination, 10.0);
        AnchorPane.setRightAnchor(pagination, 10.0);
        AnchorPane.setBottomAnchor(pagination, 50.0);
        AnchorPane.setLeftAnchor(pagination, 10.0);
        anchor.getChildren().add(pagination);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setLayoutX(0.0); scrollPane.setLayoutY(0.0);
        scrollPane.setPrefHeight(740.0); scrollPane.setPrefWidth(1090.0);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setContent(anchor);

        AnchorPane anchor1 = new AnchorPane();
        anchor.prefWidth(1090.0); anchor.prefHeight(740.0); anchor.setStyle("-fx-background-color: #f1f1f1;");
        anchor1.getChildren().add(scrollPane);
        return anchor1;
    }
}
