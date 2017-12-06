package Models;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

/**
 * Created by piumiindeevari on 12/1/2017.
 */
public class FailureOccured {

    private int engineNumber;
    private int failureId;
    private int tripId;
    private String place;
    private String nearestYard;
    private String occuredTime;
    private int employeeId;
    private String driverNote;
    private String counteraction;//add to db
    private String failureDescription;
    private String recoveryOption;
    private String foremanNote;
    private String ATEReview;
    private String chiefEngineerReview;
    private String currentState;

    public int getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(int engineNumber) {
        this.engineNumber = engineNumber;
    }

    public int getFailureId() {
        return failureId;
    }

    public void setFailureId(int failureId) {
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

    public String getOccuredTime() {
        return occuredTime;
    }

    public void setOccuredTime(String occuredTime) {
        this.occuredTime = occuredTime;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
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
        this.failureDescription = failureDescription;
    }

    public String getRecoveryOption() {
        return recoveryOption;
    }

    public void setRecoveryOption(String recoveryOption) {
        this.recoveryOption = recoveryOption;
    }

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
}
