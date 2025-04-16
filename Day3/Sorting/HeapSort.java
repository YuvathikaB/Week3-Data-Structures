import java.util.Scanner;
public class HeapSort {
    public static void buildMaxHeap(double[] salaries, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }
    }
    public static void heapify(double[] salaries, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && salaries[left] > salaries[largest]) {
            largest = left;
        }
        if (right < n && salaries[right] > salaries[largest]) {
            largest = right;
        }
        if (largest != i) {
            double temp = salaries[i];
            salaries[i] = salaries[largest];
            salaries[largest] = temp;

            heapify(salaries, n, largest);
        }
    }
    public static void heapSort(double[] salaries) {
        int n = salaries.length;
        buildMaxHeap(salaries, n);
        for (int i = n - 1; i >= 1; i--) {
            double temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;
            heapify(salaries, i, 0);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of job applicants: ");
        int n = scanner.nextInt();
        double[] salaries = new double[n];
        System.out.println("Enter the salary demands of the job applicants:");
        for (int i = 0; i < n; i++) {
            salaries[i] = scanner.nextDouble();
        }
        heapSort(salaries);
        System.out.println("Salary demands in ascending order:");
        for (double salary : salaries) {
            System.out.println(salary);
        }
        scanner.close();
    }
}
