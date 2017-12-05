package Models;

import java.util.Date;

/**
 * Created by piumiindeevari on 12/5/2017.
 */
public class Delay {

    private int failure_occured_ID;
    private int loco_ID;
    private int route_ID;
    private int delay_time;
    private String reason; // change counteraction to reason in db


    public Delay(int failure_occured_ID, int loco_ID, int route_ID, int delay_time, String reason){
        this.failure_occured_ID = failure_occured_ID;
        this.loco_ID = loco_ID;
        this.route_ID = route_ID;
        this.delay_time = delay_time;
        this.reason = reason;
    }


    public int getFailure_occured_ID(){return this.failure_occured_ID;}
    public void setFailure_occured_ID(int failure_occured_ID){this.failure_occured_ID = failure_occured_ID;}

    public int getLoco_ID (){ return this.loco_ID;}
    public void setLoco_ID(int loco_ID){this.loco_ID= loco_ID;}

    public int getRoute_ID (){ return this.route_ID;}
    public void setRoute_ID(int route_ID){this.route_ID = route_ID;}

    public int getDelay_time (){ return this.delay_time;}
    public void setDelay_time(int delay_time){this.delay_time= delay_time;}

    public String getReason (){ return this.reason;}
    public void setReason(String reason){this.reason = reason;}

}

