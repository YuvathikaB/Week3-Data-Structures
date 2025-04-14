package Single;
import java.util.Scanner;
class Student {
    int rollNumber;
    String name;
    int age;
    String grade;
    Student next;
    Student(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}
class StudentList {
    Student head;
    void addAtBeginning(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }
    void addAtEnd(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStudent;
    }
    void addAtPosition(int position, int rollNumber, String name, int age, String grade) {
        if (position == 0) {
            addAtBeginning(rollNumber, name, age, grade);
            return;
        }
        Student newStudent = new Student(rollNumber, name, age, grade);
        Student temp = head;
        for (int i = 0; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) return;
        newStudent.next = temp.next;
        temp.next = newStudent;
    }
    void deleteByRollNumber(int rollNumber) {
        if (head == null) return;
        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }
        Student temp = head;
        while (temp.next != null && temp.next.rollNumber != rollNumber) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }
    Student searchByRollNumber(int rollNumber) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) return temp;
            temp = temp.next;
        }
        return null;
    }
    void updateGradeByRollNumber(int rollNumber, String newGrade) {
        Student temp = searchByRollNumber(rollNumber);
        if (temp != null) {
            temp.grade = newGrade;
        }
    }
    void display() {
        Student temp = head;
        while (temp != null) {
            System.out.println("Roll No: " + temp.rollNumber + " \nName: " + temp.name + " \nAge: " + temp.age + "\nGrade: " + temp.grade);
            temp = temp.next;
            System.out.println();
        }
    }
}
public class StudentManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentList list = new StudentList();
        while (true) {
            System.out.println("\n1. Add at Beginning\n2. Add at End\n3. Add at Position\n4. Delete by Roll Number\n5. Search by Roll Number\n6. Update Grade\n7. Display All\n8. Exit");
            System.out.print("Enter your choice : ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Roll Number, Name, Age, Grade(separated by space): ");
                    list.addAtBeginning(scanner.nextInt(), scanner.next(), scanner.nextInt(), scanner.next());
                    break;
                case 2:
                    System.out.print("Enter Roll Number, Name, Age, Grade(separated by space): ");
                    list.addAtEnd(scanner.nextInt(), scanner.next(), scanner.nextInt(), scanner.next());
                    break;
                case 3:
                    System.out.print("Enter Position, Roll Number, Name, Age, Grade(separated by space): ");
                    list.addAtPosition(scanner.nextInt(), scanner.nextInt(), scanner.next(), scanner.nextInt(), scanner.next());
                    break;
                case 4:
                    System.out.print("Enter Roll Number to Delete: ");
                    list.deleteByRollNumber(scanner.nextInt());
                    break;
                case 5:
                    System.out.print("Enter Roll Number to Search: ");
                    Student s = list.searchByRollNumber(scanner.nextInt());
                    if (s != null) System.out.println("Found: " + s.name + ", Age: " + s.age + ", Grade: " + s.grade);
                    else System.out.println("Student not found");
                    break;
                case 6:
                    System.out.print("Enter Roll Number and New Grade(separated by space): ");
                    list.updateGradeByRollNumber(scanner.nextInt(), scanner.next());
                    break;
                case 7:
                    list.display();
                    break;
                case 8:
                    return;
            }
        }
    }
}
