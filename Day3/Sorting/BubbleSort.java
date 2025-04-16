import java.util.Scanner;
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        int[] marks = new int[n];
        System.out.print("Enter student marks (space-separated): ");
        for (int i = 0; i < n; i++) {
            marks[i] = scanner.nextInt();
        }
        bubbleSort(marks);
        System.out.println("Marks in ascending order:");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
    }
}

