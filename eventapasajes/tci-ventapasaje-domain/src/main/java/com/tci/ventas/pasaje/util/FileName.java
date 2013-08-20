package com.tci.ventas.pasaje.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User: AW
 * Date: 24/02/13
 */
public class FileName {
    protected String partName;
    protected String partExt;

    public FileName(File originalFile) {
        String name = originalFile.getName();
        int idx = name.lastIndexOf('.');
        partName = idx < 0  ?  name : name.substring(0, idx);
        partExt = idx < 0  ?  null : name.substring(idx+1);
    }

    public String getPartName() {
        return partName;
    }

    public String getPartExt() {
        return partExt;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public FileName setPartExt(String partExt) {
        this.partExt = partExt;
        return this;
    }

    public String getName() {
        return buildName(partName, partExt);
    }

    public String getNameExcludeTmpPart() {
        String nameX = getPartNameExcludeTmpPart();
        return buildName(nameX, partExt);
    }

    public String getNameExcludeTmpPart(String suffix) {
        String nameX = getPartNameExcludeTmpPart();
        return buildName(nameX + suffix, partExt);
    }

    public String getPartNameExcludeTmpPart() {
        return partName.indexOf(PathConstant.SPECIAL_SEPARATOR) >= 0 ? partName.substring(0, partName.indexOf(PathConstant.SPECIAL_SEPARATOR)) : partName;
    }

    public static String buildName(String partName, String partExt) {
        return partName + (partExt == null ? "" : "." + partExt);
    }

    public static String buildTmpName(String partName, String partExt) {
        return buildTmpName(partName, partExt, -1);
    }
    private static String buildTmpName(String partName, String partExt, int maxSize) {
        String adic = PathConstant.SPECIAL_SEPARATOR + new SimpleDateFormat("yyyy-MM-dd.HH.mm.ss.SSS").format(new Date());
        if (maxSize>0 ){
            int namePartMaxSize = maxSize-(adic.length()+1 + StringUtil.nvl(partExt,"").length());
            if (namePartMaxSize>0 && partName.length()>namePartMaxSize){
                partName = partName.substring(0, namePartMaxSize);
            }
        }
        return buildName(partName + adic, partExt);
    }

    public static String buildTmpName(String fullName) {
        return buildTmpName(fullName, -1);
    }
    
    public static String buildTmpName(String fullName, int maxSize) {
        FileName fileName = new FileName(new File(fullName));
        return buildTmpName(fileName.getPartName(), fileName.getPartExt(), maxSize);
    }


    public static String pathToUnixFormat(File file) {
        if (file != null) {
            String path = file.getPath();
            return path.replace('\\', '/');
        }else{
            return null;
        }
    }

}
