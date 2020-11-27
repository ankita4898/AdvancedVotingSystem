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
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author bap39
 */
public class FXMLDocumentController implements Initializable {
    
    


    @FXML
    private TextField txtuname;

    @FXML
    private PasswordField txtpass;

    @FXML
    private Button btnok;
    
    static String uname;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private ImageView mainImage;
    
    @FXML
    void login(ActionEvent event) throws SQLException {
        
    Connection con;
    PreparedStatement pst;
    
    ResultSet rs;
    
    uname = txtuname.getText();

    String pass = txtpass.getText();
        
    
    if(uname.equals("") && pass.equals(""))
        {
            
            JOptionPane.showMessageDialog(null, "Booth ID or Password is Blank");

           
        }else
        {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/election1","root","4898");

                
                pst = con.prepareStatement("select * from booth_login where booth_id=? and b_password=?");
                pst.setString(1, uname);
                pst.setString(2, pass);
                
                rs = pst.executeQuery();
                
                if(rs.next())
                {
                    int s=rs.getInt("login_count");
                    s=s+1;
                    int rs1=con.createStatement().executeUpdate("update booth_login set login_count="+s+" where booth_id='"+uname+"'");
                    JOptionPane.showMessageDialog(null, "Login Success");
                     try {
                Parent root = FXMLLoader.load(getClass().getResource("Instructions.fxml"));
                //AnchorPane pane= FXMLLoader.load(getClass().getResource("Instructions.fxml"));
               // rootPane.getChildren().setAll(pane);
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                    
                }else
                {
                    JOptionPane.showMessageDialog(null, "Login Failed");
                    txtuname.setText("");
                    txtpass.setText("");
                    txtuname.requestFocus();
                }
                
                
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    



    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //mainImage=new ImageView(new Image(this.getClass().getResourceAsStream("C:\\Users\\Shree\\Documents\\NetBeansProjects\\Login1\\src\\gallery\\Election_Commission_of_India_Logo.png")));
         Image image=new Image("/gallery/Election_Commission_of_India_Logo.png");
        mainImage.setImage(image);
    }
    
}
