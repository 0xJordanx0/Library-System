import java.util.ArrayList;
import java.util.Scanner;

public class LibrarySystem {
    private final String librarySystemName;
    private final ArrayList<Student> students;
    private final ArrayList<Employee> employees;
    private final ArrayList<Book> books;


    LibrarySystem(String librarySystemName){
        this.librarySystemName = librarySystemName;
        students = new ArrayList<Student>();
        employees = new ArrayList<Employee>();
        books = new ArrayList<Book>();
    }

    public String getLibrarySystemName(){
        return librarySystemName;
    }

    public ArrayList<Student> getStudents(){
        return students;
    }

    public String getEmployees(){
        return employees.toString();
    }

    public void addStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a first name");
        String firstName = scanner.nextLine();
        System.out.println("Please enter a last name");
        String lastName = scanner.nextLine();
        System.out.println("Please enter your ID");
        int studentId = scanner.nextInt();
        Student student = new Student(firstName,lastName,studentId);
        students.add(student);
        System.out.println(student.getFullName() + " Added Successfully");
    }

    public void removeStudent(Student student){
        students.remove(student);
        System.out.println(student.getFullName() + " Removed Successfully");
    }

    public void addEmployee(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a first name");
        String firstName = scanner.nextLine();
        System.out.println("Please enter a last name");
        String lastName = scanner.nextLine();
        System.out.println("Please enter your ID");
        int employeeId = scanner.nextInt();
        Employee employee = new Employee(firstName,lastName,employeeId);
        employees.add(employee);
        System.out.println(employee.getFullName() + " Added Successfully");

    }

    public void removeEmployee(Employee employee){
        employees.remove(employee);
        System.out.println(employee.getFullName() + " Removed Successfully");
    }



    public String getBooks(){
        return books.toString();
    }

    public void createBook(){

    }

    public void removeBook(){

    }
    public void borrowBook(){

    }

}
