package Models;

import java.util.Date;

/**
 * Created by piumiindeevari on 12/5/2017.
 */
public class MaintenanceDone {

    private int maintenance_ID;
    private int loco_ID;
    private Date date_done;//Should change in the db
    private String note;
    private String sugestion;
    private String current_state_of_loco;//should add to db

    public MaintenanceDone(int maintenance_ID, int loco_ID,   Date date_done, String note, String sugestion, String current_state_of_loco){
        this.maintenance_ID = maintenance_ID;
        this.loco_ID = loco_ID;
        this.date_done = date_done;
        this.note = note;
        this.sugestion = sugestion;
        this.current_state_of_loco =current_state_of_loco;
    }


    public int getMaintenance_ID(){return this.maintenance_ID;}
    public void setMaintenance_ID(int maintenance_ID){this.maintenance_ID= maintenance_ID;}

    public int getLoco_ID (){ return this.loco_ID;}
    public void setLoco_ID(int loco_ID){this.loco_ID= loco_ID;}

    public Date getDate_done (){ return this.date_done;}
    public void setDate_done(Date date_done){this.date_done = date_done;}

    public String getNote (){ return this.note;}
    public void setNote(String note){this.note= note;}

    public String getSugestion (){ return this.sugestion;}
    public void setSugestion(String sugestion){this.sugestion = sugestion;}

    public String getCurrent_state_of_loco(){ return this.current_state_of_loco;}
    public void setCurrent_state_of_loco(String current_state_of_loco){this.current_state_of_loco = current_state_of_loco;}


}

