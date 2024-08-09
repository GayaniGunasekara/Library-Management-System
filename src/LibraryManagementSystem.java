import java.util.Scanner;  // import Scanner class, which is used to take input from the user


public class LibraryManagementSystem {

    public static void main (String[] args) {


        AddNewBook addNewBook = new AddNewBook();       // Creates an instance of the AddNewBook class
        UpdateBook updateBook = new UpdateBook();       //Creates an instance of the UpdateBook class
        DeleteBook deleteBook = new DeleteBook();       // Creates an instance of the DeleteBook class
        SearchBook searchBook = new SearchBook();       //Creates an instance of the SearchBook class
        AddMember addMember = new AddMember();          //Creates an instance of the AddMember class
        LoanBook loanBook = new LoanBook();             //Creates an instance of the LoanBook class
        ReturnBook returnBook = new ReturnBook();       // Creates an instance of the ReturnBook class



        while (true) {

            // Print options in the library management system to choose by the user
            System.out.println("***************  Library Management System  ***************");
            System.out.println("1. Add a New Book");
            System.out.println("2. Update Book Details");
            System.out.println("3. Delete a Book");
            System.out.println("4. Search for a Book");
            System.out.println("5. Add a New Member");
            System.out.println("6. Loan a Book");
            System.out.println("7. Return a Book");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");


            Scanner scanner = new Scanner(System.in);    // Create a Scanner object to read input from the user
            int choice = scanner.nextInt();              //Read the user's choice as an integer



            switch (choice) {
                case 1:
                    addNewBook.addBook();               //Calling the addBook method of AddNewBook if the user chooses option 1
                    break;
                case 2:
                    updateBook.updateBook();            //Calling the updateBook method of UpdateBook if the user chooses option 2
                    break;
                case 3:
                    deleteBook.deleteBook();            //Calling the deleteBook method of DeleteBook if the user chooses option 3
                    break;
                case 4:
                    searchBook.searchBook();            //Calling the searchBook method of SearchBook if the user chooses option 4
                    break;
                case 5:
                    addMember.addMember();             //Calling the addMember method of AddMember if the user chooses option 5
                    break;
                case 6:
                    loanBook.loanBook();               //Calling the loanBook method of LoanBook if the user chooses option 6
                    break;
                case 7:
                    returnBook.returnBook();          //Calling the returnBook method of ReturnBook if the user chooses option 7
                    break;
                case 8:
                    System.out.println("Exiting...");        //break out of the switch
                default:
                    System.out.println("Invalid choice. Try again.");          //printing an error message if the user chooses invalid option
            }
        }
    }
}
