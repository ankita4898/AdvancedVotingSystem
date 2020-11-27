/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login1;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author bap39
 */
public class CandidatesInformationController extends VoterInformationController implements Initializable{
    
  /*  public static Connection getConnection() throws SQLException{
        
        Connection connection1 = DriverManager.getConnection("jdbc:mysql://localhost/election1", "root", "root");
        return connection1;
    }
    */
    @FXML
    private TableView<CandidateTable> candidate_table;

    @FXML
    private TableColumn<CandidateTable, String> c_name;

    @FXML
    private TableColumn<CandidateTable, ImageView> c_sign;

    @FXML
    private TableColumn<CandidateTable, String> c_party;

    @FXML
    private TableColumn<CandidateTable, String> c_vote;

    @FXML
    private TableColumn<CandidateTable, String> c_id;

    ObservableList<CandidateTable> oblist1 = FXCollections.observableArrayList();
    
    VoterInformationController i=new VoterInformationController();
    //VoterValidationController voter = new VoterValidationController();
     
//     VoterValidationController voter = new VoterValidationController();
//     
//     String voter2 = voter.voter;
//     
//     

//    @FXML
//    void confirm(ActionEvent event) throws IOException{
//        
//          Parent root = FXMLLoader.load(getClass().getResource("Fingerprint.fxml"));
//        Scene scene = new Scene(root);
//        Stage stage = new Stage();
//        stage.setScene(scene);
//        stage.show();
//
//        
//    }
  static String c;
    @FXML
    private AnchorPane candidateinformationPane;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
       // Connection conn1;
        
        try {
            
            //conn1 = VoterInformationController.getConnection();
            
                         Connection con=DBConnector.getConnection();
                            //Class.forName("com.mysql.cj.jdbc.Driver");
               ResultSet rs3 = con.createStatement().executeQuery("select * from candidates where c_constituency='"+i.cons+"'");
        /*while(rs3.next()){
            Blob blob=rs3.getBlob("c_symbol");
            InputStream is=blob.getBinaryStream();
            Image img=new Image(is);
            ImageView symbol=new ImageView(img);
            oblist1.add(new CandidateTable(rs3.getString("c_name"), symbol ,rs3.getString("c_party"),rs3.getString("c_id")));
        }*/
                    while(rs3.next()){
            InputStream is=rs3.getBinaryStream("c_symbol");
            ImageView symbol=new ImageView();
            if(is != null && is.available()>1){
            Image img=new Image(is);
            symbol.fitWidthProperty().bind(c_sign.widthProperty());
            symbol.fitHeightProperty().bind(c_sign.widthProperty());
            symbol.setImage(img);
            oblist1.add(new CandidateTable(rs3.getString("c_name"), symbol ,
                    rs3.getString("c_party"),rs3.getString("c_id")));
            }    
        }         
        } catch (SQLException|IOException ex) {
            Logger.getLogger(CandidatesInformationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       

        c_name.setCellValueFactory(new PropertyValueFactory<>("c_name"));
        c_sign.setPrefWidth(80);
        c_sign.setCellValueFactory(new PropertyValueFactory<>("c_sign"));
        c_party.setCellValueFactory(new PropertyValueFactory<>("c_party"));
        c_id.setCellValueFactory(new PropertyValueFactory<>("c_id"));
       //ImageView symbol=new ImageView(new Image(this.getClass().getResourceAsStream("Image URL")))
        
        candidate_table.setItems(oblist1);
        
        
        Callback<TableColumn<CandidateTable,String>,TableCell<CandidateTable,String>> cellFactory=(param)->{
            final TableCell<CandidateTable,String> cell=new TableCell<CandidateTable,String>(){
                
                @Override
                public void updateItem(String item,boolean empty){
                    super.updateItem(item,empty);
                    if(empty){
                        setGraphic(null);
                        setText(null);
                    }
                    else{
                        final Button vote2=new Button("VOTE");
                        vote2.setOnAction(event ->{
                            try{
                            CandidateTable c1=getTableView().getItems().get(getIndex());
                           Connection con1=DBConnector.getConnection();
                            c=c1.getC_id();
                            ResultSet rs2 = con1.createStatement().executeQuery("select * from votes where c_id='"+c+"'");
                            rs2.next();
                            int s;
                            s=rs2.getInt("vote_count");
                            s=s+1;
                            int rs4 = con1.createStatement().executeUpdate("update votes set vote_count="+s+" where c_id='"+c+"'");
                            //con1.commit();
                            }catch(SQLException e){
                            Logger.getLogger(CandidatesInformationController.class.getName()).log(Level.SEVERE, null, e);
                            }
                            try{
                                //String s1=Integer.toString(s);
                                //JOptionPane.showMessageDialog(null, "Your vote has been recorded!!!");
                                Parent root = FXMLLoader.load(getClass().getResource("Fingerprint.fxml"));
                                Scene scene = new Scene(root);
                                Stage stage2 =(Stage) ((Node)event.getSource()).getScene().getWindow();
                                scene.getStylesheets().add("/CSS/CandidateInformation.css");
                                stage2.setScene(scene);
                                stage2.show();
                                //AnchorPane pane= FXMLLoader.load(getClass().getResource("Fingerprint.fxml"));
                                //candidateinformationPane.getChildren().setAll(pane);
                            }catch(IOException e1){
                                Logger.getLogger(CandidatesInformationController.class.getName()).log(Level.SEVERE, null, e1);
                            }
                        });
                        setGraphic(vote2);
                        setText(null);
                    }
                };
            };
                
            
            return cell;
            
        };
        c_vote.setCellFactory(cellFactory);
        
    }    
    
}
