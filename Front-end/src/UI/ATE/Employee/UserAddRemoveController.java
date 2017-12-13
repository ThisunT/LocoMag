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
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import Connection.DeleteRequest;


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

//set all text fields null
    public void setTextNull(){
        txt_empID.setText("");
        txt_username.setText("");
        pwd.setText("");
        confirmPwd.setText("");
    }
//Checks if same EmployeeID is repeated
    public Boolean employeeExists(String employeeID) {
        Boolean empIn = false;
        Update.updateUser();
        JSONArray response = DBReader.returnUser();
        for (int i = 0; i < response.length(); i++) {
            try {
                if (employeeID.equals(response.getJSONObject(i).getString("employee_ID"))) {
                    empIn =true;
                    break;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return empIn;
    }
//Checks if same username is repeated
    public Boolean userExists(String username) {
        Boolean userIn = false;
        Update.updateUser();
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
//Check if any TextField is not filled
    public boolean checkNull(TextField txt){
        if (txt.getText().equals("")){
            return true;
        }
        else {
            return false;
        }

    }
//Check if any PasswordField is not filled
    public boolean checkNull(PasswordField pwd){
        if (pwd.getText().equals("")){
            return true;
        }
        else {
            return false;
        }

    }
//Apply checkNull to all the fields
    public boolean checkAll(){
        return checkNull(txt_empID)||checkNull(txt_username)||checkNull(pwd)||checkNull(confirmPwd);

    }
//Submit Button
    public void addClicked(){
        Update.updateUser();
        //check if any field is not filled
        if(checkAll()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the fields!");
            alert.showAndWait();
            return;
        }

        String employeeID = txt_empID.getText();
        String username = txt_username.getText();;
        String password = pwd.getText();
        String confirmPassword = confirmPwd.getText();


        //create a user object
        User user = new User();

        LocalDate localDate = date_today.getValue();
        Date date_today1 = java.sql.Date.valueOf(localDate);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String date_today = df.format(date_today1);
        user.setDate_today(date_today) ;
        user.setEmployee_ID(txt_empID.getText());
        user.setUsername(txt_username.getText());
        user.setPwd(pwd.getText());


    //convert user object to a json object
        String userObject = ObjectToJson.converter(user);
        System.out.println(userObject);

    //check if password has enough strength
        if(password.length()<5){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("The password should atleast have 5 characters");
            alert.showAndWait();
            confirmPwd.setText("");
            pwd.setText("");
        }
    //check if password equals with confirm
        else if(password.equals(confirmPassword)) {
            if ( employeeExists(employeeID)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("This employee " + employeeID + " already has a user account");
                alert.showAndWait();
                setTextNull();

            }
        //check if username is already used
            else if(userExists(username)){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("The username " + username + " has already been used!");
                alert.showAndWait();
                setTextNull();
            }

            else {
            //send post request
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

        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("The passwords you entered does not match!");
            alert.showAndWait();
            confirmPwd.setText("");
            pwd.setText("");
        }
    }

    public void removeClicked(){
        Update.updateUser();
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
                            Update.updateUser();
                            String targetUserUrl = "http://localhost:3000/api/user/" + employeeID;
                            try {
                                DeleteRequest.sendDeleteRequest(targetUserUrl);
                                Update.updateUser();
                                if( employeeExists(employeeID)){
                                    Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                                    alert2.setTitle("Information");
                                    alert2.setHeaderText(null);
                                    alert2.setContentText("unable to delete user!");
                                    alert2.showAndWait();
                                    setTextNull();
                                }
                                else{

                                    Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                                    alert2.setTitle("Information");
                                    alert2.setHeaderText(null);
                                    alert2.setContentText("User successfully deleted!");
                                    alert2.showAndWait();
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
                        pwd.setText("");
                        confirmPwd.setText("");

                    }
                    userIn = true;
                    break;

                }

            }
            if (userIn == false){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("No User "+employeeID);
                alert.setContentText("The user you are trying to delete has already been deleted");
                alert.showAndWait();

            }

        }catch (Exception e) {
            e.printStackTrace();
        }

    }

}
