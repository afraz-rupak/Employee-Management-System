package e_m_s;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public abstract class ApiClient {
    private static Connection connector;
    
    static Connection getInstance() throws SQLException, ClassNotFoundException
    {
        if(connector==null)
        {
            Class.forName("com.mysql.jdbc.Driver");
            connector = DriverManager.getConnection("jdbc:mysql://localhost/e_m_s?"+"user=root");
            System.out.println("Connected to database");
        }
       return connector;
    }

}
