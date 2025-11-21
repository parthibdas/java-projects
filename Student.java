import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private int age;
    private String roll;

    public Student(String name, int age, String roll) {
        this.name = name;
        this.age = age;
        this.roll = roll;
    }

    @Override
    public String toString() {
        return roll + " - " + name + " (" + age + ")";
    }
}
