import java.sql.ResultSet;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class SearchBook {


    public void searchBook() {
        //This is the method that will be responsible for searching books in the database

        Scanner scanner = new Scanner(System.in);                                         //Create a Scanner object to read input from the user

        System.out.print("Enter search term (title, author, or year): ");                 //Prompt the user to enter a search term
        String searchTerm = scanner.nextLine();                                           //Read the user's input for the search term



        String query = "SELECT * FROM books WHERE title LIKE ? OR author LIKE ? OR year_published LIKE ?";          //Define SQL query string to search for books based on the title, author, or year published



        try (Connection connection = JDBC .getConnection();                                    // Make a connection to the database using a method getConnection() from the JDBC class
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, "%" + searchTerm + "%");              //Set the first placeholder (?) in the SQL query to the search term
            preparedStatement.setString(2, "%" + searchTerm + "%");              //Set the second placeholder (?) in the SQL query to the search term
            preparedStatement.setString(3, "%" + searchTerm + "%");              //Set the third placeholder (?) in the SQL query to the search term

            ResultSet resultSet = preparedStatement.executeQuery();                              // Execute the SQL query and return the results in a ResultSet object

            while (resultSet.next()) {
                int bookId = resultSet.getInt("book_id");                            //Retrieve the book_id column value from the current row
                String title = resultSet.getString("title");                         //Retrieve the title column value from the current row
                String author = resultSet.getString("author");                       //Retrieve the author column value from the current row
                String publisher = resultSet.getString("publisher");                 // Retrieve the publisher column value from the current row
                int yearPublished = resultSet.getInt("year_published");              //Retrieve the year_published column value from the current row



                System.out.printf("ID: %d, Title: %s, Author: %s, Publisher: %s, Year Published: %d%n",
                        bookId, title, author, publisher, yearPublished);                           // Print the book details
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    }

