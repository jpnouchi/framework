package com.tci.ventas.pasaje.jsf.util.excel;

import com.tci.ventas.pasaje.infrastructure.persistence.util.ApplicationProperties;
import com.tci.ventas.pasaje.infrastructure.persistence.util.FormatUtil;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * User: AW
 * Date: 24/02/13
 */
public class TemplateExcelExporter {

    public final static int NO_STYLE=0;

    public final static int SQUARE_STYLE=1;
    public final static int GRAY_STYLE=2;
    public final static int HIDDEN_STYLE=3;
    public final static int RIGHT_STYLE=4;
    public final static int LEFT_STYLE=5;
    public final static int BOTTOM_STYLE=6;
    public final static int UNDERLINE_STYLE=7;
    public final static int TOP_RIGHT_STYLE=8;

    private Row row;
    private Sheet sheet;
    private HSSFWorkbook wb;
    private DataFormat format;

    private CellStyle cellStyle;

    private Font whiteFont;
    private Font boldFont;
    private Font underLineFont;



	public void export(FacesContext context, String templateFileName) throws IOException {
        ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
        String fullPath = servletContext.getRealPath(ApplicationProperties.getExcelTemplatePath()+
        templateFileName+".xls");

       // String fileName= templateFileName+System.currentTimeMillis();

        FileInputStream fileInputStream = new FileInputStream(fullPath);
        POIFSFileSystem fsFileSystem = new POIFSFileSystem(fileInputStream);

        wb = new HSSFWorkbook(fsFileSystem);
        format = wb.createDataFormat();
        sheet = wb.getSheetAt(0);

        underLineFont=wb.createFont();
        underLineFont.setUnderline(Font.U_SINGLE);

         whiteFont=wb.createFont();
        whiteFont.setColor(IndexedColors.WHITE.getIndex());

        boldFont=wb.createFont();
        boldFont.setBoldweight(Font.BOLDWEIGHT_BOLD);


	}

    public void groupRows(int fromRow, int toRow){
        sheet.groupRow(fromRow,toRow);
        sheet.setRowGroupCollapsed(fromRow,true);
    }

    public void addRow(int rowIndex) {
         row = sheet.createRow(rowIndex);
    }

    public CellStyle getCellStyle(int rowIndex, int colIndex) {
        Row row = sheet.getRow(rowIndex);
        Cell cell = row.getCell(colIndex);
         if(cell==null){
             return null;
         }else{
            return cell.getCellStyle();
         }
    }

    public void setCellValue(int rowIndex, int colIndex,String value) {
        Row row = sheet.getRow(rowIndex);
        Cell cell = row.getCell(colIndex);
        if(cell==null){
            cell=row.createCell(colIndex);
        }
        if(value==null){
            value="";
        }

        cell.setCellValue(new HSSFRichTextString(value));
    }

    public void setCellValue(int rowIndex, int colIndex,String value,CellStyle style) {
        Row row = sheet.getRow(rowIndex);
        Cell cell = row.getCell(colIndex);
        if(cell==null){
            cell=row.createCell(colIndex);
        }

        cell.setCellStyle(style);
        if(value==null){
            value="";
        }

        cell.setCellValue(new HSSFRichTextString(value));
    }

    public void getCellValue(int rowIndex, int colIndex,String value) {
//        Row row = sheet.getRow(rowIndex);
//        Cell cell = row.getCell(colIndex);
//        if(cell==null){
//            cell=row.createCell(colIndex);
//        }
//        if(value==null){
//            value="";
//        }
//
//        cell.getCellFormula(new HSSFRichTextString(value));
    }

    public void setCellValue(int rowIndex, int colIndex,BigDecimal value) {
        //String aux=value==null?"":String.valueOf(value);
        //setCellValue(rowIndex,colIndex,value);
        Row row = sheet.getRow(rowIndex);
        Cell cell = row.getCell(colIndex);
        if(cell==null){
            cell=row.createCell(colIndex);
        }

        if(value!=null){
            cell.setCellValue(value.doubleValue());
        }
        CellStyle styleCell=cell.getCellStyle();
        if(styleCell!=null){
            styleCell.setDataFormat(format.getFormat(FormatUtil.FORMAT_NUMERIC));
            cell.setCellStyle(styleCell);
        }
    }
    public void addColumnValue(int index,String value){
      addColumnValue(index,value,-1,false);
    }

    public void addCellFormula(int index,String formula,int style,String pattern,boolean bold) {
        Cell cell = row.createCell(index);
         HSSFCellStyle styleCell=getStyle(style,bold);
        if(styleCell!=null){
            styleCell.setDataFormat(format.getFormat(pattern));
            cell.setCellStyle(styleCell);
        }
        cell.setCellType(HSSFCell.CELL_TYPE_FORMULA);
        cell.setCellFormula(formula);
    }

    public void addColumnValue(int index,String value,int style,boolean bold) {
        Cell cell = row.createCell(index);
        if(value==null){
            value="";
        }
        HSSFCellStyle styleCell=getStyle(style,bold);
        if(styleCell!=null){
            styleCell.setDataFormat(format.getFormat(FormatUtil.FORMAT_TEXT));
            cell.setCellStyle(styleCell);
            cell.setCellType(Cell.CELL_TYPE_STRING);
        }
        cell.setCellValue(new HSSFRichTextString(value));
    }
    public void addColumnValue(int index,BigDecimal value) {
        addColumnValue(index,value,-1,false);
    }
    public void addColumnValue(int index,BigDecimal value,int style, boolean bold) {
      addColumnValue( index, value, style, FormatUtil.FORMAT_NUMERIC, bold);
    }
    public void addColumnValue(int index,BigDecimal value,int style, String pattern,boolean bold) {
        Cell cell = row.createCell(index);
        HSSFCellStyle styleCell=getStyle(style,bold);

        if(styleCell!=null && pattern!=null){
            styleCell.setDataFormat(format.getFormat(pattern));
            cell.setCellStyle(styleCell);
        }

        if(value!=null){
            cell.setCellValue(value.doubleValue());
        }
    }
    public void addColumnValue(int index,Long value){
      addColumnValue(index,value,-1);
    }
    public void addColumnValue(int index,Long value,int style) {
        //String aux=value==null?"":String.valueOf(value);
        addColumnValue(index,BigDecimal.valueOf(value),style,FormatUtil.FORMAT_NUMERIC_INTEGER,false);
    }

    public void writeExcelToResponse(HttpServletResponse response, String filename) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Expires", "0");
        response.setHeader("Cache-Control","must-revalidate, post-check=0, pre-check=0");
        response.setHeader("Pragma", "public");
        response.setHeader("Content-disposition", "attachment;filename="+ filename + ".xls");

        wb.write(response.getOutputStream());
    }

    private HSSFCellStyle getStyle(int type, boolean bold){
        HSSFCellStyle style=null;



        switch (type){
            case TemplateExcelExporter.NO_STYLE:
                style=  getCellNoStyle(bold);
                break;
            case TemplateExcelExporter.SQUARE_STYLE:
                style=  defaultCellStyle();
                break;
            case TemplateExcelExporter.GRAY_STYLE:
                style=  getCellGrayStyle(bold);
                break;
            case TemplateExcelExporter.RIGHT_STYLE:
                style=  rightCellStyle(bold);
                break;
            case TemplateExcelExporter.LEFT_STYLE:
                style=  leftCellStyle(bold);
                break;
            case TemplateExcelExporter.BOTTOM_STYLE:
                style=  bottomCellStyle(bold);
                break;
            case TemplateExcelExporter.TOP_RIGHT_STYLE:
                style=  topRightCellStyle(bold);
                break;
            case TemplateExcelExporter.UNDERLINE_STYLE:
                style=  underLineCellStyle(bold);
                break;
            case TemplateExcelExporter.HIDDEN_STYLE:
                style= getCellHiddenStyle();
                break;
        }

        return style;
    }

    private HSSFCellStyle defaultCellStyle() {
        HSSFCellStyle style=wb.createCellStyle();
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
//        Font font=style.getFont(wb);
//        font.setColor(IndexedColors.BLACK.getIndex());
//        style.setFont(font);
        return style;
    }

    private HSSFCellStyle rightCellStyle(boolean bold) {
        HSSFCellStyle style=wb.createCellStyle();
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_NONE);
        style.setBorderLeft(HSSFCellStyle.BORDER_NONE);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);

//        Font font=style.getFont(wb);
//        font.setColor(IndexedColors.BLACK.getIndex());
//        style.setFont(font);
         if(bold){
            addBoldStyle(style);
         }
        return style;
    }

    private HSSFCellStyle leftCellStyle(boolean bold) {
        HSSFCellStyle style=wb.createCellStyle();
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_NONE);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_NONE);

//        Font font=style.getFont(wb);
//        font.setColor(IndexedColors.BLACK.getIndex());
//        style.setFont(font);

         if(bold){
            addBoldStyle(style);
         }

        return style;
    }

    private HSSFCellStyle bottomCellStyle(boolean bold) {
        HSSFCellStyle style=wb.createCellStyle();
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_NONE);
        style.setBorderLeft(HSSFCellStyle.BORDER_NONE);
        style.setBorderRight(HSSFCellStyle.BORDER_NONE);

//        Font font=style.getFont(wb);
//        font.setColor(IndexedColors.BLACK.getIndex());
//        style.setFont(font);

         if(bold){
            addBoldStyle(style);
         }

        return style;
    }

    private HSSFCellStyle topRightCellStyle(boolean bold) {
        HSSFCellStyle style=wb.createCellStyle();
        style.setBorderBottom(HSSFCellStyle.BORDER_NONE);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_NONE);
        style.setBorderRight(HSSFCellStyle.BORDER_NONE);

        style.setAlignment(HSSFCellStyle.ALIGN_RIGHT);

        if(bold){
            addBoldStyle(style);
        }

        return style;
    }

    private HSSFCellStyle underLineCellStyle(boolean bold) {
        HSSFCellStyle style=wb.createCellStyle();
        style.setBorderBottom(HSSFCellStyle.BORDER_NONE);
        style.setBorderTop(HSSFCellStyle.BORDER_NONE);
        style.setBorderLeft(HSSFCellStyle.BORDER_NONE);
        style.setBorderRight(HSSFCellStyle.BORDER_NONE);
//
//        Font font=style.getFont(wb);
//        font.setColor(IndexedColors.BLACK.getIndex());
        style.setFont(underLineFont);

         if(bold){
            addBoldStyle(style);
//            Font underLineFont=style.getFont(wb);
//            underLineFont.setUnderline(Font.U_SINGLE);
         }


        return style;
    }

    private HSSFCellStyle getCellNoStyle(boolean bold) {
        HSSFCellStyle style=wb.createCellStyle();
        style.setBorderBottom(HSSFCellStyle.BORDER_NONE);
        style.setBorderTop(HSSFCellStyle.BORDER_NONE);
        style.setBorderLeft(HSSFCellStyle.BORDER_NONE);
        style.setBorderRight(HSSFCellStyle.BORDER_NONE);
//        Font font=style.getFont(wb);
//        font.setColor(IndexedColors.BLACK.getIndex());
//        style.setFont(font);
        if(bold){
            addBoldStyle(style);
        }
        return style;
    }

    private HSSFCellStyle getCellGrayStyle(boolean bold) {
        HSSFCellStyle style=wb.createCellStyle();
        if(cellStyle!=null){
            style.cloneStyleFrom(cellStyle);
        }
//        Font font=style.getFont(wb);
//        font.setColor(IndexedColors.BLACK.getIndex());
//        style.setFont(font);
        if(bold){
            addBoldStyle(style);
        }

        return style;
    }

    private void addBoldStyle(HSSFCellStyle style){
        //Font font=style.getFont(wb);
        //underLineFont.setUnderline(Font.U_SINGLE);
        style.setFont(boldFont);
    }

    private HSSFCellStyle getCellHiddenStyle() {
        HSSFCellStyle style=wb.createCellStyle();
        style.setBorderBottom(HSSFCellStyle.BORDER_NONE);
        style.setBorderTop(HSSFCellStyle.BORDER_NONE);
        style.setBorderLeft(HSSFCellStyle.BORDER_NONE);
        style.setBorderRight(HSSFCellStyle.BORDER_NONE);
//        Font font=style.getFont(wb);
//        font.setColor(IndexedColors.WHITE.getIndex());
        style.setFont(whiteFont);
        return style;
    }

    public CellStyle getCellStyle() {
        return cellStyle;
    }

    public void setCellStyle(CellStyle cellStyle) {
        this.cellStyle = cellStyle;
    }

    public void addShape(int rowIndex, int colIndex, short conditionValue){

        switch (conditionValue){
            case HSSFColor.RED.index: createShape(rowIndex,colIndex, HSSFColor.RED.triplet);
                break;
            case HSSFColor.GREEN.index:  createShape(rowIndex,colIndex,HSSFColor.GREEN.triplet);
                break;
            case HSSFColor.YELLOW.index:  createShape(rowIndex,colIndex,HSSFColor.YELLOW.triplet);
                break;

        }
    }

    private void createShape(int rowIndex, int colIndex, short[] color){
        short[] lineColor =HSSFColor.GREY_25_PERCENT.triplet;
        HSSFPatriarch patriarch = (HSSFPatriarch) sheet.createDrawingPatriarch();
        HSSFClientAnchor a = new HSSFClientAnchor( 0, 0, 255, 230, (short) colIndex, rowIndex, (short) colIndex, rowIndex );
        HSSFSimpleShape shape = patriarch.createSimpleShape(a);
        shape.setShapeType(HSSFSimpleShape.OBJECT_TYPE_OVAL);
        shape.setLineStyleColor(lineColor[0],lineColor[1],lineColor[2]);
        shape.setFillColor(color[0],color[1],color[2]);
        shape.setLineWidth(HSSFShape.LINEWIDTH_DEFAULT);
        shape.setLineStyle(HSSFShape.LINESTYLE_SOLID);
    }

    public boolean isEmpty(){
        return row==null;
    }
}
