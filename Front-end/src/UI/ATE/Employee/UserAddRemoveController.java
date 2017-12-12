package UI.ATE.Employee;

import Connection.*;
import Models.User;
import UI.setGlobals;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

/**
 * Created by piumiindeevari on 12/7/2017.
 */
public class UserAddRemoveController {


    @FXML
    private DatePicker date_today;
    @FXML
    private TextField txt_empID;
    @FXML
    private TextField txt_username;
    @FXML
    private PasswordField pwd;
    @FXML
    private PasswordField confirmPwd;

    private String addUserUrl = "http://localhost:3000/api/user/";


    public void setTextNull(){
        txt_empID.setText("");
        txt_username.setText("");
        pwd.setText("");
        confirmPwd.setText("");
    }

    public Boolean employeeExists(String employeeID) {
        Boolean userIn = false;
        JSONArray response = DBReader.returnUser();
        for (int i = 0; i < response.length(); i++) {
            try {
                if (employeeID.equals(response.getJSONObject(i).getString("employee_ID"))) {
                    userIn =true;
                    break;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return userIn;
    }

    public Boolean userExists(String username) {
        Boolean userIn = false;
        JSONArray response = DBReader.returnUser();
        for (int i = 0; i < response.length(); i++) {
            try {
                if (username.equals(response.getJSONObject(i).getString("username"))) {
                    userIn =true;
                    break;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return userIn;
    }



    public void addClicked(){
        Update.updateUser();
        String employeeID = txt_empID.getText();
        String username = txt_username.getText();;
        String password = pwd.getText();
        String confirmPassword = confirmPwd.getText();

        User user = new User();

        LocalDate localDate = date_today.getValue();
        Date date_today1 = java.sql.Date.valueOf(localDate);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String date_today = df.format(date_today1);
        user.setDate_today(date_today) ;
        user.setEmployee_ID(txt_empID.getText());
        user.setUsername(txt_username.getText());
        user.setPwd(pwd.getText());



        String userObject = ObjectToJson.converter(user);
        System.out.println(userObject);
        if(password.equals(confirmPassword)) {
            if ( employeeExists(employeeID)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("This employee " + employeeID + " already has a user account");
                alert.showAndWait();
                setTextNull();

            }
            else if(userExists(username)){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("The username " + username + " has already been used!");
                alert.showAndWait();
                setTextNull();
            }

            else {
                    try {
                        PostRequest.sendPostRequest(addUserUrl, userObject);
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("User Added");
                        alert.setHeaderText(null);
                        alert.setContentText("User Account for " + employeeID + " created successfully");
                        alert.showAndWait();
                        setTextNull();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("The passwords you entered does not match!");
            alert.showAndWait();
            confirmPwd.setText("");
        }
    }

    public void removeClicked(){
        String employeeID = txt_empID.getText();
        String password = pwd.getText();
        try {

            JSONArray response = DBReader.returnUser();
            Boolean userIn = false;
            for (int i = 0; i < response.length(); i++) {

                if (employeeID.equals(response.getJSONObject(i).getString("employee_ID"))) {
                    if (password.equals(response.getJSONObject(i).getString("pwd"))) {

                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Confirmation Dialog");
                        alert.setHeaderText("You are about to delete a user");
                        alert.setContentText("Do you want to continue the process?");
                        Optional<ButtonType> result = alert.showAndWait();

                        if (result.get() == ButtonType.OK){
                            String deleteUserUrl = "http://localhost:3000/api/user/" + employeeID;
                            try {
                                //DeleteRequest.sendDeleteRequest(deleteUserUrl,response.getJSONObject(i));
                                if( employeeExists(employeeID)){
                                    Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                                    alert2.setTitle("Information");
                                    alert2.setHeaderText(null);
                                    alert2.setContentText("unable to delete user!");
                                    setTextNull();
                                }
                                else{
                                    Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                                    alert2.setTitle("Information");
                                    alert2.setHeaderText(null);
                                    alert2.setContentText("User successfully deleted!");
                                    setTextNull();
                                }
                            }catch (Exception e){
                                System.out.println(e.getMessage());
                            }


                        } else {
                            alert.close();
                            setTextNull();
                            break;
                        }

                    }
                    else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText("Wrong Password!");
                        alert.setContentText("The password you entered is incorrect!");
                        alert.showAndWait();

                    }
                    userIn = true;
                    break;

                }

            }
            if (userIn == false){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("No User "+employeeID);
                alert.setContentText("The user you are trying to delete has already beeen deleted");
                alert.showAndWait();

            }

        }catch (Exception e) {
            e.printStackTrace();
        }

    }

}
