package Models;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

/**
 * Created by piumiindeevari on 12/1/2017.
 */
public class Employee {

    private int employee_ID;
    private String profession;
    private String name;
    private int age;
    private String contactNo;
    private Date appointmentDate;//Should add to the db
    private String email;
    private String address;



    public Employee(int employee_ID,  String profession, String name, int age, String contactNo, Date appointmentDate, String email, String address){
        this.employee_ID =employee_ID;
        this.profession =profession;
        this.name = name;
        this.age = age;
        this.contactNo = contactNo;
        this.appointmentDate = appointmentDate;
        this.email = email;
        this.address = address;

    }


    public int getEmployee_ID (){ return this.employee_ID;}
    public void setEmployee_ID(int employee_ID){this.employee_ID= employee_ID;}

    public String getProfession (){ return this.profession;}
    public void setProfession(String profession){this.profession= profession;}

    public String getName (){ return this.name;}
    public void setName(String name){this.name= name;}

    public int getAge (){ return this.age;}
    public void setAge(int age){this.age= age;}

    public String getContactNo (){ return this.contactNo;}
    public void setContactNo(String contactNo){this.contactNo= contactNo;}

    public Date getAppointmentDate(){ return this.appointmentDate;}
    public void setAppointmentDate(Date appointmentDate){this.appointmentDate= appointmentDate;}

    public String getEmail (){ return this.email;}
    public void setEmail(String email){this.email= email;}

    public String getAddress(){ return this.address;}
    public void setAddress(String address){this.address= address;}




}
