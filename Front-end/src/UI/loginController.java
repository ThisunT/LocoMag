package UI;


import Models.User;
import UI.setGlobals;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;
import Connection.DBReader;
import Connection.*;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by acer on 10/9/2017.
 */
public class loginController implements Initializable {

    public TextField tf_login;
    public Button btn_login;
    public TextField tf_uname;
    public PasswordField btn_pwd;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    public void okBtnAction(ActionEvent event) throws Exception {


        try {

            String username = tf_uname.getText();
            String pwd = btn_pwd.getText();
            setGlobals.user = username;
            JSONArray response = DBReader.returnUser();
            Boolean userIn = false;
            for (int i = 0; i < response.length(); i++) {

                if (username.equals(response.getJSONObject(i).getString("username"))) {
                    if (pwd.equals(response.getJSONObject(i).getString("pwd"))) {
                        infoBox("Login Successfull", "Success", null);
                        ((Node) (event.getSource())).getScene().getWindow().hide();
                        Parent root = FXMLLoader.load(getClass().getResource("Index/index.fxml"));
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));
                        stage.setTitle("Sri Lanka Railways Motive Power sub Department - Engine Failure management System");
                        stage.show();

                    }
                    else {
                        infoBox("Enter Correct Username and Password", "Failed", null);
                        tf_uname.setText("");
                        btn_pwd.setText("");
                        System.out.println(username);
                        System.out.println(pwd);
                    }
                    userIn = true;
                    break;

                }

            }
            if (userIn == false){
                infoBox("Enter Correct Username and Password", "Failed", null);
                tf_uname.setText("");
                btn_pwd.setText("");
                System.out.println(username);
                System.out.println(pwd);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

    }



    public static void infoBox(String infoMessage, String titleBar, String headerMessage) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();

    }



}

