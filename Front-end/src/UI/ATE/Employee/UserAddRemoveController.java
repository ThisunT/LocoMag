package UI.ATE.Employee;

import Connection.ObjectToJson;
import Connection.PostImage;
import Connection.PostRequest;
import Models.Locomotive;
import Models.User;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

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

    private String removeUserUrl = "http://localhost:3000/api/user/username";

    public void addClicked(){

        User user = new User();

        LocalDate localDate = date_today.getValue();
        java.util.Date date_today1 = java.sql.Date.valueOf(localDate);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String date_today = df.format(date_today1);
        user.setDate_today(date_today) ;
        user.setEmployee_ID(txt_empID.getText());
        user.setUsername(txt_username.getText());
        user.setPwd(pwd.getText());
        user.setPwd(confirmPwd.getText());

        String userObject = ObjectToJson.converter(user);
        System.out.println(userObject);

        try {
            PostRequest.sendPostRequest(addUserUrl,userObject);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void removeClicked(){

        User user = new User();
        user.setEmployee_ID(txt_empID.getText());
        user.setPwd(pwd.getText());
        user.setPwd(confirmPwd.getText());

        String userObject = ObjectToJson.converter(user);
        System.out.println(userObject);

        try {
            PostRequest.sendPostRequest(removeUserUrl,userObject);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
