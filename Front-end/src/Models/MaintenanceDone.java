package Models;

import java.util.Date;
import java.util.SplittableRandom;

/**
 * Created by piumiindeevari on 12/5/2017.
 */
public class MaintenanceDone {

    private int maintenanceId;
    private int locoId;
    private String date;//Should change in the db
    private String note;
    private String suggestion;
    private String currentState;//should add to db

    public int getMaintenanceId() {
        return maintenanceId;
    }

    public void setMaintenanceId(int maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    public int getLocoId() {
        return locoId;
    }

    public void setLocoId(int locoId) {
        this.locoId = locoId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }
}

