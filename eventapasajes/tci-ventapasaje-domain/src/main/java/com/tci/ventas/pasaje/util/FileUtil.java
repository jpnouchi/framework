package com.tci.ventas.pasaje.util;

import org.apache.log4j.Logger;

import java.awt.*;
import java.io.*;
import java.nio.channels.FileChannel;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileUtil {

    public static String getFileName(String fileFullName) throws Exception {
        int indexStart1 = fileFullName.lastIndexOf("/");
        int indexStart2 = fileFullName.lastIndexOf("\\");

        int indexStart = Math.max(indexStart1, indexStart2);
        String fileName = fileFullName.substring(indexStart + 1);
        indexStart = fileName.lastIndexOf(".");
        fileName = fileName.substring(0, indexStart);
        return fileName;
    }
    public static final String FILE_TYPE_EXCEL = "EXCEL";
    public static final String FILE_TYPE_CSV = "CSV";



    public static File writeToFile(File file, byte[] bytes) throws Exception {
        if (bytes == null) return null;
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(bytes);
        fos.close();
        return file;
    }



    public static void mostrarArchivoTemporal(File archivo) {
        if (Desktop.isDesktopSupported())
            try {
                Desktop desktop = Desktop.getDesktop();
                desktop.open(archivo);
            } catch (IOException e) {
                e.printStackTrace();
            }

    }

    public static byte[] toByte(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            int c = 0;
            while ((c = fis.read()) != -1) {
                baos.write(c);
            }
            byte[] byteReturn = baos.toByteArray();
            return byteReturn;
        } finally {
            fis.close();
            baos.close();
        }
    }

    public static File fromBytes(File file, byte[] bytes) throws IOException {
        FileOutputStream fis = new FileOutputStream(file);
        try {
            fis.write(bytes);
            return file;
        } finally {
            fis.close();
        }
    }

    public static void makeWritable(File dir) {
        if (dir.exists()) {
            File[] ficheros = dir.listFiles();
            for (File fichero : ficheros) {
                makeReadableOthers(fichero);
                makeWritableOthers(fichero);
            }
        }
    }

    private static void makeWritableOthers(File fichero) {
        try {
            fichero.setWritable(true, false);
        } catch (SecurityException e) {
            Logger.getLogger(FileUtil.class).warn("No se pudo asignar permiso WRITABLE a " + fichero, e);
        }
    }

    private static void makeReadableOthers(File fichero) {
        try {
            fichero.setReadable(true, false);
        } catch (SecurityException e) {
            Logger.getLogger(FileUtil.class).warn("No se pudo asignar permiso READABLE a " + fichero, e);
        }
    }



    public static File crearZip(java.util.List<File> archivos, File zipFile) throws Exception {
        byte[] buf = new byte[2156]; // en mi codigo tengo este valor
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFile));
        for (File reportePdf : archivos) {
            FileInputStream in = new FileInputStream(reportePdf);
            try {
                FileName fileName = new FileName(reportePdf);
                out.putNextEntry(new ZipEntry(fileName.getNameExcludeTmpPart()));
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                out.closeEntry();
            } finally {
                in.close();
            }
        }
        out.close();
        return zipFile;
    }



    public static void deleteFileIfExist(String parentDir, String fileName) {
        File file = new File(parentDir, fileName);
        if (file.exists()) file.delete();
    }

    public static File copy(File in, File out) throws IOException {
        FileChannel inChannel = new FileInputStream(in).getChannel();
        FileChannel outChannel = new FileOutputStream(out).getChannel();
        try {
            inChannel.transferTo(0, inChannel.size(), outChannel);
        } finally {
            if (inChannel != null) inChannel.close();
            if (outChannel != null) outChannel.close();
        }
        return out;
    }

}
