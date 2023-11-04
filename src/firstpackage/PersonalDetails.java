package firstpackage;

public class PersonalDetails {
    public String id;
    private double age;
    private String firstName;
    private String lastName;

       public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "\nPersonalDetails{" +
                "id='" + id + '\'' +
                ", age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public void setAge(double age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
public PersonalDetails(){}
    public PersonalDetails(String id, double age, String firstName, String lastName) {
        this.id = id;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
