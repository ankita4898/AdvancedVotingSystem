/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login1;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author bap39
 */
public class FingerprintController extends CandidatesInformationController implements Initializable {

    @FXML
    private Label c_voted_id;
    @FXML
    private Label c_voted_party;
    @FXML
    private Label c_voted_name;
    @FXML
    private Button confirm_vote;
    @FXML
    private AnchorPane votedPane;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CandidatesInformationController c2=new CandidatesInformationController();
            VoterValidationController v=new VoterValidationController();
            
            FXMLDocumentController fx=new FXMLDocumentController();
            try {
            c_voted_id.setText(c2.c);

             Connection con;
              Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/election1","root","4898");
            
            Statement stmt=con.createStatement();
            Statement stmt1=con.createStatement();
             ResultSet rs2 =stmt.executeQuery("select * from votes where c_id='"+c2.c+"'");
               while(rs2.next()){
            
            c_voted_name.setText(rs2.getString("c_name"));
            c_voted_party.setText(rs2.getString("c_party"));

        }
             stmt1.executeUpdate("Insert into voter_voted (voter_id,booth_id) values ("+v.voter+","+fx.uname+")");
             //con.commit();
        
      
                
                
} catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(VoterInformationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void confirmVote(ActionEvent event) {
     try {

               // Parent root = FXMLLoader.load(getClass().getResource("C:\\Users\\Shree\\Documents\\NetBeansProjects\\Login1\\src\\login1\\VoterInformation.fxml"));
               /* Parent root = FXMLLoader.load(getClass().getResource("ThankYou.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();*/
               AnchorPane pane= FXMLLoader.load(getClass().getResource("ThankYou.fxml"));
               votedPane.getChildren().setAll(pane);
                
            } catch (IOException ex) {
                Logger.getLogger(VoterValidationController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}
