package com.tci.ventas.pasaje.util;

import net.sf.jasperreports.engine.JasperPrint;

import java.io.*;

/**
 * User: AW
 * Date: 24/02/13
 */
public class ReportResult {
    FileName jasperFileName;
    FileName resultFileName;
    String reportFormat;

// Solo uno de los 3 es <> NULL
//    byte[] bytes;
    File jasperPrintFile;
    File resultFile;

    public ReportResult(File jasperFile, String reportFormat) {
        this.jasperFileName = new FileName(jasperFile);
        this.resultFileName = new FileName(new File(FileName.buildTmpName(jasperFileName.getPartNameExcludeTmpPart(), reportFormat)));
        this.reportFormat = reportFormat;
    }
    public ReportResult fillResult(byte[] bytes) throws IOException {
        File fileOnTargetDir = FileTempRef.buildTmpFile(resultFileName.getName());
        resultFile=FileUtil.fromBytes(fileOnTargetDir, bytes);
        return this;
    }
    public ReportResult fillResultJasperPrint(File jasperPrintFile){
        this.jasperPrintFile = jasperPrintFile;
        return this;
    }
    public ReportResult fillResultFile(File resultFile){
        this.resultFile = resultFile;
        return this;
    }

    public String getReportFormat() {
        return reportFormat;
    }
    public String getReportNameSimple() {
        return resultFileName.getNameExcludeTmpPart();
    }
    public String getReportNameSimple(String suffix) {
        return resultFileName.getNameExcludeTmpPart(suffix);
    }
    public String getReportNameSuffixDate() {
        return resultFileName.getNameExcludeTmpPart();
    }

    public void setReportFormat(String reportFormat) {
        this.reportFormat = reportFormat;
    }

    public byte[] getBytes() {
        try {
            //if (bytes == null)
            byte[] bytes = FileUtil.toByte(getReportFile());
            return bytes;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public JasperPrint getJasperPrint() {
        if (jasperPrintFile == null)
            return null;
        try {
            ObjectInputStream objectIn =  new ObjectInputStream(new BufferedInputStream(new FileInputStream(jasperPrintFile)));
            JasperPrint jasperPrint = (JasperPrint) objectIn.readObject();
            objectIn.close();
            return jasperPrint;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public File getReportFile() {
        try {
            if (resultFile!=null)
                return resultFile;
            if (jasperPrintFile==null)
                throw new IllegalStateException("No se ha generado Jasper Print");
            return ExportUtil.jasperPrintTo(jasperPrintFile, reportFormat);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public File getReportFileOn(File targetDir) {
        File file = getReportFile();
        File fileOnTargetDir = new File(targetDir, new FileName(file).getName());
        file.renameTo(fileOnTargetDir);
        return fileOnTargetDir;
    }

}
