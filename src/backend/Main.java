package backend;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
/*
  public static void main(String[] args) throws IOException {
    
    
//    //the Path
//    String path = null;
//    
//    
//    //get the Attendees
//    path = "C:\\Users\\r98ra\\Desktop\\workingo\\AttendeeReport_JEDDAH-EU_2020-01-30_2020-01-30 (1).csv";
//    ArrayList<Attendee> Attendees = Input.getAttendee(path);
//    
//    
//    //show Attendees
//    //Method.showAttendess2(Attendees);
//    
//    
//    //get the Attendees
//    path = "C:\\Users\\r98ra\\Desktop\\workingo\\��������.xlsx";
//    ArrayList<Teacher> Teachers = Input.getTeachers(path);
//    
//    
//    //show Teachers
//    //Method.showTeachers(Teachers);
//    
//    
//    
//    //write 
//    path = "C:\\Users\\r98ra\\Desktop\\workingo\\Output.xlsx";
//    Output.write(path, Attendees, Teachers, "R", "A");
//    
//    
//    //finish the program
//    System.out.println("Finish!");
//    System.exit(0);
    
    
  }*/
  
  public static void Print(String Attendee_Path, String Odus_Path, String Day, String Plan, String Output_Path) throws IOException {
    ArrayList<Attendee> Attendees = Input.getAttendee(Attendee_Path);
    ArrayList<Teacher> Teachers = Input.getTeachers(Odus_Path);
    Output.write(Output_Path, Attendees, Teachers, Day, Plan);
  }
}
