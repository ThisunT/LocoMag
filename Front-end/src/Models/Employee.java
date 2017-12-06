package Models;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

/**
 * Created by piumiindeevari on 12/1/2017.
 */
public class Employee {

    private int employeeId;
    private String profession;
    private String name;
    private String nic;
    private int age;
    private String contactNumber;
    private String appointmentDate;//Should add to the db
    private String email;
    private String address;

    public int getEmployeeId (){ return this.employeeId;}
    public void setEmployeeId(int employeeId){this.employeeId= employeeId;}

    public String getProfession (){ return this.profession;}
    public void setProfession(String profession){this.profession= profession;}

    public String getName (){ return this.name;}
    public void setName(String name){this.name= name;}

    public int getAge (){ return this.age;}
    public void setAge(int age){this.age= age;}

    public String getContactNumber (){ return this.contactNumber;}
    public void setContactNumber(String contactNumber){this.contactNumber= contactNumber;}

    public String getAppointmentDate(){ return this.appointmentDate;}
    public void setAppointmentDate(String appointmentDate){this.appointmentDate= appointmentDate;}

    public String getEmail (){ return this.email;}
    public void setEmail(String email){this.email= email;}

    public String getAddress(){ return this.address;}
    public void setAddress(String address){this.address= address;}


    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }
}
