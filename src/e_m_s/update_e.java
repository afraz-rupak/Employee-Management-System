package e_m_s;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class update_e {
    private Connection connect = null;
    private PreparedStatement preparedStatement = null;
    
    private ResultSet result = null;
    
    Scanner input = null;
    //String id;
    
      void updata() {
        try {
            connect = ApiClient.getInstance();
            input = new Scanner(System.in);

            /*String op, nam, gen, title, phone, adress;
            int age, sal;
            System.out.println("Which ");*/

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
                System.out.println("1.Name: " + result.getString("name")+"\t\t"+"2.Age: " + result.getString("age"));
                //System.out.println("Age: " + result.getString("age"));
                System.out.println("3.Gender: " + result.getString("gender")+"\t\t"+"4.Pro.title: " + result.getString("title"));
                //System.out.println("Pro.title: " + result.getString("title"));
                System.out.println("5.Phone_number: " + result.getString("phone_number")+"\t"+"6.Salary: " + result.getString("salary"));
                //System.out.println("salary: " + result.getString("salary"));
                System.out.println("7.Address: " + result.getString("adress"));
                System.out.println("========================================================================");
                
            }
            
            /////////////////////////////////////////////////////////////////////////////////////////////////////////
            System.out.println("which one you like to update"+"\nplease press the number: ");
            int op = input.nextInt();
            
            switch(op){
                case 1:
                    preparedStatement = connect.prepareStatement("UPDATE e_list set name=? where id=?");
                    System.out.print("Please input name: ");
                    preparedStatement.setString(1,input.next());
                    preparedStatement.setString(2,id);
                    break;
                case 2:
                    preparedStatement = connect.prepareStatement("UPDATE e_list set age=? where id=?");
                    System.out.print("Please input Age: ");
                    preparedStatement.setInt(1,input.nextInt());
                    preparedStatement.setString(2,id);
                    break;
                case 3:
                    preparedStatement = connect.prepareStatement("UPDATE e_list set gender=? where id=?");
                    System.out.print("Please input Gender: ");
                    preparedStatement.setString(1,input.next());
                    preparedStatement.setString(2,id);
                    break;
                case 4:
                    preparedStatement = connect.prepareStatement("UPDATE e_list set title=? where id=?");
                    System.out.print("Please input Title: ");
                    preparedStatement.setString(1,input.next());
                    preparedStatement.setString(2,id);
                    break;
                case 5:
                    preparedStatement = connect.prepareStatement("UPDATE e_details set phone_number=? where user_id=?");
                    System.out.print("Please input phone number: ");
                    preparedStatement.setString(1,input.next());
                    preparedStatement.setString(2,id);
                    break;
                case 6:
                    preparedStatement = connect.prepareStatement("UPDATE e_details set salary=? where user_id=?");
                    System.out.print("Please input Salary: ");
                    preparedStatement.setInt(1,input.nextInt());
                    preparedStatement.setString(2,id);
                    break;
                case 7:
                    preparedStatement = connect.prepareStatement("UPDATE e_details set adress=? where user_id=?");
                    System.out.print("Please input Address: ");
                    preparedStatement.setString(1,input.next());
                    preparedStatement.setString(2,id);
                    break;
           
            }
            
            preparedStatement.execute();
            preparedStatement.close();
            connect.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("" + e);
        }
    }
    
}
