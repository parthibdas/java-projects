import java.util.*;
import java.io.*;

public class StudentService {
    private List<Student> students = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void addStudent() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter age: ");
        int age = sc.nextInt(); sc.nextLine();
        System.out.print("Enter roll: ");
        String roll = sc.nextLine();

        students.add(new Student(name, age, roll));
        System.out.println("Student added!");
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        students.forEach(System.out::println);
    }

    public void removeStudent() {
        System.out.print("Enter roll to remove: ");
        String roll = sc.nextLine();

        students.removeIf(s -> s.toString().startsWith(roll));
        System.out.println("If existed, removed.");
    }

    public void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.txt"))) {
            oos.writeObject(students);
            System.out.println("Saved successfully!");
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students.txt"))) {
            students = (List<Student>) ois.readObject();
            System.out.println("Loaded successfully!");
        } catch (Exception e) { e.printStackTrace(); }
    }
}
