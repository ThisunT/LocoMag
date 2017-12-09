package UI.Dashboard.Locomotive;

import Connection.DBReader;
import Connection.GetImage;
import Connection.Update;
import javafx.scene.Node;
import javafx.scene.control.Pagination;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by Thisun Pathirage on 10/21/2017.
 */
public class LocomotiveViewer {



    Pagination pagination = new Pagination();

    public AnchorPane createPage(int numberOfObjects, int pageIndex, JSONArray response) {
        AnchorPane boxAnchor = new AnchorPane();
        boxAnchor.prefWidth(1090.0); boxAnchor.prefHeight(740.0); boxAnchor.setStyle("-fx-background-color: #f1f1f1;");

        VBox box1 = new VBox(5);
        box1.setLayoutX(39.0); box1.setLayoutY(115.0); box1.setSpacing(15.0);
        boolean var = false;


        for (int i = pageIndex*6; i < 2+pageIndex*6; i++) {
            if(i==numberOfObjects){
                var = true;
                break;
            }
            else {
                VBox element = new VBox();
                LocoProfile locoProfile = new LocoProfile();
                try {
                    locoProfile.setTrueImage("UI/Images/locos/"+String.valueOf(response.getJSONObject(i).getInt("EngineNumber"))+".png");
                    locoProfile.setLocoNumber(response.getJSONObject(i).getInt("EngineNumber"));
                    locoProfile.setLocoType(response.getJSONObject(i).getString("EngineType"));
                    locoProfile.setLocoState(response.getJSONObject(i).getString("State"));
                    locoProfile.setLocoPosition(response.getJSONObject(i).getString("Shed"));
                } catch (JSONException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    try {
                        locoProfile.setLocoNumber(response.getJSONObject(i).getInt("EngineNumber"));
                        locoProfile.setLocoType(response.getJSONObject(i).getString("EngineType"));
                        locoProfile.setLocoState(response.getJSONObject(i).getString("State"));
                        locoProfile.setLocoPosition(response.getJSONObject(i).getString("Shed"));
                        locoProfile.setTrueImage("UI/Images/train.png");
                    } catch (JSONException e1) {
                        e1.printStackTrace();
                    }
                }

                AnchorPane obj = locoProfile.createLocoProfile();
                element.getChildren().add(obj);
                box1.getChildren().add(element);
            }

        }

        VBox box2 = new VBox(5);
        box2.setLayoutX(385.0); box2.setLayoutY(115.0); box2.setSpacing(15.0);

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
                LocoProfile locoProfile = new LocoProfile();
                try {
                    locoProfile.setTrueImage("UI/Images/locos/"+String.valueOf(response.getJSONObject(j).getInt("EngineNumber"))+".png");
                    locoProfile.setLocoNumber(response.getJSONObject(j).getInt("EngineNumber"));
                    locoProfile.setLocoType(response.getJSONObject(j).getString("EngineType"));
                    locoProfile.setLocoState(response.getJSONObject(j).getString("State"));
                    locoProfile.setLocoPosition(response.getJSONObject(j).getString("Shed"));
                } catch (JSONException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    try {
                        locoProfile.setLocoNumber(response.getJSONObject(j).getInt("EngineNumber"));
                        locoProfile.setLocoType(response.getJSONObject(j).getString("EngineType"));
                        locoProfile.setLocoState(response.getJSONObject(j).getString("State"));
                        locoProfile.setLocoPosition(response.getJSONObject(j).getString("Shed"));
                        locoProfile.setTrueImage("UI/Images/train.png");
                    } catch (JSONException e1) {
                        e1.printStackTrace();
                    }
                }
                AnchorPane obj = locoProfile.createLocoProfile();
                element.getChildren().addAll(obj);
                box2.getChildren().add(element);
            }
        }

        VBox box3 = new VBox(5);
        box3.setLayoutX(730.0); box3.setLayoutY(115.0); box3.setSpacing(15.0);

        for (int k = 4+pageIndex*6; k < 6+pageIndex*6; k++) {
            if(var){
                break;
            }
            if(k==numberOfObjects){
                break;
            }
            else {
                VBox element = new VBox();
                LocoProfile locoProfile = new LocoProfile();
                try {
                    locoProfile.setTrueImage("UI/Images/locos/"+String.valueOf(response.getJSONObject(k).getInt("EngineNumber"))+".png");
                    locoProfile.setLocoNumber(response.getJSONObject(k).getInt("EngineNumber"));
                    locoProfile.setLocoType(response.getJSONObject(k).getString("EngineType"));
                    locoProfile.setLocoState(response.getJSONObject(k).getString("State"));
                    locoProfile.setLocoPosition(response.getJSONObject(k).getString("Shed"));
                } catch (JSONException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    try {
                        locoProfile.setLocoNumber(response.getJSONObject(k).getInt("EngineNumber"));
                        locoProfile.setLocoType(response.getJSONObject(k).getString("EngineType"));
                        locoProfile.setLocoState(response.getJSONObject(k).getString("State"));
                        locoProfile.setLocoPosition(response.getJSONObject(k).getString("Shed"));
                        locoProfile.setTrueImage("UI/Images/train.png");
                    } catch (JSONException e1) {
                        e1.printStackTrace();
                    }
                }
                AnchorPane obj = locoProfile.createLocoProfile();
                element.getChildren().addAll(obj);
                box3.getChildren().add(element);
            }
        }
        boxAnchor.getChildren().addAll(box1,box2,box3);

        return boxAnchor;
    }

    public AnchorPane pages(){
        JSONArray response = DBReader.returnLocomotives();

        int limitingFac = (response.length())%6;
        int var;
        if(limitingFac==0){
            var=0;
        }
        else{
            var=1;
        }

        int pageCount=((response.length())/6+var);
        int numberOfObjects = response.length();

        pagination = new Pagination(pageCount, 0);
        pagination.setPrefHeight(720.0); pagination.setPrefWidth(1090.0);
        pagination.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer pageIndex) {
                return createPage(numberOfObjects, pageIndex, response);
            }
        });

        AnchorPane anchor = new AnchorPane();
        anchor.prefWidth(1090.0); anchor.prefHeight(740.0); anchor.setStyle("-fx-background-color: #f1f1f1;");
        AnchorPane.setTopAnchor(pagination, 10.0);
        AnchorPane.setRightAnchor(pagination, 10.0);
        AnchorPane.setBottomAnchor(pagination, 5.0);
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

    public AnchorPane pages(JSONArray response){

        int limitingFac = (response.length())%6;
        int var;
        if(limitingFac==0){
            var=0;
        }
        else{
            var=1;
        }

        int pageCount=((response.length())/6+var);
        int numberOfObjects = response.length();

        pagination = new Pagination(pageCount, 0);
        pagination.setPrefHeight(720.0); pagination.setPrefWidth(1090.0);
        pagination.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer pageIndex) {
                return createPage(numberOfObjects, pageIndex, response);
            }
        });

        AnchorPane anchor = new AnchorPane();
        anchor.prefWidth(1090.0); anchor.prefHeight(740.0); anchor.setStyle("-fx-background-color: #f1f1f1;");
        AnchorPane.setTopAnchor(pagination, 10.0);
        AnchorPane.setRightAnchor(pagination, 10.0);
        AnchorPane.setBottomAnchor(pagination, 5.0);
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
