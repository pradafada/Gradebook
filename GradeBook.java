import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class GradeBook {
    LinkedList<Student> students = new LinkedList<Student>();

    public GradeBook (String fileName) {
        try {
            //open file?
            File file = new File(fileName);
            Scanner scan = new Scanner(file);
            String line = "";

            scan.nextLine();
            while (scan.hasNextLine()) {
                line = scan.nextLine();
                Student student = new Student(line);
                students.add(student);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Student getStudent (String name) {
        for(Student s: students) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }

    public void getStudentGrade (String name) {
        for(Student s: students) {
            if(s.getName().equalsIgnoreCase(name)) {
                s.getGrade();
            }
        }
    }

    public LinkedList<String> getAllStudentNames () {
        LinkedList<String> all = new LinkedList<String>();

        for(Student s: students) {
            all.add(s.getName());
        }
        return all;
    }
}
