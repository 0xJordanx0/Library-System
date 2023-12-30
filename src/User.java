public class User {
    private final String firstName;
    private final String lastName;

    User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullName(){
        return String.format("%s %s", firstName,lastName);
    }
}
