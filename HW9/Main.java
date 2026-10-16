package HW9;

public class Main {
    public static void main(String[] args) {
        EngClass engClass = new EngClass();
        Student student1 = new Student(1, "John", "Doe");
        Student student2 = new Student(2, "Jane", "Smith");

        engClass.addStudent(student1);
        engClass.addStudent(student2);
        engClass.displayStudents();

        engClass.deleteStudent(1);
        engClass.displayStudents();
    }
}
