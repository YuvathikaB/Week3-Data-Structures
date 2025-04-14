package Circular;
import java.util.Scanner;
class Task {
    int id;
    String name;
    int priority;
    String dueDate;
    Task next;
    Task(int id, String name, int priority, String dueDate) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}
class TaskScheduler {
    Task head = null;
    Task tail = null;
    Task current = null;
    void addTaskAtBeginning(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            newTask.next = head;
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head;
        }
    }
    void addTaskAtEnd(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            newTask.next = head;
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head;
        }
    }
    void addTaskAtPosition(int id, String name, int priority, String dueDate, int position) {
        if (position <= 1) {
            addTaskAtBeginning(id, name, priority, dueDate);
            return;
        }
        Task newTask = new Task(id, name, priority, dueDate);
        Task temp = head;
        int count = 1;
        while (count < position - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }
        newTask.next = temp.next;
        temp.next = newTask;
        if (temp == tail) tail = newTask;
    }
    void removeTaskById(int id) {
        if (head == null) return;
        if (head.id == id) {
            if (head == tail) {
                head = tail = null;
                return;
            }
            head = head.next;
            tail.next = head;
            return;
        }
        Task prev = head;
        Task curr = head.next;
        while (curr != head) {
            if (curr.id == id) {
                prev.next = curr.next;
                if (curr == tail) tail = prev;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
    void viewCurrentTask() {
        if (current == null) current = head;
        if (current != null) {
            System.out.println("Current Task : \nID: " + current.id + "\nName: " + current.name + "\nPriority: " + current.priority + "\nDue Date: " + current.dueDate);
        } else {
            System.out.println("No tasks available.");
        }
    }
    void moveToNextTask() {
        if (current != null) current = current.next;
    }
    void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }
        Task temp = head;
        do {
            System.out.println("Task ID: " + temp.id + "\nName: " + temp.name + "\nPriority: " + temp.priority + "\nDue Date: " + temp.dueDate);
            temp = temp.next;
            System.out.println();
        } while (temp != head);
    }
    void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println("Task ID: " + temp.id + "\nName: " + temp.name + "\nPriority: " + temp.priority + "\nDue Date: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) System.out.println("No tasks found with priority " + priority);
    }
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1.Add at Beginning\n2.Add at End\n3.Add at Position\n4.Remove by ID\n5.View Current Task\n6.Next Task\n7.Display All\n8.Search by Priority\n9.Exit");
            System.out.println();
            System.out.print("Your choice: ");
            int choice = sc.nextInt();
            if (choice == 9) break;
            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id1 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name1 = sc.nextLine();
                    System.out.print("Enter Priority: ");
                    int pr1 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Due Date: ");
                    String date1 = sc.nextLine();
                    scheduler.addTaskAtBeginning(id1, name1, pr1, date1);
                    break;
                case 2:
                    System.out.print("Enter ID: ");
                    int id2 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name2 = sc.nextLine();
                    System.out.print("Enter Priority: ");
                    int pr2 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Due Date: ");
                    String date2 = sc.nextLine();
                    scheduler.addTaskAtEnd(id2, name2, pr2, date2);
                    break;
                case 3:
                    System.out.print("Enter ID: ");
                    int id3 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name3 = sc.nextLine();
                    System.out.print("Enter Priority: ");
                    int pr3 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Due Date: ");
                    String date3 = sc.nextLine();
                    System.out.print("Enter Position: ");
                    int pos = sc.nextInt();
                    scheduler.addTaskAtPosition(id3, name3, pr3, date3, pos);
                    break;
                case 4:
                    System.out.print("Enter Task ID to remove: ");
                    int rid = sc.nextInt();
                    scheduler.removeTaskById(rid);
                    break;
                case 5:
                    scheduler.viewCurrentTask();
                    break;
                case 6:
                    scheduler.moveToNextTask();
                    scheduler.viewCurrentTask();
                    break;
                case 7:
                    scheduler.displayAllTasks();
                    break;
                case 8:
                    System.out.print("Enter Priority to search: ");
                    int spr = sc.nextInt();
                    scheduler.searchByPriority(spr);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}
