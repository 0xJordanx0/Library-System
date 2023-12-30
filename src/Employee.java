public class Employee extends User{

    private final int employeeId;


    Employee(String firstName, String lastName, int employeeId) {
        super(firstName, lastName);
        this.employeeId = employeeId;
    }
}
