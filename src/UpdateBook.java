import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateBook {

    public void updateBook() {
        //This is the method that will be responsible for updating book details in the database


        Scanner scanner = new Scanner(System.in);                                         //Create a Scanner object to read input from the user

        System.out.print("Enter book ID to update: ");                                    //Prompt the user to enter the ID of the book to update
        int bookId = scanner.nextInt();                                                   //Read the user's input for the book ID
        scanner.nextLine();

        System.out.print("Enter new book title: ");                                        //Prompt the user to enter the new title of the book.
        String title = scanner.nextLine();                                                 //Read the user's input for the book title

        System.out.print("Enter new book author: ");                                      //Prompt the user to enter the new author of the book
        String author = scanner.nextLine();                                               //Read the user's input for the book author

        System.out.print("Enter new book publisher: ");                                    //Prompt the user to enter the new publisher of the book
        String publisher = scanner.nextLine();                                              //Read the user's input for the book publisher

        System.out.print("Enter new year published: ");                                   //Prompt the user to enter the new year the book was published
        int yearPublished = scanner.nextInt();                                             //Read the user's input for the year published



        String query = "UPDATE books SET title = ?, author = ?, publisher = ?, year_published = ? WHERE book_id = ?";   //Define an SQL query string to update a book's details in the books table based on the book_id

        try (Connection connection = JDBC.getConnection();                         // Make a connection to the database using a method getConnection() from the JDBC class
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, title);                     //Set the first placeholder (?) in the SQL query to the new title
            preparedStatement.setString(2, author);                    //Set the second placeholder (?) in the SQL query to the new author
            preparedStatement.setString(3, publisher);                 //Set the third placeholder (?) in the SQL query to the new publisher.
            preparedStatement.setInt(4, yearPublished);                 // Set the fourth placeholder (?) in the SQL query to the new year published
            preparedStatement.setInt(5, bookId);                       //Set the fifth placeholder (?) in the SQL query to the book ID


            int rowsAffected = preparedStatement.executeUpdate();               //Execute the SQL query and returns the number of rows affected by the operation
            if (rowsAffected > 0) {                                             //Check if any rows were affected by the query
                System.out.println("Book updated successfully!");               //Print a message if the book was updated
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
