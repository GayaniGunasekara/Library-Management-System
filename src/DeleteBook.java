import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteBook {

    public void deleteBook() {
        //This is the method that will be responsible for deleting a book from the database

        Scanner scanner = new Scanner(System.in);                                 //Create a Scanner object to read input from the user
        System.out.print("Enter book ID to delete: ");                            // Prompt the user to enter the book ID that they want to delete
        int bookId = scanner.nextInt();                                           //Reads the user's input for the book ID


        String query = "DELETE FROM books WHERE book_id = ?";                    //Define an SQL query string to delete a book from the books table where the book_id matches the provided value by the user


        try (Connection connection = JDBC.getConnection();                       // Make a connection to the database using a method getConnection() from the JDBC class
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, bookId);                    //Set the first placeholder (?) in the SQL query to the book ID


            int rowsAffected = preparedStatement.executeUpdate();               //Execute the SQL query and returns the number of rows affected by the operation
            if (rowsAffected > 0) {                                             //Check if any rows were affected by the query
                System.out.println("Book deleted successfully!");               //Print a message if the book was deleted
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


}


