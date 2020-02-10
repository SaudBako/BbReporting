package backend;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Output {
  
  
  //write on Output File Method
  //===========================================================================================
  
  public static void write(String path, ArrayList<Attendee> Attendees, ArrayList<Teacher> Teachers, String Day, String Plan) throws IOException {
    
    path += "\\Output.xlsx";
    
//   //exit if the file is not a XLSX File
//    if(!path.contains(".xlsx")) {
//      System.out.println("Error the File is not a XLSX File!, Exit form Program.");
//      System.exit(0);
//    }
    
    
    
//    //create file Input and check if the file not found
//    File file = new File(path);
//    FileInputStream fis = null;
//    try {
//      fis = new FileInputStream(file);
//    }
//    catch (FileNotFoundException e) {
//      System.out.println("\nError file not found, Exit form Program.");
//      System.exit(0);
//    }
    
    
    
    // Finds the workbook instance for XLSX file
    @SuppressWarnings("resource")
    XSSFWorkbook myWorkBook = new XSSFWorkbook();
    
    // Return first sheet from the XLSX workbook
    XSSFSheet mySheet = myWorkBook.createSheet("Datatypes in Java");
    
    mySheet.setRightToLeft(true);
    
    // get the last row number to append new data          
    int rownum = 0;      
 
    
    for(int i = 0; i < 1; i++) {
      Row row = mySheet.createRow(rownum++);
      
      CellStyle style = myWorkBook.createCellStyle();
      style.setAlignment(CellStyle.ALIGN_CENTER);
      
      Cell cell = row.createCell(0);
      cell.setCellStyle(style);
      cell.setCellValue("الفرع");
      cell = row.createCell(1);
      cell.setCellStyle(style);
      cell.setCellValue("الرقم الوظيفي");
      cell = row.createCell(2);
      cell.setCellStyle(style);
      cell.setCellValue("الاسم");
      cell = row.createCell(3);
      cell.setCellStyle(style);
      cell.setCellValue("رمز المادة");
      cell = row.createCell(4);
      cell.setCellStyle(style);
      cell.setCellValue("الرقم المرجعي");
      cell = row.createCell(5);
      cell.setCellStyle(style);
      cell.setCellValue("الشعبة");
      cell = row.createCell(6);
      cell.setCellStyle(style);
      cell.setCellValue("وصف المادة");
      cell = row.createCell(7);
      cell.setCellStyle(style);
      cell.setCellValue("البداية");
      cell = row.createCell(8);
      cell.setCellStyle(style);
      cell.setCellValue("النهاية");
      cell = row.createCell(9);
      cell.setCellStyle(style);
      cell.setCellValue("الأيام");
      cell = row.createCell(10);
      cell.setCellStyle(style);
      cell.setCellValue("عدد المسجلين");
      cell = row.createCell(11);
      cell.setCellStyle(style);
      cell.setCellValue("تم بدء الجلسة");
      cell = row.createCell(12);
      cell.setCellStyle(style);
      cell.setCellValue("عدد الحضور");
      cell = row.createCell(13);
      cell.setCellStyle(style);
      cell.setCellValue("ملاحظات");
    }
    
    
    ArrayList<Teacher> Teachers2 = new ArrayList<Teacher>();
    for(Teacher t : Teachers) {
      if(t.Day.equalsIgnoreCase(Day)) Teachers2.add(t);
    }
    for (Object[] object : Method.filter(Attendees, Teachers2, Plan)) {
     
        // Creating a new Row in existing XLSX sheet
        Row row = mySheet.createRow(rownum++);

        int cellnum = 0;
        
        int regesters = 0;
        for (Object obj : object) {
            Cell cell = row.createCell(cellnum);
            
            CellStyle style = myWorkBook.createCellStyle();
            style.setAlignment(CellStyle.ALIGN_CENTER);
            cell.setCellStyle(style);
            
            if (obj instanceof String) {
                cell.setCellValue((String) obj);
                if((String) obj == "لالا") {
                  style = myWorkBook.createCellStyle();
                  Font font = myWorkBook.createFont();
                  font.setColor(HSSFColor.RED.index);
                  style.setFont(font);
                  style.setAlignment(CellStyle.ALIGN_CENTER);
                  cell.setCellStyle(style);
                  cell.setCellValue("لا");
                }
            } else if (obj instanceof Boolean) {
                cell.setCellValue((Boolean) obj);
            } else if (obj instanceof Date) {
                cell.setCellValue((Date) obj);
            } else if (obj instanceof Double) {
                cell.setCellValue((Double) obj);
            }else if (obj instanceof Integer) {
              cell.setCellValue((Integer) obj);
              if(cellnum == 10) regesters = (Integer) obj;
              if(cellnum == 12) {
                int total = (Integer) obj;
                String color = Method.getColor(total, regesters);
                style = myWorkBook.createCellStyle();
                
                if(color.equals("r")) style.setFillForegroundColor(IndexedColors.CORAL.getIndex());
                if(color.equals("g")) style.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
                if(color.equals("lg")) style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
                if(color.equals("ly")) style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
                if(color.equals("y")) style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
                style.setFillPattern(CellStyle.SOLID_FOREGROUND);
                style.setAlignment(CellStyle.ALIGN_CENTER);
                cell.setCellStyle(style);
                
              }
            }
            cellnum = cellnum + 1;
        }
    }
    
    for(int i = 0 ; i <= 15 ; i++) {
    	mySheet.autoSizeColumn(i);
    }
    
    // open an OutputStream to save written data into XLSX file
    FileOutputStream os = new FileOutputStream(path);
    myWorkBook.write(os);
    System.out.println("Writing on XLSX file Finished ...");
  
  }
  
  
  //===========================================================================================
}
