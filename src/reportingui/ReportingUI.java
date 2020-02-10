/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportingui;

import static backend.Main.Print;
import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class ReportingUI extends Application {
    
    private static Stage mainStage;
    
    @Override
    public void start(Stage stage) throws Exception {
        mainStage = stage;
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
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
    
    public static void main(String[] args) {
        /*
        try {
            backend.Main.Print(
            "C:\\Users\\soud5\\Desktop\\AttendeeReport_JEDDAH-EU_2020-01-30_2020-01-30 (1).csv",
            "C:\\Users\\soud5\\Desktop\\enlezy.xlsx",
            "W",
            "B",
            "C:\\Users\\soud5\\Desktop"
            ); 
        } catch(Exception e) {
            System.out.println("Not so-so "+e.getMessage());
        }*/
        
        launch(args); 
        
        
        
    }
    
}
