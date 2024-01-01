import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class LibrarySystem {
    private final String librarySystemName;
    private final ArrayList<Student> students;
    private final ArrayList<Employee> employees;
    private final HashMap<Integer, Book> books;


    LibrarySystem(String librarySystemName){
        this.librarySystemName = librarySystemName;
        students = new ArrayList<Student>();
        employees = new ArrayList<Employee>();
        books = new HashMap<Integer, Book>();
    }

    public String getLibrarySystemName(){
        return librarySystemName;
    }

    public ArrayList<Student> getStudents(){
        return students;
    }

    public ArrayList<Employee> getEmployees(){
        return employees;
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

    public void createBook(String bookName, String author, LocalDate publicationDate){
        Book newBook = new Book(bookName,author,publicationDate, false);
        books.put(0, newBook);
        System.out.println(newBook.getBookName() + " Book Created Successfully");
    }

    public void removeBook(String bookName){
        books.entrySet().removeIf(entry -> entry.getValue().getBookName().equalsIgnoreCase(bookName));
    }

    public void borrowBook(String bookName, Integer userId){
        books.forEach((key, book) -> {
            if (book.getBookName().equalsIgnoreCase(bookName)) {
                book.setIsBorrowed();
                books.remove(key);
                books.put(userId, book);
            }
        });
    }

}
