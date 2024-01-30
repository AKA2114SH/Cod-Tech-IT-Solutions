import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentGradeManagementSystem {
    static Map<String, Student> studentMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Display Student Information");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();

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
                    displayStudentInfo();
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    static void addStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student name: ");
        String name = scanner.nextLine();
        System.out.println("Enter student roll number: ");
        String rollNumber = scanner.nextLine();
        System.out.println("Enter marks for each subject (comma-separated): ");
        String[] subjects = scanner.nextLine().split(",");
        int[] marks = new int[subjects.length];
        for (int i = 0; i < subjects.length; i++) {
            marks[i] = Integer.parseInt(subjects[i]);
        }

        Student student = new Student(name, rollNumber, marks);
        studentMap.put(rollNumber, student);
        System.out.println("Student added successfully.");
    }

    static void updateStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student roll number to update: ");
        String rollNumber = scanner.nextLine();
        if (studentMap.containsKey(rollNumber)) {
            Student student = studentMap.get(rollNumber);
            System.out.println("Enter new marks for each subject (comma-separated): ");
            String[] subjects = scanner.nextLine().split(",");
            int[] marks = new int[subjects.length];
            for (int i = 0; i < subjects.length; i++) {
                marks[i] = Integer.parseInt(subjects[i]);
            }
            student.setMarks(marks);
            System.out.println("Student information updated successfully.");
        } else {
            System.out.println("Student with roll number " + rollNumber + " not found.");
        }
    }

    static void deleteStudent() {
       
