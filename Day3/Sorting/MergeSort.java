import java.util.Scanner;
public class MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;
            int[] left = new int[mid];
            int[] right = new int[arr.length - mid];
            System.arraycopy(arr, 0, left, 0, mid);
            System.arraycopy(arr, mid, right, 0, arr.length - mid);
            mergeSort(left);
            mergeSort(right);
            merge(arr, left, right);
        }
    }
    public static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of books: ");
        int n = scanner.nextInt();
        int[] prices = new int[n];
        System.out.print("Enter book prices (space-separated): ");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }
        mergeSort(prices);
        System.out.println("Book prices in ascending order:");
        for (int price : prices) {
            System.out.print(price + " ");
        }
    }
}
