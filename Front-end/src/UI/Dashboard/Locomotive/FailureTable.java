package Models;


/**
 * Created by piumiindeevari on 12/1/2017.
 */
public class FailureTable {

    private int engineNumber;
    private String failureId;
    private int failureIdVal;
    private String failureDescription;
    private String recoveryOption;


    public FailureTable(int engineNumber, String failureId, int failureIdVal, String failureDescription, String recoveryOption) {
        this.engineNumber = engineNumber;
        this.failureId = failureId;
        this.failureIdVal = failureIdVal;
        this.failureDescription = failureDescription;
        this.recoveryOption = recoveryOption;
    }

    public int getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(int engineNumber) {
        this.engineNumber = engineNumber;
    }

    public String getFailureId() {
        return failureId;
    }

    public void setFailureId(String failureId) {
        this.failureId = failureId;
    }

    public int getFailureIdVal() {
        return failureIdVal;
    }

    public void setFailureIdVal(int failureIdVal) {
        this.failureIdVal = failureIdVal;
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
}


