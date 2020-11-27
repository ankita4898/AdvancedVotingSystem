/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Shree
 */
public class ThankYouController implements Initializable {

    @FXML
    private AnchorPane thankyouPane;
    @FXML
    private Button done;




    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
           /* Timer time=new Timer();
        TimerTask t=new TimerTask(){
        //time.schedule(new TimeTask(){
            @Override
            public void run(){
                AnchorPane pane;
                try {
                    pane = FXMLLoader.load(getClass().getResource("VoterValidation.fxml"));
                    thankyouPane.getChildren().setAll(pane);
                } catch (IOException ex) {
                    Logger.getLogger(ThankYouController.class.getName()).log(Level.SEVERE, null, ex);
                }  
            }
        };
        
        time.schedule(t, 3000);*/
    }       

    @FXML
    private void Done(ActionEvent event) {
        Parent pane;
        try {
            pane = FXMLLoader.load(getClass().getResource("VoterValidation.fxml"));
            
        thankyouPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(ThankYouController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
