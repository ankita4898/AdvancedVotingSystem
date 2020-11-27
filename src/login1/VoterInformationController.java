/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login1;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author bap39
 */
public class VoterInformationController extends VoterValidationController implements Initializable{
    
  /*  public static Connection getConnection() throws SQLException{
       // Class.forName("com.mysql.jdbc.Driver");
        
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/election1","root","root");
        return connection;
    }
    */


    @FXML
    private Label name;
    static String cons;
    
    @FXML
    private Label ward;

    @FXML
    private Label voterid2;
    
    @FXML
    private Label city;

    @FXML
    private Label taluka;

    @FXML
    private Label district;

    @FXML
    private Label state;

    @FXML
    private Label constituency;
    
    @FXML
    private Label pincode;

    @FXML
    private AnchorPane voterinformationPane;
    
    //ObservableList<ModelTable> oblist = FXCollections.observableArrayList();
    //VoterValidationController voter = new VoterValidationController();
     
//VoterValidationController voter = new VoterValidationController();
//     
//     String voter2 = voter.voter;
//     
//     

   // String  voterid1= voterid.getText();
    @FXML
    void confirm(ActionEvent event) throws IOException{
        
          Parent root1 = FXMLLoader.load(getClass().getResource("CandidatesInformation.fxml"));
          //AnchorPane pane= FXMLLoader.load(getClass().getResource("CandidatesInformation.fxml"));
        Scene scene3 = new Scene(root1);
        Stage stage3 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        //Stage stage3=new Stage();
        stage3.setScene(scene3);
        stage3.show();
                //AnchorPane pane= FXMLLoader.load(getClass().getResource("CandidatesInformation.fxml"));
                //voterinformationPane.getChildren().setAll(pane);
        
    }
  
   // @Override
    //public void initialize(URL url, ResourceBundle rb) {
    // @FXML
     // void show(ActionEvent event) throws SQLException{
       VoterValidationController v=new VoterValidationController();
        //String voterid1=v.put1();
       
        
       
        
       
        
       /* name.setCellValueFactory(new PropertyValueFactory<>("name"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        voterid2.setCellValueFactory(new PropertyValueFactory<>("voterid2"));
        city.setCellValueFactory(new PropertyValueFactory<>("city"));
        taluka.setCellValueFactory(new PropertyValueFactory<>("taluka"));
        district.setCellValueFactory(new PropertyValueFactory<>("district"));
        state.setCellValueFactory(new PropertyValueFactory<>("state"));
        constituency.setCellValueFactory(new PropertyValueFactory<>("constituency"));*/
        
        
       // table.setItems(oblist);
     //  }
      
              
        @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
         try {
            voterid2.setText(VoterValidationController.voter);

             Connection con;
                            //Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/election1","root","4898");
            
            Statement stmt=con.createStatement();
             ResultSet rs2 =stmt.executeQuery("select * from voter_address where v_address_id='"
                     +VoterValidationController.voter+"'");
        
        while(rs2.next()){
            //oblist.add(new ModelTable(rs2.getString("v_name"), rs2.getString("v_ward"),rs2.getString("voter_id"), rs2.getString("v_city"), rs2.getString("v_taluka"), rs2.getString("v_district"),rs2.getString("v_state"), rs2.getString("v_constituency")));
            name.setText(rs2.getString("v_name"));
            ward.setText(rs2.getString("v_ward"));
            cons=rs2.getString("v_constituency");
            city.setText(rs2.getString("v_city"));
            taluka.setText(rs2.getString("v_taluka"));
            district.setText(rs2.getString("v_district"));
            state.setText(rs2.getString("v_state"));
            pincode.setText(rs2.getString("v_pincode"));
        }
                
             constituency.setText(cons);   
} catch (SQLException ex) {
            Logger.getLogger(VoterInformationController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
