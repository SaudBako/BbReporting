package backend;

public class Teacher {
  
  Teacher(String Section, int ID, String Name, String Course, int CourseNumber, String CourseSection,
      String Description, int Begining, int Ending, String Day, int Registered, String Email, String Phone){
    this.Section = Section;
    this.ID = ID;
    this.Name = Name;
    this.Course = Course;
    this.CourseNumber = CourseNumber;
    this.CourseSection = CourseSection;
    this.Description = Description;
    this.Begining = Begining;
    this.Ending = Ending;
    this.Day = Day;
    this.Registered = Registered;
    this.Email = Email;
    this.Phone = Phone;
  }
  
  
  String Section; //�����
  int ID;
  String Name;
  String Course; //������
  int CourseNumber; //����� �������
  String CourseSection; //������
  String Description; //�����
  int Begining; //�������
  int Ending; //�������
  String Day;
  int Registered; //��������
  String Email; //������ ����������
  String Phone; //������
  
  
}
