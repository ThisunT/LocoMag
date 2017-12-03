package Models;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
/**
 * Created by Thisun Pathirage on 10/10/2017.
 */
public class Locomotive {

    private int engineNumber;
    private String engineType;
    private String today;
    private String shed;
    private String manufacturer;
    private int topSpeed;
    private String manufacturedDay;
    private String state;

    public int getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(int engineNumber) {
        this.engineNumber = engineNumber;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getToday() {
        return today;
    }

    public void setToday(LocalDate today) {
        this.today=today.toString();
    }

    public String getShed() {
        return shed;
    }

    public void setShed(String shed) {
        this.shed = shed;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public String getManufacturedDay() {
        return manufacturedDay;
    }

    public void setManufacturedDay(LocalDate manufacturedDay) {
        this.manufacturedDay = manufacturedDay.toString();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
