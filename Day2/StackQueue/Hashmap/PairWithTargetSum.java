package HashMap;
import java.util.HashMap;
import java.util.Map;
import java.util.*;
public class PairWithTargetSum {
    public static void findAllPairsWithSum(int[] arr, int target) {
        Map<Integer, Boolean> visited = new HashMap<>();
        boolean found = false;
        for (int num : arr) {
            int complement = target - num;
            if (visited.containsKey(complement)) {
                System.out.println("[" + complement + ", " + num + "]");
                found = true;
            }
            visited.put(num, true);
        }
        if (!found) {
            System.out.println("No pair with the given sum exists.");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter array elements (space-separated): ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.print("Enter target sum: ");
        int target = scanner.nextInt();

        findAllPairsWithSum(arr, target);
    }
}










//public class PairWithTargetSum {
//    public static boolean findOnePairWithSum(int[] arr, int target) {
//        Map<Integer, Boolean> visited = new HashMap<>();
//        for (int num : arr) {
//            int complement = target - num;
//            if (visited.containsKey(complement)) {
//                System.out.println("[" + complement + ", " + num + "]");
//                return true;
//            }
//            visited.put(num, true);
//        }
//        return false;
//    }
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter number of elements: ");
//        int n = scanner.nextInt();
//        int[] arr = new int[n];
//        System.out.print("Enter array elements (space-separated): ");
//        for (int i = 0; i < n; i++) {
//            arr[i] = scanner.nextInt();
//        }
//        System.out.print("Enter target sum: ");
//        int target = scanner.nextInt();
//
//        if (!findOnePairWithSum(arr, target)) {
//            System.out.println("No pair with the given sum exists.");
//        }
//    }
//}
