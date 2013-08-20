package com.tci.ventas.pasaje.util;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.*;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporterParameter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class ExportUtil {

    public static File jasperPrintTo(File jasperPrintFile, String reportFormat) throws JRException, IOException {


        JRAbstractExporter exporter = null;

        exporter = new JRPdfExporter();

        File reportOutputFile = FileTempRef.buildTmpFile(jasperPrintFile, reportFormat);

        //ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        exporter.setParameter(JRPdfExporterParameter.INPUT_FILE, jasperPrintFile);
        exporter.setParameter(JRPdfExporterParameter.OUTPUT_FILE, reportOutputFile);
        //exporter.setParameter(JExcelApiExporterParameter.OUTPUT_STREAM, byteArrayOutputStream);
        exporter.exportReport();

        //byte[] bytes = byteArrayOutputStream.toByteArray();

        //byteArrayOutputStream.flush();
        //byteArrayOutputStream.close();
        return reportOutputFile;

    }


    public static ReportResult export(File jasperTemplateFile, Map<String, Object> parameters, Connection connection, String reportFormat) throws Exception {
        File jasperPrintFile = File.createTempFile("Report", "."+reportFormat, new File(PathConstant.PATHTMP));
        jasperPrintFile.deleteOnExit();
        JasperFillManager.fillReportToFile(jasperTemplateFile.getPath(), jasperPrintFile.getPath(), parameters, connection);
        return new ReportResult(jasperTemplateFile, reportFormat).fillResultJasperPrint(jasperPrintFile);
    }

    public static File exportPdfToFile(String jasperFile, Map<String, Object> parameters, List dataList, String nomReport) throws Exception {
        JasperPrint jasperPrint = exportToJasperPrint(jasperFile, parameters, dataList);

        File file = File.createTempFile(nomReport, ".pdf");

        JRPdfExporter jRPdfExporter = new JRPdfExporter();
        jRPdfExporter.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint);
        jRPdfExporter.setParameter(JRPdfExporterParameter.OUTPUT_FILE, file);

        jRPdfExporter.exportReport();

        return file;
    }

    public static File exportDocxToFile(String jasperFile, Map<String, Object> parameters, List dataList, String nomReport) throws Exception {
        JasperPrint jasperPrint = exportToJasperPrint(jasperFile, parameters, dataList);

        File file = File.createTempFile(nomReport, ".docx");

        JRDocxExporter jRDocxExporter = new JRDocxExporter();
        jRDocxExporter.setParameter(JRDocxExporterParameter.JASPER_PRINT, jasperPrint);
        jRDocxExporter.setParameter(JRDocxExporterParameter.OUTPUT_FILE, file);
        jRDocxExporter.exportReport();
        return file;
    }

    private static JasperPrint exportToJasperPrint(String jasperFile, Map<String, Object> parameters, List dataList) throws IOException, JRException {
        InputStream inputStream = new FileInputStream(jasperFile);
        try {
            JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(dataList, true);
            JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, parameters, jrBeanCollectionDataSource);
            return jasperPrint;
        } finally {
            inputStream.close();

        }
    }
}
