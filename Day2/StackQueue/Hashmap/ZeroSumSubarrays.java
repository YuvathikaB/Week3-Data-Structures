package HashMap;
import java.util.*;
import java.util.HashMap;

public class ZeroSumSubarrays {
    public static void findZeroSumSubarrays(int[] arr, int n) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                for (int start : map.get(sum)) {
                    System.out.print("[");
                    for (int j = start + 1; j <= i; j++) {
                        System.out.print(arr[j]);
                        if (j != i) System.out.print(", ");
                    }
                    System.out.println("]");
                }
            }
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
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
        findZeroSumSubarrays(arr, n);
    }
}

