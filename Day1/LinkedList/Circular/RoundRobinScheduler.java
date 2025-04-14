package Circular;
import java.util.Scanner;
import java.util.ArrayList;
class Process {
    int processId;
    int burstTime;
    int priority;
    int remainingTime;
    Process next;
    Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.remainingTime = burstTime;
        this.next = null;
    }
}
class RoundRobinScheduler {
    Process head = null;
    Process tail = null;
    void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            newProcess.next = head;
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;
        }
    }
    void removeProcess(int processId) {
        if (head == null) return;
        Process temp = head;
        Process prev = null;
        boolean found = false;
        if (head.processId == processId) {
            found = true;
            if (head == tail) {
                head = tail = null;
            } else {
                tail.next = head.next;
                head = head.next;
            }
            return;
        }
        do {
            prev = temp;
            temp = temp.next;
            if (temp.processId == processId) {
                found = true;
                prev.next = temp.next;
                if (temp == tail) {
                    tail = prev;
                }
                break;
            }
        } while (temp != head);

        if (!found) {
            System.out.println("Process with ID " + processId + " not found.");
        }
    }
    void roundRobinScheduling(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }
        int currentTime = 0;
        ArrayList<Integer> finishTimes = new ArrayList<>();
        ArrayList<Integer> finishedProcessIds = new ArrayList<>();
        ArrayList<Integer> originalBurstTimes = new ArrayList<>();
        Process current = head;
        do {
            current.remainingTime = current.burstTime;
            current = current.next;
        } while (current != head);
        int completedProcesses = 0;
        int totalProcesses = 0;
        if (head != null) {
            Process tempCount = head;
            do {
                totalProcesses++;
                tempCount = tempCount.next;
            } while (tempCount != head);
        }
        while (completedProcesses < totalProcesses && head != null) {
            Process temp = head;
            do {
                if (temp != null && temp.remainingTime > 0) {
                    int executeTime = Math.min(timeQuantum, temp.remainingTime);
                    temp.remainingTime -= executeTime;
                    currentTime += executeTime;
                    System.out.println("Executing Process ID: " + temp.processId + " for " + executeTime + " units. Remaining: " + temp.remainingTime);
                    if (temp.remainingTime == 0) {
                        finishTimes.add(currentTime);
                        finishedProcessIds.add(temp.processId);
                        originalBurstTimes.add(temp.burstTime);
                        System.out.println("Process ID: " + temp.processId + " completed at time " + currentTime);
                        removeProcess(temp.processId);
                        break;
                    }
                }
                if (head == null) break;
                temp = (temp != null) ? temp.next : null;
            } while (head != null && temp != head);
            display();
        }
        System.out.println("\n       Final Results");
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        for (int i = 0; i < finishedProcessIds.size(); i++) {
            int pid = finishedProcessIds.get(i);
            int finish = finishTimes.get(i);
            int originalBurst = originalBurstTimes.get(i);
            int turnaroundTime = finish;
            int waitingTime = turnaroundTime - originalBurst;
            totalWaitingTime += waitingTime;
            totalTurnaroundTime += turnaroundTime;
            System.out.println("Process ID: " + pid + " | Turnaround Time: " + turnaroundTime + " | Waiting Time: " + waitingTime);
        }
        if (totalProcesses > 0) {
            double avgWaitingTime = (double) totalWaitingTime / totalProcesses;
            double avgTurnaroundTime = (double) totalTurnaroundTime / totalProcesses;
            System.out.println("\nAverage Waiting Time: " + String.format("%.2f", avgWaitingTime));
            System.out.println("Average Turnaround Time: " + String.format("%.2f", avgTurnaroundTime));
        } else {
            System.out.println("No processes were executed.");
        }
    }
    void display() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }
        Process temp = head;
        System.out.println("Processes in the circular queue:");
        do {
            System.out.println("Process ID: " + temp.processId + " | Remaining Burst Time: " + temp.remainingTime + " | Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1.Add Process\n2.Remove Process\n3.Round Robin Scheduling\n4.Display Processes\n5.Exit");
            System.out.println();
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            if (choice == 5) break;
            switch (choice) {
                case 1:
                    System.out.print("Enter Process ID: ");
                    int processId = sc.nextInt();
                    System.out.print("Enter Burst Time: ");
                    int burstTime = sc.nextInt();
                    System.out.print("Enter Priority: ");
                    int priority = sc.nextInt();
                    scheduler.addProcess(processId, burstTime, priority);
                    break;
                case 2:
                    System.out.print("Enter Process ID to remove: ");
                    processId = sc.nextInt();
                    scheduler.removeProcess(processId);
                    break;
                case 3:
                    System.out.print("Enter Time Quantum: ");
                    int timeQuantum = sc.nextInt();
                    scheduler.roundRobinScheduling(timeQuantum);
                    break;
                case 4:
                    scheduler.display();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}