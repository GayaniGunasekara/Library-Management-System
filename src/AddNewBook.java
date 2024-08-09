import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddNewBook {

    public void addBook() {
        //This is the method that will be responsible for adding a new book to the database


        Scanner scanner = new Scanner(System.in);            //Create a Scanner object to read input from the user

        System.out.print("Enter book title: ");              //Prompt the user to enter the book title
        String title = scanner.nextLine();                   //Read the user's input for the book title

        System.out.print("Enter book author: ");             //Prompt the user to enter the book author
        String author = scanner.nextLine();                  //Read the user's input for the book author

        System.out.print("Enter book publisher: ");          //Prompt the user to enter the book publisher
        String publisher = scanner.nextLine();               //Read the user's input for the book's publisher

        System.out.print("Enter year published: ");          //Prompt the user to enter the year the book was published
        int yearPublished = scanner.nextInt();               //Read the user's input for the year published



        String query = "INSERT INTO books (title, author, publisher, year_published) VALUES (?, ?, ?, ?)";            //Defines an SQL query string to insert a new book into the books table in library_db



        try (Connection connection = JDBC.getConnection();                                                    // Make a connection to the database using a method getConnection() from the JDBC class
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {


            preparedStatement.setString(1, title);               //Set the first placeholder (?) in the SQL query to the book title
            preparedStatement.setString(2, author);              //Set the second placeholder (?) in the SQL query to the book author
            preparedStatement.setString(3, publisher);           //Set the third placeholder (?) in the SQL query to the book publisher
            preparedStatement.setInt(4, yearPublished);          //Set the fourth placeholder (?) in the SQL query to the year of published


            int rowsAffected = preparedStatement.executeUpdate();             //Execute the SQL query and returns the number of rows affected by the operation
            if (rowsAffected > 0) {                                           //Check if any rows were affected by the query
                System.out.println("Book added successfully!");                //Print a message if the book was added
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }}



