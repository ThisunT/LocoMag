package Models;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

/**
 * Created by piumiindeevari on 12/1/2017.
 */
public class Failure_Occured {

    private int loco_ID;
    private int failure_ID;
    private int trip_ID;
    private String place;
    private String nearest_yard;
    private Date occured_time;
    private String loco_state;
    private String driver_note;
    private String description;



    public int getLoco_ID (){ return this.loco_ID;}
    public void setLoco_ID(int loco_ID){this.loco_ID = loco_ID;}

    public int getFailure_ID (){ return this.failure_ID;}
    public void setFailure_ID(int failure_ID){this.failure_ID = failure_ID;}

    public int getTrip_ID (){ return this.trip_ID;}
    public void setTrip_ID(int trip_ID){this.trip_ID = trip_ID;}

    public String getPlace (){ return this.place;}
    public void setPlace(String place){this.place = place;}

    public String getNearest_yard (){ return this.nearest_yard;}
    public void setNearest_yard(String nearest_yard){this.nearest_yard = nearest_yard;}

    public Date getTime(){ return this.occured_time;}
    public void setTime(Date occured_time){this.occured_time = occured_time;}

    public String getLoco_state (){ return this.loco_state;}
    public void setLoco_state(String loco_state){this.loco_state = loco_state;}

    public String getDriver_note(){ return this.driver_note;}
    public void setDriver_note(String diver_note){this.driver_note = driver_note;}

    public String getDescription(){ return this.description;}
    public void setDescription(String description){this.description = description;}



}
