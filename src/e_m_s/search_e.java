package e_m_s;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class search_e {
    private Connection connect = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet result = null;
    Scanner input = null;
    
    
      void Search() {
        try {
            connect = ApiClient.getInstance();
            input = new Scanner(System.in);
            String id;
            System.out.print("Enter your Empolyee id : ");
            id = input.nextLine();
            
            preparedStatement = connect.prepareStatement("SELECT e_list.id, e_list.name, e_list.age, e_list.gender, e_list.title,e_details.phone_number, e_details.salary, e_details.adress FROM e_list INNER JOIN e_details ON e_list.id = e_details.user_id WHERE e_list.id = ? and e_details.user_id = ?");
            
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, id);
            result = preparedStatement.executeQuery();

            while (result.next()) {
                System.out.println("========================================================================");
                System.out.println("Empolyee id : " + result.getString("id"));
                System.out.println("Name: " + result.getString("name")+"\t\t"+"Age: " + result.getString("age"));
                //System.out.println("Age: " + result.getString("age"));
                System.out.println("Gender: " + result.getString("gender")+"\t\t"+"Pro.title: " + result.getString("title"));
                //System.out.println("Pro.title: " + result.getString("title"));
                System.out.println("phone_number: " + result.getString("phone_number")+"\t"+"salary: " + result.getString("salary"));
                //System.out.println("salary: " + result.getString("salary"));
                System.out.println("Address: " + result.getString("adress"));
                System.out.println("========================================================================");
                
            }
            
            preparedStatement.close();
            connect.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("" + e);
        }
    }
    
}
