package HW9;
import java.util.ArrayList;
public class EngClass {
    private ArrayList<Student> students;

    public EngClass() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        for (Student s : students) {
            if (s.getStudentId() == student.getStudentId()) {
                System.out.println("Student ID already exists: " + student.getStudentId());
                return;
            }
        }
        students.add(student);
        System.out.println("Added: " + student);
    }

    public void deleteStudent(int studentId) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId() == studentId) {
                System.out.println("Deleted: " + students.remove(i));
                return;
            }
        }
        System.out.println("Student not found: " + studentId);
    }

    public void displayStudents() {
        System.out.println("Engineering class student list:");
        if (students.isEmpty()) {
            System.out.println("No students enrolled.");
            return;

        }
        for (Student s : students) {
            System.out.println(s);
        }
    }

}
