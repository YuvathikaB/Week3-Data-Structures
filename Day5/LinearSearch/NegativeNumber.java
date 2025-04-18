package Day5.LinearSearch;
import java.util.Scanner;
public class NegativeNumber {
    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n];
        System.out.print("Enter array elements (space-separated): ");
        String[] input = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        int result = findFirstNegative(arr);
        System.out.println("Index of first negative number: " + result);
        sc.close();
    }
}
