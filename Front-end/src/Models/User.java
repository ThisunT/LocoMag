package Models;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by piumiindeevari on 12/7/2017.
 */
public class User {
    private String date_today;
    private String employee_ID;
    private String username;
    private String pwd;


    public String getDate_today() { return this.date_today;    }

    public void setDate_today(String date_today) {
        this.date_today = date_today;
    }

    public String getEmployee_ID() {
        return this.employee_ID;
    }

    public void setEmployee_ID(String employee_ID) {
        this.employee_ID = employee_ID;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return this.pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }


}



