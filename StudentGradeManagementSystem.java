import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentGradeManagementSystem {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<Integer, Student> studentDatabase = new HashMap<>();

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Add Student\n2. Update Student\n3. Delete Student\n4. View Student\n5. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    updateStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    viewStudent();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.println("Enter Roll Number:");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.println("Enter Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Marks (out of 100):");
        double marks = scanner.nextDouble();
        Student student = new Student(name, rollNumber, marks);
        studentDatabase.put(rollNumber, student);
        System.out.println("Student added successfully.");
    }

    private static void updateStudent() {
        System.out.println("Enter Roll Number of Student to Update:");
        int rollNumber = scanner.nextInt();
        if (!studentDatabase.containsKey(rollNumber)) {
            System.out.println("Student not found.");
            return;
        }
        scanner.nextLine(); // consume newline
        System.out.println("Enter New Name:");
        String newName = scanner.nextLine();
        System.out.println("Enter New Marks (out of 100):");
        double newMarks = scanner.nextDouble();
        Student student = studentDatabase.get(rollNumber);
        student.setName(newName);
        student.setMarks(newMarks);
        System.out.println("Student updated successfully.");
    }

    private static void deleteStudent() {
        System.out.println("Enter Roll Number of Student to Delete:");
        int rollNumber = scanner.nextInt();
        if (studentDatabase.remove(rollNumber) != null) {
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void viewStudent() {
        System.out.println("Enter Roll Number of Student to View:");
        int rollNumber = scanner.nextInt();
        Student student = studentDatabase.get(rollNumber);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student not found.");
        }
    }

    static class Student {
        private String name;
        private int rollNumber;
        private double marks;

        public Student(String name, int rollNumber, double marks) {
            this.name = name;
            this.rollNumber = rollNumber;
            this.marks = marks;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setMarks(double marks) {
            this.marks = marks;
        }

        public String getGrade() {
            if (marks >= 90) return "A";
            else if (marks >= 80) return "B";
            else if (marks >= 70) return "C";
            else if (marks >= 60) return "D";
            else return "F";
        }

        public double getPercentage() {
            return marks;
        }

        @Override
        public String toString() {
            return "Name: " + name + "\nRoll Number: " + rollNumber + "\nMarks: " + marks + "\nGrade: " + getGrade() + "\nPercentage: " + getPercentage();
        }
    }
}
