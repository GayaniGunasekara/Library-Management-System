import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Date;
import java.time.LocalDate;
public class LoanBook {

    public void loanBook() {
        //This is the method that will be responsible for loaning a book to a member



        Scanner scanner = new Scanner(System.in);                     //Create a Scanner object to read input from the user

        System.out.print("Enter book ID: ");                          //Prompt the user to enter the book ID
        int bookId = scanner.nextInt();                               //Read the user's input for the book ID.

        System.out.print("Enter member ID: ");                        //Prompt the user to enter the member ID.
        int memberId = scanner.nextInt();                             //Read the user's input for the member ID.

        LocalDate loanDate = LocalDate.now();                         //Set the loan date to the current date
        LocalDate dueDate = loanDate.plusWeeks(3);        //Set the due date to three weeks from the loan date



        String query = "INSERT INTO loans (book_id, member_id, loan_date, due_date) VALUES (?, ?, ?, ?)";    //Define an SQL query string to insert a new loan record into the loans table with placeholders for the values to be inserted



        try (Connection connection = JDBC.getConnection();                     // Make a connection to the database using a method getConnection() from the JDBC class
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, bookId);                              //Set the first placeholder (?) in the SQL query to the book ID
            preparedStatement.setInt(2, memberId);                            //Set the second placeholder (?) in the SQL query to the member ID
            preparedStatement.setDate(3, Date.valueOf(loanDate));             // Set the third placeholder (?) in the SQL query to the loan date
            preparedStatement.setDate(4, Date.valueOf(dueDate));              //Set the fourth placeholder (?) in the SQL query to the due date



            int rowsAffected = preparedStatement.executeUpdate();               //Execute the SQL query and returns the number of rows affected by the operation
            if (rowsAffected > 0) {                                             //Check if any rows were affected by the query
                System.out.println("Book loaned successfully!");                // Print a message if the book was loaned
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
