package Models;



import java.util.Date;

/**
 * Created by piumiindeevari on 12/1/2017.
 */
public class Trip {

    private int loco_ID;
    private int train_No;// add to the db
    private int route_ID;
    private int driver_ID;
    private int guard_ID;
    private Date date_today;// change date in the db
    private Date start_time;
    private Date end_time; // add to db
    private boolean delay; // add to db
    private boolean any_failures;




    public Trip(int loco_ID, int train_No, int route_ID, int driver_ID, int guard_ID, Date date_today, Date start_time, Date end_time,boolean delay, boolean any_failures){
        this.loco_ID =loco_ID;
        this.train_No =train_No;
        this.route_ID = route_ID;
        this.driver_ID = driver_ID;
        this.guard_ID = guard_ID;
        this.date_today = date_today;
        this.start_time = start_time;
        this.end_time = end_time;
        this.delay = delay;
        this.any_failures = any_failures;

    }


    public int getLoco_ID (){ return this.loco_ID;}
    public void setLoco_ID(int loco_ID){this.loco_ID = loco_ID;}

    public int getTrain_No (){ return this.train_No;}
    public void setTrain_No(int train_no){this.train_No = train_no;}

    public int getRoute_ID (){ return this.route_ID;}
    public void setRoute_ID(int route_ID){this.route_ID = route_ID;}

    public int getDriver_ID (){ return this.driver_ID;}
    public void setDriver_ID(int driver_ID){this.driver_ID = driver_ID;}

    public int getGuard_ID (){ return this.guard_ID;}
    public void setGuard_ID(int guard_ID){this.guard_ID = guard_ID;}

    public Date getDate_today(){ return this.date_today;}
    public void setDate_today(Date date_today){this.date_today = date_today;}

    public Date getStart_time (){ return this.start_time;}
    public void setStart_time(Date start_time){this.start_time = start_time;}

    public Date getEnd_time (){ return this.end_time;}
    public void setEnd_time(Date end_time){this.end_time = end_time;}

    public boolean getDelay (){ return this.delay;}
    public void setDelay(boolean delay){this.delay = delay;}

    public boolean getAny_failures (){ return this.any_failures;}
    public void setAny_failures(boolean any_failures){this.any_failures = any_failures;}


}
