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
import java.sql.PreparedStatement;
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
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author bap39
 */
public class VoterValidationController extends FXMLDocumentController implements Initializable {

   

    @FXML
    public TextField voterid;

    @FXML
    private TextField aadharcard;

    @FXML
    private Button check2; 

    static String voter;
    @FXML
    private AnchorPane validationPane;

    @FXML
    void checkaadhar(ActionEvent event) throws SQLException, IOException {
 

    Connection con1;
    PreparedStatement pst1;
    ResultSet rs1;
    
    
    String  aadhar= aadharcard.getText();
    voter= voterid.getText();
    if(voter.equals(""))
        { 
            
            JOptionPane.showMessageDialog(null, "Voter ID Number is Blank");
            
        }else if(aadhar.equals("")){
            
            JOptionPane.showMessageDialog(null, "Aadhar Card Number is Blank");
            
        }else{
                
                try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con1 = DriverManager.getConnection("jdbc:mysql://localhost/election1","root","4898");

                
                pst1 = con1.prepareStatement("select * from voter_info where aadhar_no=? and voter_id=?");
                pst1.setString(1, aadhar);
                pst1.setString(2, voter);
                
                rs1 = pst1.executeQuery();
                if(rs1.next())
                {
                    Statement stmt=con1.createStatement();
                    ResultSet rs2 =stmt.executeQuery("select * from voter_voted where voter_id='"+voter+"'");
                    if(rs2.next())
                    {
                    JOptionPane.showMessageDialog(null, "This Voter has Already Voted!");
                    aadharcard.setText("");
                    voterid.setText("");
                    aadharcard.requestFocus();
                    voterid.requestFocus();
                    }
             
                    else{
                          //JOptionPane.showMessageDialog(null, "Aadhar Card No and Voter ID number is Verified!!");
                        try {
                         
                           Parent pane = FXMLLoader.load(getClass().getResource("VoterInformation.fxml"));
                           //Scene scene2 = new Scene(pane);
                            //To get stage information
                            //Stage stage1=new Stage();
                           // Stage stage1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
                           //stage1.setScene(scene2);
                            //stage1.show();
                           //AnchorPane pane= FXMLLoader.load(getClass().getResource("VoterInformation.fxml"));
                           validationPane.getChildren().setAll(pane);
                
                            }catch (IOException ex) {
                            Logger.getLogger(VoterValidationController.class.getName()).log(Level.SEVERE, null, ex);
                            }                  
                        }
                }
                else{
                   JOptionPane.showMessageDialog(null, "Aadhar Card No and Voter ID No is not Verified!");
                    aadharcard.setText("");
                    voterid.setText("");
                    aadharcard.requestFocus();
                    voterid.requestFocus();
                }    
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(VoterValidationController.class.getName()).log(Level.SEVERE, null, ex);
       
            }
            
            }

        }
 
    
    
   // public static String a;
     //   @FXML
     //   public static String put1(){
       // a= voter;
        //return a;
   // }
    


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    String getText() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}


