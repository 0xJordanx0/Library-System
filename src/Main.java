import java.util.Scanner;

public class Main {

    private static LibrarySystem library = new LibrarySystem("Bahrain Library System");
    private static boolean running = true;
    private static boolean isLoggedIn = false;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (running) {
            System.out.println("Welcome to " + library.getLibrarySystemName());
            printChoices(isLoggedIn);

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (isLoggedIn) {
                handleLoggedInUserChoice(choice);
            } else {
                handleLoggedOutUserChoice(choice);
            }
        }
    }

    private static void handleLoggedInUserChoice(int choice) {
        switch (choice) {
            case 1:
                library.getBooks();
                break;
            case 2:
                // Implement functionality for logged-in user choice 2
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

        if (loginRole.equalsIgnoreCase("student")) {
            System.out.println("Please enter your ID");
            int loginRoleId = scanner.nextInt();
            boolean studentExists = false;

            for (Student student : library.getStudents()) {
                if (student.getStudentId() == loginRoleId) {
                    System.out.println("Welcome! " + student.getFullName());
                    studentExists = true;
                    isLoggedIn = true;
                }
            }

            if (!studentExists) {
                System.out.println(loginRoleId + " does not exist");
            }
        } else {
            System.out.println("You have chosen a wrong role");
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
    }

    private static void printChoices(boolean isLoggedIn) {
        System.out.println("Please choose a choice:");
        System.out.println("================================");
        if (!isLoggedIn) {
            System.out.println("1. Login");
            System.out.println("2. Register");
        } else {
            System.out.println("1. List All Books");
            System.out.println("2. Borrow a Book");
        }
        System.out.println("4. Exit Library System");
        System.out.println("================================");
    }
}
