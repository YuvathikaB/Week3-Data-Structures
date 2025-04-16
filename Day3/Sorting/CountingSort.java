import java.util.Scanner;
public class CountingSort {
    public static void countingSort(int[] arr) {
        int min = 10, max = 18;
        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            output[--count[arr[i] - min]] = arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        int[] ages = new int[n];
        System.out.print("Enter student ages (space-separated, between 10 and 18): ");
        for (int i = 0; i < n; i++) {
            ages[i] = scanner.nextInt();
        }
        countingSort(ages);
        System.out.println("Sorted student ages in ascending order:");
        for (int age : ages) {
            System.out.print(age + " ");
        }
    }
}