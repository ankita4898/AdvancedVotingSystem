/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author bap39
 */
public class RulesController implements Initializable {

    @FXML
    private CheckBox checkit2;

    @FXML
    private Button btnproceed;
    

   
       @FXML
     boolean checkbox(ActionEvent event) {
        checkit2.requestFocus();
        
         return false;
    }

    @FXML
    void rules(ActionEvent event) throws IOException {
        
        
        if(!(checkit2.isSelected())){
            Alert alert;
            alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validation Fields");
            alert.setHeaderText(null);
            alert.setContentText("Please Read all Rules");
            alert.showAndWait();
            
        }else{
        Parent root1 = FXMLLoader.load(getClass().getResource("VoterValidation.fxml"));
        Scene scene1 = new Scene(root1);
        Stage stage = new Stage();
        stage.setScene(scene1);
        stage.show();
        }
        
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
