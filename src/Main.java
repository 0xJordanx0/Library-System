import java.util.Scanner;

class Main {
    public static void main(String[] args){
        LibrarySystem library = new LibrarySystem("Bahrain Library System");
        boolean running = true;
        boolean isLoggedIn = false;
        while(running){
            System.out.println("Welcome to " + library.getLibrarySystemName());

            printChoices(isLoggedIn);

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1:
                    System.out.println("Are you an Employee or Student?");
                    String loginRole = scanner.nextLine();

                    if(loginRole.equalsIgnoreCase("student")){
                        System.out.println("Please enter your ID");
                        int loginRoleId = scanner.nextInt();
                        for(Student student : library.getStudents()){
                            if(student.getStudentId() == loginRoleId){
                                System.out.println("Welcome!" + student.getFullName());
                                break;
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println("Are you an Employee or Student?");
                    String registerRole = scanner.nextLine();

                    if(registerRole.equalsIgnoreCase("student")){
                        library.addStudent();
                    }else if(registerRole.equalsIgnoreCase("employee")){
                        library.addEmployee();
                    }else{
                        System.out.println("You have chosen a wrong role");
                    }
                    break;
                default:
                    running = false;
                    break;
            }
        }
    }

    private static void printChoices(Boolean isLoggedIn){
        if(!isLoggedIn){
            System.out.println("Please choose a choice:");
            System.out.println("================================");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("4. Exit Library System");
            System.out.println("================================");
        }else{
            System.out.println("Please choose a choice:");
            System.out.println("================================");
            System.out.println("1. List All Books");
            System.out.println("2. Borrow a Book");
            System.out.println("4. Return a Book");
            System.out.println("================================");
        }
    }
}