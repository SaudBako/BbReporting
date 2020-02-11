package reportingui;

import backend.*;
import java.io.*;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.stage.FileChooser.ExtensionFilter;

public class ReportingUI extends Application {
    
    private static Stage mainStage;
    
    private static final String INITIAL = "لم يبدأ";
    private static final String PROCESSING = "جاري المعالجة";
    private static final String ERROR = "حدث خطأ";
    private static final String SUCCESS = "تمت العملية بنجاح";
    
    @Override
    public void start(Stage stage) throws Exception {
        mainStage = stage;
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
        setState(INITIAL);
    }
    
    // @param extension must be preceded with *.
    public static String chooseFile(String description, String extension) {
        // create a File chooser 
        FileChooser fileChooser = new FileChooser();
                
        // create description limiter on choosing files
        ExtensionFilter extFilter = new ExtensionFilter(description, extension);
        fileChooser.getExtensionFilters().add(extFilter);
        
        try {
            // get the file selected
            File file = fileChooser.showOpenDialog(mainStage); 

            // return the path if it exists
            return file.getAbsolutePath();
            
        } catch(Exception e) {
            return "";
        }
    }
    
    public static String chooseDirectory() {
        try {
            return new DirectoryChooser().showDialog(mainStage).getAbsolutePath();
        } catch (Exception e) { return ""; }
    }
    
    public static void generateReport(String attendancePath, String odusPath, String day, String planName, String outputPath) {        
      
        setState(PROCESSING);
        
        String plan = planName.equals("المواد العامة") ? "A" : "B";
        
        System.out.println("=================");
        System.out.println("Inputs: ");
        System.out.println(attendancePath+"\n"+odusPath+"\n"+day+"\n"+plan+"\n"+outputPath);
        System.out.println("=================");
        
        try {
            ArrayList<Attendee> Attendees = Input.getAttendee(attendancePath);
            ArrayList<Teacher> Teachers = Input.getTeachers(odusPath);
            Output.write(outputPath, Attendees, Teachers, day, plan);
            
            setState(SUCCESS);
        } catch (Exception e) { setState(ERROR); }      
    }
    
    private static void setState(String state) {
        ((Label) mainStage.getScene().lookup("#stateLabel")).setText(state);
    }
    
    public static void main(String[] args) { launch(args); }
    
}
