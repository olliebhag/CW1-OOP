import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;

public class XX007 {
    class student {
        private String ID;
        private String firstName;
        private void setFirstName(String firstName) {
            this.firstName = firstName; }

        private String surname;
        private void setSurname(String surname) {
            this.surname = surname; }

        private int interimTest;
        private void setInterimTest(int interimTest) {
            this.interimTest = interimTest; }


        private int[] homeworkMarks = new int[5];
        private void setInterimTest(int[] homeworkMarks) {
            this.homeworkMarks = homeworkMarks; }
        private double coursework;
        private void coursework(double coursework) {
            this.coursework = coursework; }

        private int exam;
        private void exam(int exam) {
            this.exam = exam; }

        private double weightedCoursework;
        private void weightedCoursework(double weightedCoursework) {
            this.weightedCoursework = weightedCoursework; }

        private double finalMark;
        private void finalMark(double finalMark) {
            this.finalMark = finalMark; }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter first name: ");
        String firstName = input.nextLine();
        System.out.print("Enter surname: ");
        String surname = input.nextLine();



        System.out.print("Enter the number of students taking the module: ");
        int numStudents = input.nextInt();
        int[] studentArray = new int[numStudents];

        int[] homeworkMarks = new int[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter homework marks: ");
            int homeworkInput = input.nextInt();

            if (homeworkInput < 0) {
                break;
            }
            homeworkMarks[i] = homeworkInput;
        }
        Arrays.sort(homeworkMarks);
        Collections.reverse(Arrays.asList(homeworkMarks));
//        from https://www.geeksforgeeks.org/reverse-an-array-in-java/


        System.out.print("Enter the mark for the Interim Test: ");
        int interimTest = input.nextInt();
        System.out.print("Enter the mark for the exam: ");
        int exam = input.nextInt();

        int bestHomework = homeworkMarks[0] + homeworkMarks[1] + homeworkMarks[2];
        double weightedCoursework = (bestHomework / 3) * (1/3) + (interimTest * (2/3));
        double finalMark = weightedCoursework + (exam * 0.7);

        student one = new student();
        one.firstName = firstName;
        one.surname = surname;
        one.homeworkMarks = homeworkMarks;
        one.interimTest = interimTest;
        one.weightedCoursework = weightedCoursework;
        one.exam = exam;
        one.finalMark = finalMark;


        System.out.println(one.firstName + " " + one.surname + " " + one.exam);



    }
}