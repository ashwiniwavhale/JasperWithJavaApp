package org.o7planning.tutorial.javajasperreport;
 
/*
 * @author	:	Ashwini Wavhale
 * 
 * XBBLZYH
 * 
 */
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
 
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.OutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
// 
//import org.o7planning.tutorial.javajasperreport.conn.ConnectionUtils;
import org.o7planning.tutorial.javajasperreport.conn.OracleConnUtils;
 
public class JavaCallJasperReport {
 
    public static void main(String[] args) throws JRException,
            ClassNotFoundException, SQLException {
 

    	String reportSrcFile ="C://Trade_Details//SR-14_Reports//Settlement Activities by Legal Entity and Line of Business Report.jrxml";
    	

    	
         
        // First, compile jrxml file.
        JasperReport jasperReport =    JasperCompileManager.compileReport(reportSrcFile);
        
        
 
        // Connection conn = ConnectionUtils.getConnection();
        Connection cn = OracleConnUtils.getOracleConnection();
 
        // Parameters for report
        Map<String, Object> parameters = new HashMap<String, Object>();
 
        JasperPrint print = JasperFillManager.fillReport(jasperReport,
                parameters, cn);
 
        // Make sure the output directory exists.
        File outDir = new File("C://report");
        outDir.mkdirs();
 
        // PDF Exportor.
        JRPdfExporter exporter = new JRPdfExporter();
 
        ExporterInput exporterInput = new SimpleExporterInput(print);
        // ExporterInput
        exporter.setExporterInput(exporterInput);
 
        // ExporterOutput
        OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(
                "C://report//Settlement_By_legal.pdf");
        // Output
        exporter.setExporterOutput(exporterOutput);
 
        //
        SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
        exporter.setConfiguration(configuration);
        exporter.exportReport();
 
        System.out.print("Done!");
    }
}