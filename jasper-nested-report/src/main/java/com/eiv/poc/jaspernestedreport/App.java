package com.eiv.poc.jaspernestedreport;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

public class App 
{
    public static void main( String[] args ) {
        
        Collection<?> personas = PersonaBeanFactory.getCollection();
        
        Map<String, Object> parametros = new HashMap<String, Object>();
        JRDataSource jrDataSource = new JRBeanCollectionDataSource(personas);
        
        File jasperFile = new File(
                App.class.getClassLoader()
                    .getResource("Boleta_A4.jasper")
                    .getFile());
        
        try {
            
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperFile);
            JasperPrint jasperPrint = JasperFillManager.fillReport(
                    jasperReport, parametros, jrDataSource);
            
            FileOutputStream fos = new FileOutputStream("target\\datosPersonas.pdf");
            JasperExportManager.exportReportToPdfStream(jasperPrint, fos);
            
        } catch (JRException | FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("Listo!");
    }
}
