package UI.Dashboard.Reports;

import Report.EngineFailures.ReportEngineFailure;
import Report.FailureOccured.ReportFailureOccured;
import Report.Locomotives.ReportLocoClass;
import Report.Route.ReportRout;
import Report.Trip.ReportTrip;
import net.sf.jasperreports.engine.JRException;

import java.sql.SQLException;

/**
 * Created by Toshiba® on 05-Dec-17.
 */
public class ReportViewController {

    public void Failures(){
        ReportEngineFailure EngineFailure = new ReportEngineFailure();
        try {
            EngineFailure.generateReportFailures();
        } catch (JRException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public void EngineFailureClicked(){
//        ReportLocomotives reportDailyFailure = new ReportLocomotives();
//        try {
//            reportDailyFailure.generateReport();
//        } catch (JRException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public void Loco(){
        ReportLocoClass reportLoco = new ReportLocoClass();
        try {

            reportLoco.showReport();
        } catch (JRException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void rout(){
        ReportRout reportRout = new ReportRout();
        try {
            reportRout.generateReportRout();
        } catch (JRException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Trip(){
        ReportTrip reportTrip = new ReportTrip();
        try {
            reportTrip.generateReportTrip();
        } catch (JRException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void failureOcuured(){
        ReportFailureOccured reportFailureOccured = new ReportFailureOccured();
        try {
            reportFailureOccured.FailuresOccuredReport();
        } catch (JRException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
