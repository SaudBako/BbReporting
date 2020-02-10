package backend;

public class Attendee {

  public Attendee(String SessionDate, String SessionName, String SessionIdentifier,
      String SessionOwner,  String RoomOpened, String RoomClosed, String NameOfAttendee, String FirstNameOfAttendee,
      String LastNameOfAttendee, String Username, String AttendeeRole, String AttendeeType,
      String AttendeeFirstJoinTime, String AttendeeLastLeaveTime, String AttendeeTotalTimeInSession, String AttendeeTotalRejoins) {
    this.SessionDate = SessionDate;
    this.SessionName = SessionName;
    this.SessionIdentifier = SessionIdentifier;
    this.SessionOwner = SessionOwner;
    this.RoomOpened = RoomOpened;
    this.RoomClosed = RoomClosed;
    this.NameOfAttendee = NameOfAttendee;
    this.FirstNameOfAttendee = FirstNameOfAttendee;
    this.LastNameOfAttendee = LastNameOfAttendee;
    this.Username = Username;
    this.AttendeeRole = AttendeeRole;
    this.AttendeeType = AttendeeType;
    this.AttendeeFirstJoinTime = AttendeeFirstJoinTime;
    this.AttendeeLastLeaveTime = AttendeeLastLeaveTime;
    this.AttendeeTotalTimeInSession = AttendeeTotalTimeInSession;
    this.AttendeeTotalRejoins = AttendeeTotalRejoins;
  }
  
  String SessionDate;
  String SessionName;
  String SessionIdentifier;
  String SessionOwner;
  String RoomOpened;
  String RoomClosed;
  String NameOfAttendee;
  String FirstNameOfAttendee;
  String LastNameOfAttendee;
  String Username;
  String AttendeeRole;
  String AttendeeType;
  String AttendeeFirstJoinTime;
  String AttendeeLastLeaveTime;
  String AttendeeTotalTimeInSession;
  String AttendeeTotalRejoins;
  
}
