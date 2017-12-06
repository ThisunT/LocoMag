package Models;

import java.util.Date;

/**
 * Created by piumiindeevari on 12/5/2017.
 */
public class Delay {

    private int failureOccuredId;
    private int locoId;
    private int routeId;
    private int delayTime;
    private String reason; // change counteraction to reason in db


    public int getFailureOccuredId(){return this.failureOccuredId;}
    public void setFailureOccuredId(int failureOccuredId){this.failureOccuredId = failureOccuredId;}

    public int getLocoId (){ return this.locoId;}
    public void setLocoId(int locoId){this.locoId= locoId;}

    public int getRouteId (){ return this.routeId;}
    public void setRouteId(int routeId){this.routeId = routeId;}

    public int getDelayTime (){ return this.delayTime;}
    public void setDelayTime(int delayTime){this.delayTime= delayTime;}

    public String getReason (){ return this.reason;}
    public void setReason(String reason){this.reason = reason;}

}

