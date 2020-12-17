package e_m_s;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Add_elmpoyee {

    private Connection connect = null;
    private PreparedStatement preparedStatement = null;
    Scanner input = null;

    void readData() {
        try {
            connect = ApiClient.getInstance();
            input = new Scanner(System.in);

            String nam, gen, title, phone, adress;
            int age, sal;

            preparedStatement = connect.prepareStatement("INSERT INTO e_list(name,age,gender,title) VALUES (?,?,?,?)", new String[]{"user_id"});

            System.out.println("Name: ");
            nam = input.nextLine();
            System.out.println("Age: ");
            age = input.nextInt();
            input.nextLine();
            System.out.println("Gender: ");
            gen = input.nextLine();
            System.out.println("Title: ");
            title = input.nextLine();

            preparedStatement.setString(1, nam);
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3, gen);
            preparedStatement.setString(4, title);

            System.out.println("Phone: ");
            phone = input.nextLine();
            System.out.println("Salary: ");
            sal = input.nextInt();
            input.nextLine();
            System.out.println("Addrees: ");
            adress = input.nextLine();

            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            int id = 0;
            while (rs.next()) {
                id = rs.getInt(1);
                System.out.println("Key: " + rs.getInt(1));
            }

            String sql = "INSERT INTO e_details(user_id, phone_number, salary, adress) VALUES(?,?,?,?)";

            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, phone);
            preparedStatement.setInt(3, sal);
            preparedStatement.setString(4, adress);

            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("A row has been inserted.");
            }

            preparedStatement.close();
            connect.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("" + e);
        }
    }

}
