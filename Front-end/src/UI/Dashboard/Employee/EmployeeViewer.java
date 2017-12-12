package UI.Dashboard.Employee;

import Connection.DBReader;
import UI.Dashboard.Employee.EmployeeProfile;
import javafx.scene.Node;
import javafx.scene.control.Pagination;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import org.json.JSONArray;
import org.json.JSONException;


public class EmployeeViewer {



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
                EmployeeProfile empProfile = new EmployeeProfile();

                try {
                    empProfile.setTrueImage("UI/Images/emp.jpg");
                    empProfile.setEmployee_ID(response.getJSONObject(i).getString("employee_ID"));
                    empProfile.setProfession(response.getJSONObject(i).getString("profession"));
                    empProfile.setName(response.getJSONObject(i).getString("name"));
                    empProfile.setAge(response.getJSONObject(i).getInt("age"));

                } catch (Exception e) {
                    System.out.println(e.getMessage());

                    try {
                        empProfile.setEmployee_ID(response.getJSONObject(i).getString("employee_ID"));
                        empProfile.setProfession(response.getJSONObject(i).getString("profession"));
                        empProfile.setName(response.getJSONObject(i).getString("name"));
                        empProfile.setAge(response.getJSONObject(i).getInt("age"));
                        empProfile.setTrueImage("UI/Images/emp.jpg");
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }

                AnchorPane obj = empProfile.createEmpProfile();
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
                EmployeeProfile empProfile = new EmployeeProfile();
                try {
                    empProfile.setTrueImage("UI/Images/emp.jpg");
                    empProfile.setEmployee_ID(response.getJSONObject(j).getString("employee_ID"));
                    empProfile.setProfession(response.getJSONObject(j).getString("profession"));
                    empProfile.setName(response.getJSONObject(j).getString("name"));
                    empProfile.setAge(response.getJSONObject(j).getInt("age"));

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                //} catch (Exception e) {
                    try {
                        empProfile.setTrueImage("UI/Images/emp.jpg");
                        empProfile.setEmployee_ID(response.getJSONObject(j).getString("employee_ID"));
                        empProfile.setProfession(response.getJSONObject(j).getString("profession"));
                        empProfile.setName(response.getJSONObject(j).getString("name"));
                        empProfile.setAge(response.getJSONObject(j).getInt("age"));
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
                AnchorPane obj = empProfile.createEmpProfile();
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
                EmployeeProfile empProfile = new EmployeeProfile();
                try {
                    empProfile.setTrueImage("UI/Images/emp.jpg");
                    empProfile.setEmployee_ID(response.getJSONObject(k).getString("employee_ID"));
                    empProfile.setProfession(response.getJSONObject(k).getString("profession"));
                    empProfile.setName(response.getJSONObject(k).getString("name"));
                    empProfile.setAge(response.getJSONObject(k).getInt("age"));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                //} catch (Exception e) {
                    try {
                        empProfile.setTrueImage("UI/Images/emp.jpg");
                        empProfile.setEmployee_ID(response.getJSONObject(k).getString("employee_ID"));
                        empProfile.setProfession(response.getJSONObject(k).getString("profession"));
                        empProfile.setName(response.getJSONObject(k).getString("name"));
                        empProfile.setAge(response.getJSONObject(k).getInt("age"));
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
                AnchorPane obj = empProfile.createEmpProfile();
                element.getChildren().addAll(obj);
                box3.getChildren().add(element);
            }
        }
        boxAnchor.getChildren().addAll(box1,box2,box3);

        return boxAnchor;
    }

    public AnchorPane pages(){

        JSONArray response = DBReader.returnEmployees();

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
