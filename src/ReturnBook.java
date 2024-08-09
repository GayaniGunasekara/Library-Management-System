import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Date;
import java.time.LocalDate;


public class ReturnBook {

    public void returnBook() {
        //This is the method that will be responsible for marking a book as returned


        Scanner scanner = new Scanner(System.in);                           //Create a Scanner object to read input from the user

        System.out.print("Enter loan ID: ");                                // Prompt the user to enter the loan ID
        int loanId = scanner.nextInt();                                     //Read the user's input for the loan ID

        LocalDate returnDate = LocalDate.now();                              //Set the return date to the current date



        String query = "UPDATE loans SET return_date = ? WHERE loan_id = ?";   //Define an SQL query string to update the return date for a specific loan identified by the loan ID


        try (Connection connection = JDBC .getConnection();                    // Make a connection to the database using a method getConnection() from the JDBC class
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setDate(1, Date.valueOf(returnDate));          //Set the first placeholder (?) in the SQL query to the return date
            preparedStatement.setInt(2, loanId);                             //Set the second placeholder (?) in the SQL query to the loan ID


            int rowsAffected = preparedStatement.executeUpdate();                          //Execute the SQL query and returns the number of rows affected by the operation
            if (rowsAffected > 0) {                                                        //Check if any rows were affected by the query
                System.out.println("Book returned successfully!");                         // Print a message if the book was returned
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
