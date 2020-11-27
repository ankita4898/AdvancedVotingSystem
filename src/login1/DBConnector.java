
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Shree
 */
public class DBConnector {
    
    public static Connection getConnection() throws SQLException{
        
        Connection connection1 = DriverManager.getConnection("jdbc:mysql://localhost/election1", "root", "4898");
        return connection1;
    }
    
}
