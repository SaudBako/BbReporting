/*
 * TODO:
    1- Check that all fields are ready then ectivate start button.
    2- See if we can do file drag and drop on the file text area.
    4- Start button should display all values
    - ComboBox text color
 */
package reportingui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

/**
 *
 * @author soud5
 */
public class FXMLDocumentController implements Initializable {
    
    // Days
    private String days[] = { "S", "M", "T", "W", "R" }; 

    // Plans
    private String plans[] = { "المواد العامة", "مواد التحضيري" };
    
    @FXML
    private TextField odusText;
    @FXML
    private TextField attendanceText;
    @FXML
    private ComboBox daysComboBox;
    @FXML
    private ComboBox plansComboBox;
    @FXML
    private TextField outputText;
    @FXML
    private Label appStatusLabel;
        
    @FXML
    private void submit(ActionEvent event) {
        appStatusLabel.setText("معالجة");
        
        System.out.println(attendanceText.getText()+"\n"+odusText.getText()+"\n"+daysComboBox.getValue().toString()+"\n"+(plansComboBox.getValue().toString().equals("المواد العامة") ? "A" : "B")+"\n"+outputText.getText());
        
        try {
            backend.Main.Print(
                attendanceText.getText(),
                odusText.getText(),
                daysComboBox.getValue().toString(),
                plansComboBox.getValue().toString().equals("المواد العامة") ? "A" : "B",
                outputText.getText()
            );
            
            appStatusLabel.setText("تمت العملية بنجاح");
        } catch (Exception e) {
            appStatusLabel.setText("حدث خطأ");
        }
        
        
    }
    
    @FXML
    private void chooseOdusFile(ActionEvent event) {
        odusText.textProperty().set(ReportingUI.chooseFile("XLSX file (*.xlsx)", "*.xlsx"));
    }
    
    @FXML
    private void chooseAttendanceFile(ActionEvent event) {
        attendanceText.setText(ReportingUI.chooseFile("CSV file (*.csv)", "*.csv"));
    }
    
    @FXML
    private void chooseOutputFolder(ActionEvent event) {
        outputText.setText(ReportingUI.chooseDirectory());
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setupComboBoxes();
    }
    
    private void setupComboBoxes() {        
        // Create a combo box 
        daysComboBox.setItems(FXCollections.observableArrayList(days));
        plansComboBox.setItems(FXCollections.observableArrayList(plans));
    }
    
}
