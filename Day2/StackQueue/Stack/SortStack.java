package Stack;
import java.util.Scanner;
import java.util.Stack;
public class SortStack {
    public static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int temp = stack.pop();
        sortStack(stack);
        insertSorted(stack, temp);
    }
    private static void insertSorted(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }
        int temp = stack.pop();
        insertSorted(stack, element);
        stack.push(temp);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        System.out.print("Enter the elements (space-separated): ");
        String input = scanner.nextLine();
        String[] elements = input.split(" ");
        for (String element : elements) {
            stack.push(Integer.parseInt(element));
        }
        System.out.println("Original stack: " + stack);
        sortStack(stack);
        System.out.println("Sorted stack: " + stack);
    }
}
