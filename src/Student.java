import java.time.LocalDate;
import java.util.ArrayList;

public class Student extends User{
    private final int studentId;

    Student(String firstName, String lastName, int studentId) {
       super(firstName,lastName);
       this.studentId = studentId;
    }

    public int getStudentId(){
        return studentId;
    }
}
