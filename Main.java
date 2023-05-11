import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        StatisticGradeBook student = new StatisticGradeBook("Assignment7-Spreadsheet.csv");
        Thread t = new Thread(student);
        t.start();

        Scanner scan = new Scanner(System.in);
        System.out.println("What student would you like to see grades for ");
        String name = scan.nextLine();

        student.getStudentGrade(name);
    }
}