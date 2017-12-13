package Models;

public class FailureOccured {

    private int locoID;
    private String failureId;
    private int tripId;
    private String place;
    private String nearestYard;
    private String time;
    private String employeeId;
    private String driverNote;
    private String counteraction;
    private String failureDescription;
    private String foremanNote;
    private String ATEReview;
    private String chiefEngineerReview;
    private String currentState;
    private String date;

    public int getLocoID() {
        return locoID;
    }

    public void setLocoID(int locoID ){
        this.locoID = locoID;
    }

    public String getFailureId() {
        return failureId;
    }

    public void setFailureId(String failureId) {
        this.failureId = failureId;
    }

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getNearestYard() {
        return nearestYard;
    }

    public void setNearestYard(String nearestYard) {
        this.nearestYard = nearestYard;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time =time;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDriverNote() {
        return driverNote;
    }

    public void setDriverNote(String driverNote) {
        this.driverNote = driverNote;
    }

    public String getCounteraction() {
        return counteraction;
    }

    public void setCounteraction(String counteraction) {
        this.counteraction = counteraction;
    }

    public String getFailureDescription() {
        return failureDescription;
    }

    public void setFailureDescription(String failureDescription) {
        this.failureDescription = failureDescription;}

    public String getForemanNote() {
        return foremanNote;
    }

    public void setForemanNote(String foremanNote) {
        this.foremanNote = foremanNote;
    }

    public String getATEReview() {
        return ATEReview;
    }

    public void setATEReview(String ATEReview) {
        this.ATEReview = ATEReview;
    }

    public String getChiefEngineerReview() {
        return chiefEngineerReview;
    }

    public void setChiefEngineerReview(String chiefEngineerReview) {
        this.chiefEngineerReview = chiefEngineerReview;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {this.date = date;}
}
