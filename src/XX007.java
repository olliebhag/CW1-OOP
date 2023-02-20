import java.util.Arrays;

import java.util.Scanner;

class Student {
//    declaring variables
    private int id;
    private String firstName;
    private String surname;
    private double interimTest;
    private double coursework;
    private int[] homeworkMarks = new int[5];
    private double exam;
    private double finalMark;


// setter methods for previously declared variables
    public void setId(int id) {
        this.id = id;
    }
    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getSurname () {
        return this.surname;
    }
    public void setHomeworkMarks(int[] homeworkMarks) {
        this.homeworkMarks = homeworkMarks;
    }
    public void setInterimTest(double interimTest) {
        this.interimTest = interimTest;
    }
    public void setCoursework(double coursework) {

        this.coursework = coursework;
    }
    public void setExam(double exam) {
        this.exam = exam;
    }
    public void setFinalMark(double finalMark) {
        this.finalMark = finalMark;
    }


    // getter methods for previously declared variables
    public int getId() {
        return this.id;
    }
    public String getFirstName () {
        return this.firstName;
    }
    public int[] getHomeworkMarks () {
        return this.homeworkMarks;
    }
    public double getInterimTest () {
        return this.interimTest;
    }
    public double getCoursework () {
        return this.coursework;
    }
    public double getExam () {
        return this.exam;
    }
    public double getFinalMark () {
        return this.finalMark;
    }
}

public class XX007 {
    private static String format(double mark) { // method to add percentage signs to numbers
        return String.format("%.2f", mark) + "%"; // %.2f rounds to 2 decimal places https://www.javatpoint.com/how-to-round-double-and-float-up-to-two-decimal-places-in-java
    } // adds a percentage sign after the processed input

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // initalises scanner

        System.out.print("Enter the number of students taking the module: ");
        int numStudents = input.nextInt(); // takes in the number of students


        Student[] students = new Student[numStudents]; // creates an array of students based on the number of them
        for (int count = 0; count < numStudents; count++) { //loops through the creation of a student object
            input.nextLine(); //fixes the bug of nextInt not recognising a newline character and therefore skipping the first name input

            System.out.print("Enter first name: ");
            String firstName = input.nextLine(); //takes in string input

            System.out.print("Enter surname: ");
            String surname = input.nextLine();


            int[] homeworkMarks = new int[5]; //creates an integer array of size 5
            for (int j = 0; j < 5; j++) { //loops through the array
                System.out.print("Enter homework marks: ");
                int homeworkInput = input.nextInt();

                if (homeworkInput < 0) {
                    break;
                }
                homeworkMarks[j] = homeworkInput; //places the homework input in the current index of the array
            }
            Arrays.sort(homeworkMarks);


            System.out.print("Enter the mark for the Interim Test: ");
            int interimTest = input.nextInt();
            System.out.print("Enter the mark for the exam: ");
            int exam = input.nextInt();

            int bestHomework = homeworkMarks[2] + homeworkMarks[3] + homeworkMarks[4];
            double coursework = ((bestHomework / 3) * (1.0 / 3.0)) + (interimTest * (2.0 / 3.0));
            double finalMark = (coursework * 0.3) + (exam * 0.7);

            students[count] = new Student();

            students[count].setId(count + 1);
            students[count].setFirstName(firstName);
            students[count].setSurname(surname);
            students[count].setHomeworkMarks(homeworkMarks);
            students[count].setInterimTest(interimTest);
            students[count].setCoursework(coursework);
            students[count].setExam(exam);
            students[count].setFinalMark(finalMark);

            System.out.println(students[count].getId() + " " + students[count].getFirstName() + " " + students[count].getSurname() + " " + students[count].getFinalMark());
        }

//        from https://www.theserverside.com/blog/Coffee-Talk-Java-News-Stories-and-Opinions/Java-print-table-format-printf-chart-console-scanner-println-line
        System.out.println("Number of students: " + numStudents);
        System.out.printf("| %2s | %8s | %10s | %6s | %6s | %6s", "ID", "Name", "Surname", "Coursework", "Exam", "FinalMark");

        for (int count = 0; count < numStudents; count++) {
            System.out.println();
            System.out.printf("| %2s | %8s | %10s | %10s | %6s | %6s",
                    students[count].getId(),
                    students[count].getFirstName() ,
                    students[count].getSurname(),
                    format(students[count].getCoursework()),
                    format(students[count].getExam()),
                    format(students[count].getFinalMark())
            );

        }

    }
}


// comment through the code
// fix weighted coursework
// max 100