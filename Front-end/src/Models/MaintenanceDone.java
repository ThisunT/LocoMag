package Models;


public class MaintenanceDone {

   // private int maintenanceId;
//    private int locoId;
    private String date;//Should change in the db
    private String note;
    private String suggestion;
    private String engineNo;
    private String engineClass;
    private String type;
    private String name;
    private String currentState;




    // private String currentState;//should add to db

   // public int getMaintenanceId() {
   //     return maintenanceId;
   // }

  //  public void setMaintenanceId(int maintenanceId) {
//        this.maintenanceId = maintenanceId;
//    }


//    public int getLocoId() {
//        return locoId;
//    }
//
//    public void setLocoId(int locoId) {
//        this.locoId = locoId;
//    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {this.date = date;}

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

    public String getCurrentState() {return currentState;}

    public void setCurrentState(String currentState) {this.currentState = currentState;}

    public String getEngineNo() {
        return engineNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {this.type =type;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEngineClass() {
        return engineClass;
    }

    public void setEngineClass(String engineClass) {
        this.engineClass = engineClass;
    }

}

