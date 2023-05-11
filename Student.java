import java.util.Arrays;

public class Student {
    public int[] quiz = new int[10];
    public int[] hw = new int[10];
    public int midterm;
    public int exam;
    public double quizAvg;
    public double hwAvg;
    public double overallAvg;
    public String name;
    public int ID;

    public Student (String line) {
        String[] array = line.split(",");
        name = array[0];
        ID = Integer.parseInt(array[1]);
        int counter = 0;
        for (int i = 2; i < 12; i++) {
            quiz[counter] = Integer.parseInt(array[i]);
            counter++;
        }
        counter = 0;
        for (int i = 12; i < 22; i++) {
            hw[counter] = Integer.parseInt(array[i]);
            counter++;
        }
        midterm = Integer.parseInt(array[22]);
        exam = Integer.parseInt(array[23]);
    }

    public String getName () {
        return name;
    }
    public int getID () {
        return ID;
    }

    public void calcQuizAverage () {
        //found smallest value
        int minQ = quiz[0];
        for (int i = 0; i < quiz.length; i++) {
            if (quiz[i] < minQ) {
                minQ = quiz[i];
            }
        }
        //delete smallest
        int[] quizNew = new int[quiz.length-1];
        for (int i = 0, k = 0; i < quiz.length; i++) {
            if (quiz[i] != minQ) {
                quizNew[k] = quiz[i];
                k++;
            }
        }
        //average remaining values
        double sum = 0;
        int length = quizNew.length;
        for (int i = 0; i < length; i++) {
            sum += quizNew[i];
        }
        quizAvg = sum/length;
    }

    public void calcHWAverage () {
        //found smallest value
        int minHW = hw[0];
        for (int i = 0; i < hw.length; i++) {
            if (hw[i] < minHW) {
                minHW = hw[i];
            }
        }
        //delete smallest
        int[] hwNew = new int[hw.length-1];
        for (int i = 0, k = 0; i < hw.length; i++) {
            if (hw[i] != minHW) {
                hwNew[k] = hw[i];
                k++;
            }
        }
        //average remaining values
        double sum = 0;
        int length = hwNew.length;
        for (int i = 0; i < length; i++) {
            sum += hwNew[i];
        }
        hwAvg = sum/length;
    }

    public void calcOverallAvg () {
        overallAvg = ((quizAvg * 0.4)+(hwAvg * 0.1)+(midterm * 0.2)+(exam * 0.3));
    }

    public void getGrade () {
        //print quizzes
        for (int i = 0; i < quiz.length; i++) {
            System.out.println ("Quiz " +i+ ": " +quiz[i]);
        }
        System.out.println("Quiz Avg: " +quizAvg);

        //print hw
        for (int i = 0; i < hw.length; i++) {
            System.out.println("Hw " +i+ ": " +hw[i]);
        }
        System.out.println("HW Avg: " +hwAvg);

        //exams and overall
        System.out.println("Midterm: " +midterm+ "\nFinal Exam: " +exam+ "\nOverall Average: " +overallAvg);
    }

}
