/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class InstructionsController implements Initializable {
    

     @FXML
    private Button btnnext;
     
       @FXML
    private CheckBox checkit1;
    @FXML
    private AnchorPane instructionPane;


       @FXML
     boolean checkbox(ActionEvent event) {
        checkit1.requestFocus();
        
         return false;
    }

    
     @FXML
     private void next(ActionEvent event) throws Exception
     {
         if(!(checkit1.isSelected())){
            Alert alert;
            alert = new Alert(AlertType.WARNING);
            alert.setTitle("Validation Fields");
            alert.setHeaderText(null);
            alert.setContentText("Please Read all Rules");
            alert.showAndWait();
            
        }else{
             
        Parent root = FXMLLoader.load(getClass().getResource("Rules.fxml"));
        //AnchorPane pane1= FXMLLoader.load(getClass().getResource("Rules.fxml"));
               // instructionPane.getChildren().setAll(pane1);
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
         }
         
                
        
        
     }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
