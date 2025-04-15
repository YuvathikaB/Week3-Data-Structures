package Stack;
import java.util.Scanner;
import java.util.Stack;
public class QueueUsingStacks {
    private Stack<Integer> stackEnqueue;
    private Stack<Integer> stackDequeue;
    public QueueUsingStacks() {
        stackEnqueue = new Stack<>();
        stackDequeue = new Stack<>();
    }
    public void enqueue(int x) {
        stackEnqueue.push(x);
    }
    public int dequeue() {
        if (stackDequeue.isEmpty()) {
            while (!stackEnqueue.isEmpty()) {
                stackDequeue.push(stackEnqueue.pop());
            }
        }
        if (stackDequeue.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return stackDequeue.pop();
    }
    public int peek() {
        if (stackDequeue.isEmpty()) {
            while (!stackEnqueue.isEmpty()) {
                stackDequeue.push(stackEnqueue.pop());
            }
        }
        if (stackDequeue.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return stackDequeue.peek();
    }
    public boolean isEmpty() {
        return stackEnqueue.isEmpty() && stackDequeue.isEmpty();
    }
    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Is Empty");
            System.out.println("5. Exit");
            System.out.println();
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter value to enqueue: ");
                        int value = scanner.nextInt();
                        queue.enqueue(value);
                        break;
                    case 2:
                        System.out.println("Dequeued: " + queue.dequeue());
                        break;
                    case 3:
                        System.out.println("Front element: " + queue.peek());
                        break;
                    case 4:
                        System.out.println("Is empty : "+ (queue.isEmpty() ? "Yes" : "No"));
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Invalid option");
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

