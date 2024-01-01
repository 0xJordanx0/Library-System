import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    private static final LibrarySystem library = new LibrarySystem("Bahrain Library System");
    private static boolean running = true;
    private static boolean isLoggedIn = false;
    private static String loggedInUserRole;
    private static Integer loggedInUserId;

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (running) {
            System.out.println("Welcome to " + library.getLibrarySystemName());
            printChoices(isLoggedIn,String.valueOf(loggedInUserRole));

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (isLoggedIn && loggedInUserRole.equals("student")) {
                handleLoggedInStudentChoice(choice);
            } else if (isLoggedIn && loggedInUserRole.equals("employee")){
                handleLoggedInEmployeeChoice(choice);
            }else{
                handleLoggedOutUserChoice(choice);
            }
        }
    }

    private static void handleLoggedInStudentChoice(int choice) {
        switch (choice) {
            case 1:
                library.getBooks();
                break;
            case 2:
                createBook();
                break;
            default:
                running = false;
                break;
        }
    }

    private static void handleLoggedInEmployeeChoice(int choice) {
        switch (choice) {
            case 1:
                library.getBooks();
                break;
            case 2:
                borrowBook(loggedInUserId);
                break;
            default:
                running = false;
                break;
        }
    }

    private static void handleLoggedOutUserChoice(int choice) {
        switch (choice) {
            case 1:
                login();
                break;
            case 2:
                register();
                break;
            default:
                running = false;
                break;
        }
    }

    private static void login() {
        System.out.println("Are you an Employee or Student?");
        String loginRole = scanner.nextLine();

        if(loginRole.equals("student")){
            System.out.println("Please enter your ID");
            int loginRoleId = scanner.nextInt();
            boolean studentExists = false;

            for (Student student : library.getStudents()) {
                if (student.getStudentId() == loginRoleId) {
                    System.out.println("Welcome! " + student.getFullName());
                    studentExists = true;
                    isLoggedIn = true;
                    loggedInUserId = student.getStudentId();
                    loggedInUserRole = "student";
                }
            }

            if (!studentExists) {
                System.out.println(loginRoleId + " does not exist");
            }

            scanner.close();
        }else if(loginRole.equals("employee")){
            System.out.println("Please enter your ID");
            int loginRoleId = scanner.nextInt();
            boolean employeeExists = false;

            for (Employee employee : library.getEmployees()) {
                if (employee.getEmployeeId() == loginRoleId) {
                    System.out.println("Welcome! " + employee.getFullName());
                    employeeExists = true;
                    isLoggedIn = true;
                    loggedInUserId = employee.getEmployeeId();
                    loggedInUserRole = "employee";

                }
            }

            if (!employeeExists) {
                System.out.println(loginRoleId + " does not exist");
            }
            scanner.close();
        }

    }

    private static void register() {
        System.out.println("Are you an Employee or Student?");
        String registerRole = scanner.nextLine();

        if (registerRole.equalsIgnoreCase("student")) {
            library.addStudent();
        } else if (registerRole.equalsIgnoreCase("employee")) {
            library.addEmployee();
        } else {
            System.out.println("You have chosen a wrong role");
        }

        scanner.close();
    }

    private static void printChoices(boolean isLoggedIn, String loggedInUserRole) {
        System.out.println("Please choose a choice:");
        System.out.println("================================");
        if (!isLoggedIn) {
            System.out.println("1. Login");
            System.out.println("2. Register");
        } else {
            if(loggedInUserRole.equals("student")) {
                System.out.println("1. List All Books");
                System.out.println("2. Borrow a Book");
            }else{
                System.out.println("1. List All Books");
                System.out.println("2. Add a Book");
                System.out.println("3. Remove a Book");
            }
        }
        System.out.println("4. Exit Library System");
        System.out.println("================================");
    }

    private static void borrowBook(Integer userId){
        System.out.println("Please enter the name of the book you would like to borrow:");
        Scanner scanner = new Scanner(System.in);
        String bookName = scanner.nextLine();
        library.borrowBook(bookName, userId);
    }

    private static void createBook(){
        System.out.println("Please enter the name of the book");
        Scanner scanner = new Scanner(System.in);
        String bookName = scanner.nextLine();
        System.out.println("Please enter the name of the book author");
        String bookAuthor = scanner.nextLine();
        System.out.println("Please enter the name of the book publication date in format (YYYY-MM-DD");
        LocalDate bookPublicationDate = LocalDate.parse(scanner.nextLine());

        library.createBook(bookName,bookAuthor,bookPublicationDate);
    }
}
