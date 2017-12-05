package Models;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

/**
 * Created by piumiindeevari on 12/1/2017.
 */
public class FailureOccured {

    private int loco_ID;
    private int failure_ID;
    private int trip_ID;
    private String place;
    private String nearest_yard;
    private Date occured_time;
    private String loco_state_at_failure;
    private String driver_note;
    private String counteraction;//add to db
    private String description;
    private String recovery_option;
    private String foreman_note;
    private String ATE_review;
    private String chiefEng_justification;
    private String current_state_of_loco;



    public FailureOccured(int loco_ID, int failure_ID, int trip_ID, String place, String nearest_yard, Date occured_time, String loco_state_at_failure, String driver_note, String counteraction, String description, String recovery_option, String foreman_note, String ATE_review, String chiefEng_justification, String current_state_of_loco){
        this.loco_ID =loco_ID;
        this.failure_ID =failure_ID;
        this.trip_ID = trip_ID;
        this.place = place;
        this.nearest_yard = nearest_yard;
        this.occured_time = occured_time;
        this.loco_state_at_failure = loco_state_at_failure;
        this.driver_note = driver_note;
        this.counteraction = counteraction;
        this.description = description;
        this.recovery_option = recovery_option;
        this.foreman_note = foreman_note;
        this.ATE_review = ATE_review;
        this.chiefEng_justification = chiefEng_justification;
        this.current_state_of_loco = current_state_of_loco;
    }


    public int getLoco_ID (){ return this.loco_ID;}
    public void setLoco_ID(int loco_ID){this.loco_ID = loco_ID;}

    public int getFailure_ID (){ return this.failure_ID;}
    public void setFailure_ID(int failure_id){this.failure_ID= failure_id;}

    public int getTrip_ID (){ return this.trip_ID;}
    public void setTrip_ID(int trip_id){this.trip_ID= trip_id;}

    public String getPlace (){ return this.place;}
    public void setPlace(String place){this.place= place;}

    public String getNearest_yard (){ return this.nearest_yard;}
    public void setNearest_yard(String nearest_yard){this.nearest_yard = nearest_yard;}

    public Date getOccured_time(){ return this.occured_time;}
    public void setOccured_time(Date occured_time){this.occured_time = occured_time;}

    public String getLoco_state_at_failure (){ return this.loco_state_at_failure;}
    public void setLoco_state_at_failure(String loco_state_at_failure){this.loco_state_at_failure= loco_state_at_failure;}

    public String getDriver_note(){ return this.driver_note;}
    public void setDriver_note(String driver_note){this.driver_note = driver_note;}

    public String getCounteraction(){ return this.counteraction;}
    public void setCounteraction(String counteraction){this.counteraction = counteraction;}

    public String getDescription(){ return this.description;}
    public void setDescription(String description){this.description = description;}

    public String getRecovery_option(){ return this.recovery_option;}
    public void setRecovery_option(String recovery_option){this.recovery_option = recovery_option;}

    public String getForeman_note(){ return this.foreman_note;}
    public void setForeman_note(String foreman_note){this.foreman_note = foreman_note;}

    public String getATE_review(){ return this.ATE_review;}
    public void setATE_review(String ATE_review){this.ATE_review = ATE_review;}

    public String getChiefEng_justification(){ return this.chiefEng_justification;}
    public void setChiefEng_justification(String chiefEng_justification){this.chiefEng_justification = chiefEng_justification;}

    public String getCurrent_state_of_loco(){ return this.current_state_of_loco;}
    public void setCurrent_state_of_loco(String current_state_of_loco){this.current_state_of_loco = current_state_of_loco;}


}
