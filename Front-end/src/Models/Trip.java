package Models;

/**
 * Created by piumiindeevari on 12/1/2017.
 */
public class Trip {
    
    private int trainNo;// add to the db
    private int routeId;
    private int driverId;
    private int guardId;
    private int locoId;
    private String date;// change date in the db
    private String startTime;
    private String endTime;// add to db
    private boolean delay; // add to db
    private boolean failures;


    public int getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(int trainNo) {
        this.trainNo = trainNo;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public int getGuardId() {
        return guardId;
    }

    public void setGuardId(int guardId) {
        this.guardId = guardId;
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public boolean isDelay() {
        return delay;
    }

    public void setDelay(boolean delay) {
        this.delay = delay;
    }

    public boolean isFailures() {
        return failures;
    }

    public void setFailures(boolean failures) {
        this.failures = failures;
    }
}
