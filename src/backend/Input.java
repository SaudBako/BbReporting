package backend;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Input {
  
  
  
  //Read Attendees File Method
  //===========================================================================================
  
  public static ArrayList<Attendee> getAttendee(String path) throws IOException {
    
    
    //the return ArrayList
    ArrayList<Attendee> Attendees = new ArrayList<>();
    
    
    
    //exit if the file is not a CSV File
    if(!path.contains(".csv")) {
      System.out.println("Error the File is not a CSV File!, Exit form Program.");
      System.exit(0);
    }
    
    
    
    //create file Input and check if the file not found
    File file = new File(path);
    FileInputStream fis = null;
    try {
      fis = new FileInputStream(file);
    }
    catch (FileNotFoundException e) {
      System.out.println("\nError file not found, Exit form Program.");
      System.exit(0);
    }

    
    
    //create a reader
    Reader reader = null;
    try {
      reader =  new InputStreamReader(fis, "utf-8"); //for Arabic Char
    } catch (UnsupportedEncodingException e) {
      System.out.println("\nError the file have Unsupported Encoding, Exit form Program.");
      System.exit(0);
    }
    
    
    
    //read csv file
    Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(reader);
    
    
    
    //for every record
    for (CSVRecord record : records) {
      
      
      //skipe first record
      if(record.getRecordNumber() != 1) {
        String SessionDate = record.get(0);
        String SessionName = record.get(1);
        String SessionIdentifier = record.get(2);
        String SessionOwner = record.get(3);
        String RoomOpened = record.get(4);
        String RoomClosed = record.get(5);
        String NameOfAttendee = record.get(6);
        String FirstNameOfAttendee = record.get(7);
        String LastNameOfAttendee = record.get(8);
        String Username = record.get(9);
        String AttendeeRole = record.get(10);
        String AttendeeType = record.get(11);
        String AttendeeFirstJoinTime = record.get(12);
        String AttendeeLastLeaveTime = record.get(13);
        String AttendeeTotalTimeInSession = record.get(14);
        String AttendeeTotalRejoins = record.get(15);
        
        //save the information in object
        Attendee attendee = new Attendee(SessionDate, SessionName, SessionIdentifier, SessionOwner,
            RoomOpened, RoomClosed, NameOfAttendee, FirstNameOfAttendee, LastNameOfAttendee, Username,
            AttendeeRole, AttendeeType, AttendeeFirstJoinTime, AttendeeLastLeaveTime,
            AttendeeTotalTimeInSession, AttendeeTotalRejoins);
        
        //add the object to ArrayList
        Attendees.add(attendee);
      }
      
      
    }
    
    
    
    // close the reader
    reader.close();
    
    
    //return the result
    return Attendees;
  }
  
  //===========================================================================================
  
  
  
  
  
  
  
  //Read Teachers File Method
  //===========================================================================================
  
  @SuppressWarnings("resource")
  public static ArrayList<Teacher> getTeachers(String path) throws IOException {
    
    
    //the return ArrayList
    ArrayList<Teacher> Teachers = new ArrayList<>();
    
    //exit if the file is not a XLSX File
    if(!path.contains(".xlsx")) {
      System.out.println("Error the File is not a XLSX File!, Exit form Program.");
      System.exit(0);
    }
    
    
    
    //create file Input and check if the file not found
    File file = new File(path);
    FileInputStream fis = null;
    try {
      fis = new FileInputStream(file);
    }
    catch (FileNotFoundException e) {
      System.out.println("\nError file not found, Exit form Program.");
      System.exit(0);
    }
    
    
    
    // Finds the workbook instance for XLSX file
    XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
    
    // Return first sheet from the XLSX workbook
    XSSFSheet mySheet = myWorkBook.getSheetAt(0);
    
    // Get iterator to all the rows in current sheet
    Iterator<Row> rowIterator = mySheet.iterator();
    
    
    
    //skipe first row
    rowIterator.next();
    
    //for every row
    while (rowIterator.hasNext()) {
      
      Row row = rowIterator.next();
      
      String Section = row.getCell(0).getStringCellValue();
      int ID = (int) row.getCell(1).getNumericCellValue();
      String Name = row.getCell(2).getStringCellValue();
      String Course = row.getCell(3).getStringCellValue();
      int CourseNumber = (int) row.getCell(4).getNumericCellValue();
      
      //integer or string
      String CourseSection = null;
      if(row.getCell(5).getCellType() == 0) CourseSection = ""+((int) row.getCell(4).getNumericCellValue());
      else CourseSection = row.getCell(5).getStringCellValue();
      
      String Description = row.getCell(6).getStringCellValue();
      int Begining = (int) row.getCell(7).getNumericCellValue();
      int Ending = (int) row.getCell(8).getNumericCellValue();
      String Day = row.getCell(9).getStringCellValue();
      int Registered = (int) row.getCell(10).getNumericCellValue();
      String Email = row.getCell(11).getStringCellValue();
      
      //integer or string
      String Phone = null;
      if(row.getCell(12).getCellType() == 0) Phone = ""+((int) row.getCell(4).getNumericCellValue());
      else Phone = row.getCell(12).getStringCellValue();
      
      
      //save the information in object
      Teacher teacher = new Teacher(Section, ID, Name, Course, CourseNumber, CourseSection,
          Description, Begining, Ending, Day, Registered, Email, Phone);
      
      //add the object to ArrayList
      Teachers.add(teacher);
      
    }
    
    
    
    //return the result
    return Teachers;
  }
  
  //===========================================================================================
  
  
  
  
}