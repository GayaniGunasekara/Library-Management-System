import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddMember {

    public void addMember() {
        // This is the method that will be responsible for adding a new member to the database


        Scanner scanner = new Scanner(System.in);          //Create a Scanner object to read input from the user

        System.out.print("Enter member name: ");           //Prompt the user to enter the member name
        String name = scanner.nextLine();                  //Read the user's input for the member name

        System.out.print("Enter member email: ");         // Prompt the user to enter the member email
        String email = scanner.nextLine();                //Read the user's input for the member email

        System.out.print("Enter member phone: ");         //Prompt the user to enter the member phone number
        String phone = scanner.nextLine();                // Read the user's input for the member phone number




        String query = "INSERT INTO members (name, email, phone) VALUES (?, ?, ?)";              //Defines an SQL query string to insert a new member into the members table in library_db



        try (Connection connection = JDBC.getConnection();                                         // Make a connection to the database using a method getConnection() from the JDBC class
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, name);               //Set the first placeholder (?) in the SQL query to the member name
            preparedStatement.setString(2, email);              //Set the second placeholder (?) in the SQL query to the member email
            preparedStatement.setString(3, phone);              //Set the third placeholder (?) in the SQL query to the member phone number

            int rowsAffected = preparedStatement.executeUpdate();            //Execute the SQL query and returns the number of rows affected by the operation
            if (rowsAffected > 0) {                                          //Check if any rows were affected by the query
                System.out.println("Member added successfully!");            //Print a message if the member was added
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
