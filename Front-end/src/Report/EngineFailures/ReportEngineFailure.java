package Report.EngineFailures;

import Connection.DBReader;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;
import org.json.JSONException;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class ReportEngineFailure extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public void generateReportFailures() throws JRException, ClassNotFoundException, SQLException {

        File file = new File("C:\\Users\\Toshiba®\\Documents\\GitHub\\report-LocoMag\\Front-end\\src\\Report\\EngineFailures\\EngineFailure.jrxml");

        try {
            JasperDesign jd  = JRXmlLoader.load(new FileInputStream(file));
            JasperReport jasperReport = JasperCompileManager.compileReport(jd);
            // Fields for report
            HashMap<String, Object> parameters = new HashMap<String, Object>();

            for(int i=0;i<=5;i++) {
                parameters.put("Failure Name", String.valueOf(DBReader.returnLocomotives().getJSONObject(i).getString("name")));
                parameters.put("Type", String.valueOf(DBReader.returnLocomotives().getJSONObject(i).getString("type")));
                parameters.put("Section", String.valueOf(DBReader.returnLocomotives().getJSONObject(i).getString("section")));
                parameters.put("Description", String.valueOf(DBReader.returnLocomotives().getJSONObject(i).getString("description")));


            }



            ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
            list.add(parameters);

            JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(list);
            JasperPrint print = JasperFillManager.fillReport(jasperReport, null, beanColDataSource);
            JRViewer viewer = new JRViewer(print);
            viewer.setOpaque(true);
            viewer.setVisible(true);
            this.add(viewer);
            this.setSize(700, 500);
            this.setVisible(true);
            System.out.print("Done!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        // First, compile jrxml file.



    }

}
