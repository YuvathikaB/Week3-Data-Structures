package HashMap;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
public class PairWithTargetSumIndex {
    public static void findAllPairsWithSum(int[] arr, int target) {
        Map<Integer, Integer> visited = new HashMap<>();
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int complement = target - num;
            if (visited.containsKey(complement)) {
                System.out.println("[" + visited.get(complement) + ", " + i + "]");
                found = true;
            }
            visited.put(num, i);
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
//    public static void findFirstPairWithSum(int[] arr, int target) {
//        Map<Integer, Integer> visited = new HashMap<>();
//        for (int i = 0; i < arr.length; i++) {
//            int num = arr[i];
//            int complement = target - num;
//            if (visited.containsKey(complement)) {
//                System.out.println("[" + visited.get(complement) + ", " + i + "]");
//                return;
//            }
//            visited.put(num, i);
//        }
//        System.out.println("No pair with the given sum exists.");
//    }
//
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
//        findFirstPairWithSum(arr, target);
//    }
//}
