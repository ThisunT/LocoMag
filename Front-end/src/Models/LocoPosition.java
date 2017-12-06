package Models;

import java.util.Date;

/**
 * Created by piumiindeevari on 12/5/2017.
 */
public class LocoPosition {

    private Date date_today;
    private String engine_class;
    private int running_state;
    private int active_state;
    private int idle_state;
    private int dead_state;




    public LocoPosition(Date date_today, String engine_class, int running_state, int active_state, int idle_state, int dead_state){
        this.date_today = date_today;
        this.engine_class = engine_class;
        this.running_state = running_state;
        this.active_state = active_state;
        this.idle_state = idle_state;
        this.dead_state = dead_state;
    }


    public Date getDate_today(){return this.date_today;}
    public void setDate_today(Date date_today){this.date_today = date_today;}

    public String  getEngine_class (){ return this.engine_class;}
    public void setEngine_class(String engine_class){this.engine_class = engine_class;}

    public int getRunning_state (){ return this.running_state;}
    public void setRunning_state(int running_state){this.running_state = running_state;}

    public int getActive_state (){ return this.active_state;}
    public void setActive_state(int active_state){this.active_state = active_state;}

    public int getIdle_state (){ return this.idle_state;}
    public void setIdle_state(int idle_state){this.idle_state = idle_state;}

    public int getDead_state (){ return this.dead_state;}
    public void setDead_state(int dead_state){this.dead_state = dead_state;}



}

