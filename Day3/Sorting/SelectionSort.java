import java.util.Scanner;
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        int[] scores = new int[n];
        System.out.println("Enter exam scores (space-separated): ");
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }
        selectionSort(scores);
        System.out.println("Exam scores in ascending order:");
        for (int score : scores) {
            System.out.print(score + " ");
        }
    }
}

