package backend;

import java.util.ArrayList;

public class Method {
  
  
  
  //method to show the Attendees in Screen
  public static void showAttendess(ArrayList<Attendee> Attendees) {
    int i = 0;
    for(Attendee a : Attendees) {
      System.out.println(i);
      System.out.println("SessionDate: "+ a.SessionDate);
      System.out.println("SessionName: "+ a.SessionName);
      System.out.println("SessionIdentifier: "+ a.SessionIdentifier);
      System.out.println("SessionOwner: "+ a.SessionOwner);
      System.out.println("RoomOpened: "+ a.RoomOpened);
      System.out.println("RoomClosed: "+ a.RoomClosed);
      System.out.println("NameOfAttendee: "+ a.NameOfAttendee);
      System.out.println("FirstNameOfAttendee: "+ a.FirstNameOfAttendee);
      System.out.println("LastNameOfAttendee: "+ a.LastNameOfAttendee);
      System.out.println("Username: "+ a.Username);
      System.out.println("AttendeeRole: "+ a.AttendeeRole);
      System.out.println("AttendeeType: "+ a.AttendeeType);
      System.out.println("AttendeeFirstJoinTime: "+ a.AttendeeFirstJoinTime);
      System.out.println("AttendeeLastLeaveTime: "+ a.AttendeeLastLeaveTime);
      System.out.println("AttendeeTotalTimeInSession: "+ a.AttendeeTotalTimeInSession);
      System.out.println("AttendeeTotalRejoins: "+ a.AttendeeTotalRejoins);
      System.out.println("===========================================================");
      i++;
    }
  }
  
  
  
  //method to show the Attendees in Screen
  public static void showAttendess2(ArrayList<Attendee> Attendees) {
    int i = 0;
    for(Attendee a : Attendees) {
      
      if(!a.AttendeeRole.equals("Participant")) {
        System.out.println(i);
        System.out.println("SessionDate: "+ a.SessionDate);
        System.out.println("SessionName: "+ a.SessionName);
        System.out.println("SessionIdentifier: "+ a.SessionIdentifier);
        System.out.println("SessionOwner: "+ a.SessionOwner);
        System.out.println("RoomOpened: "+ a.RoomOpened);
        System.out.println("RoomClosed: "+ a.RoomClosed);
        System.out.println("NameOfAttendee: "+ a.NameOfAttendee);
        System.out.println("FirstNameOfAttendee: "+ a.FirstNameOfAttendee);
        System.out.println("LastNameOfAttendee: "+ a.LastNameOfAttendee);
        System.out.println("Username: "+ a.Username);
        System.out.println("AttendeeRole: "+ a.AttendeeRole);
        System.out.println("AttendeeType: "+ a.AttendeeType);
        System.out.println("AttendeeFirstJoinTime: "+ a.AttendeeFirstJoinTime);
        System.out.println("AttendeeLastLeaveTime: "+ a.AttendeeLastLeaveTime);
        System.out.println("AttendeeTotalTimeInSession: "+ a.AttendeeTotalTimeInSession);
        System.out.println("AttendeeTotalRejoins: "+ a.AttendeeTotalRejoins);
        System.out.println("===========================================================");
      }
      
      i++;
    }
  }
  
  
  
  //method to show the Teachers in Screen
  public static void showTeachers(ArrayList<Teacher> Teachers) {
    int i = 0;
    for(Teacher t : Teachers) {
      System.out.println(i);
      System.out.println("Section: "+ t.Section);
      System.out.println("ID: "+ t.ID);
      System.out.println("Name: "+ t.Name);
      System.out.println("Course: "+ t.Course);
      System.out.println("CourseNumber: "+ t.CourseNumber);
      System.out.println("CourseSection: "+ t.CourseSection);
      System.out.println("Description: "+ t.Description);
      System.out.println("Begining: "+ t.Begining);
      System.out.println("Ending: "+ t.Ending);
      System.out.println("Day: "+ t.Day);
      System.out.println("Registered: "+ t.Registered);
      System.out.println("Email: "+ t.Email);
      System.out.println("phone: "+ t.Phone);
      System.out.println("===========================");
      i++;
    }
  }
  
  
  
  //filter to output
  public static ArrayList<Object[]> filter(ArrayList<Attendee> Attendees, ArrayList<Teacher> Teachers, String plan) {
    
    //the return
    ArrayList<Object[]> Objects = new ArrayList<>();
    
    Boolean add = null;
    
    for(Teacher t : Teachers) {
      if(t.Course.contains("ISLM") || t.Course.contains("ARAB")) {
        if(plan.equalsIgnoreCase("A")) add = true;
        else add = false;
      }
      else {
        if(plan.equalsIgnoreCase("A")) add = false;
        else add = true;
      }
      
      if(add) {
        
        int i = 0;
        boolean doctorIsHere = false;
        String r = null;
        
        for(Attendee a : Attendees) {
          if(a.SessionName.contains(t.CourseNumber+"")) {
            if(a.AttendeeRole.equalsIgnoreCase("Moderator")) doctorIsHere = true;
            else i++;
          }
        }
        
        String yesorno = null;
        if(doctorIsHere) yesorno = "نعم";
        else {
          if(i != 0) {
            r = "أستاذ المادة لم يحضر";
            yesorno = "لالا";
          }
          else {
            r = "لا توجد جلسة";
            yesorno = "لا";
          }
        }
        Objects.add(new Object[] {t.Section, t.ID, t.Name, t.Course, t.CourseNumber, t.CourseSection,
            t.Description, t.Begining, t.Ending, t.Day, t.Registered, yesorno, i, r});
        
      }
      
    }
    
    
    //return the result
    return Objects;
  }
  
  
  public static String getColor(int n, int n2) {
    String color = "r";
    if(n != 0 && n2 != 0) {
      double d = (double) n/(double) n2;
      if(d >= 0.9) color = "g";
      else if(d >= 0.8) color = "lg";
      else if(d >= 0.7) color = "ly";
      else if(d >= 0.6) color = "y";
    }
    
    return color;
  }
}
