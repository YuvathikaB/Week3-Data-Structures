package Day5.BinarySearch;
import java.util.*;
public class PeakElement {
    public static int findPeak(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            boolean leftOK = (mid == 0 || arr[mid] > arr[mid - 1]);
            boolean rightOK = (mid == arr.length - 1 || arr[mid] > arr[mid + 1]);
            if (leftOK && rightOK) {
                return arr[mid];
            } else if (mid > 0 && arr[mid] < arr[mid - 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter elements of array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int peak = findPeak(arr);
        System.out.print("A peak element is: " + peak);
        sc.close();
    }
}