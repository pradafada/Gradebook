import java.util.LinkedList;

public class StatisticGradeBook extends GradeBook implements Runnable {
    public StatisticGradeBook (String file) {
        super(file);
    }

    @Override
    public void run() {
        LinkedList<String> names = getAllStudentNames();
        int size = names.size();
        int counter = 0;

        for(Student s: students) {
            s.calcQuizAverage();
            s.calcHWAverage();
            s.calcOverallAvg();

            if (counter%100 == 0) {
                System.out.println("Calculating grades " +counter+ " out of " +size);
            }
            counter++;
        }
        System.out.println("All grades calculated");
    }
}
