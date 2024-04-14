import java.util.Scanner;
public class GradeCalculator{
    private int[] marks; // to store marks obtained in each subject
    private int totalMarks;
    private double averagePercentage;
    private char grade;

    // Here I use method to take input marks for each subject
    public void inputMarks(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter marks obtained of 6 subjects (out of 100):");
        marks = new int[6]; // Assuming 6 subjects
        for (int i = 0; i < marks.length; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
            totalMarks += marks[i];
        }
    }

    // Here I use method to calculate total marks
    public void calculateTotalMarks(){
        // Sum up the marks obtained in all subjects
        totalMarks = 0;
        for (int mark : marks){
            totalMarks += mark;
        }
    }

    // Here I use method to calculate average percentage
    public void calculateAveragePercentage(){
        // Calculate average percentage
        averagePercentage = totalMarks / (double) marks.length;
    }

    // Here I use method to assign grades based on the average percentage
    public void calculateGrade(){
        // Assign grades based on the average percentage achieved
        if (averagePercentage >= 90){
            grade = 'A';
        } else if (averagePercentage >= 80){
            grade = 'B';
        } else if (averagePercentage >= 70){
            grade = 'C';
        } else if (averagePercentage >= 60){
            grade = 'D';
        } else{
            grade = 'F';
        }
    }

    // Here It is used to display results
    public void displayResults(){
        System.out.println("\nTotal Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
    }

    public static void main(String[] args){
        GradeCalculator calculator = new GradeCalculator();
        calculator.inputMarks();
        calculator.calculateTotalMarks();
        calculator.calculateAveragePercentage();
        calculator.calculateGrade();
        calculator.displayResults();
    }
}