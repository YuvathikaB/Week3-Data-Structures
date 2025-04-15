package Stack;
import java.util.Scanner;
import java.util.Stack;
public class StockSpan {
    public static void calculateSpan(int[] prices, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] span = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - stack.peek();
            }
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(span[i] + " ");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of days: ");
        int n = scanner.nextInt();
        int[] prices = new int[n];
        System.out.print("Enter the stock prices for each day (space-separated): ");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }
        System.out.println("Stock spans are: ");
        calculateSpan(prices, n);
    }
}
