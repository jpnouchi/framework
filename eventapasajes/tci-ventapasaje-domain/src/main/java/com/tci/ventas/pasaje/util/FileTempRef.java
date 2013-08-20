package com.tci.ventas.pasaje.util;

import java.io.File;

public class FileTempRef extends FileName{
    private File origRef;
    private File tempRef;

    public FileTempRef(File origRef) {
        super(origRef);
        this.origRef =origRef;
        tempRef = buildTmpFile(partName, partExt);
        if (origRef!=null && tempRef!=null)
            tempRef.setLastModified(origRef.lastModified());
    }

    public File getTempRef() {
        return tempRef;
    }

    public File getOrigRef() {
        return origRef;
    }

    public static File buildTmpFile(File template, String fileExt) {
        String tmp="";
        File file = new File(PathConstant.PATHTMP, FileName.buildTmpName(new FileName(template).getPartNameExcludeTmpPart(), fileExt));
        file.deleteOnExit();
        return file;
    }

    public static void main(String[] args) {
        System.getProperties();
    }

    public static File buildTmpFile(String partName, String partExt) {
        String newTmpName = FileName.buildTmpName(partName, partExt);
        File file = new File(PathConstant.PATHTMP, newTmpName);
        file.deleteOnExit();
        return file;
    }

    public static File buildTmpFile(String fileName) {
        File file = new File(PathConstant.PATHTMP, fileName);
        file.deleteOnExit();
        return file;
    }
}