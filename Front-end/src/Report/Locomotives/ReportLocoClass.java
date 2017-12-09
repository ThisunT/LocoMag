package Report.Locomotives;

import Connection.DBReader;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JsonDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;
import org.json.JSONArray;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ReportLocoClass extends JFrame {

    /**
     *
     */

    public void showReport() throws JRException, ClassNotFoundException, SQLException {

        File file = new File("C:\\Users\\Toshiba®\\Documents\\GitHub\\report-LocoMag\\Front-end\\src\\Report\\Locomotives\\LocoReport.jrxml");

        try {
            JasperDesign jd  = JRXmlLoader.load(new FileInputStream(file));
            JasperReport jasperReport = JasperCompileManager.compileReport(jd);

            JSONArray jsonArray = DBReader.returnLocomotives();
            // Fields for report
            Map<String, Object> params = new HashMap<String, Object>();

            //list.add(parameters);
            File file1 = new File("C:\\Users\\Toshiba®\\Documents\\GitHub\\report-LocoMag\\locomotives.json");
            JsonDataSource dataSource = new JsonDataSource(file1);

            //params.put(JsonQueryExecuterFactory.JSON_INPUT_STREAM, new FileInputStream(file1));
            //JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(list);
            JasperPrint print = JasperFillManager.fillReport(jasperReport, params, dataSource);
            JRViewer viewer = new JRViewer(print);
            viewer.setOpaque(true);
            viewer.setVisible(true);
            this.add(viewer);
            this.setSize(700, 500);
            this.setVisible(true);
            System.out.print("Done!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // First, compile jrxml file.



    }
    // Firs, compile jrxml file.
}
