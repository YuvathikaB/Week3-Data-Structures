package Queue;
import java.util.Scanner;
public class PetrolPump {
    public static int findStartPoint(int[] petrol, int[] distance, int n) {
        int start = 0, balance = 0, deficit = 0;
        for (int i = 0; i < n; i++) {
            balance += petrol[i] - distance[i];
            if (balance < 0) {
                deficit += balance;
                balance = 0;
                start = i + 1;
            }
        }
        return (balance + deficit >= 0) ? start : -1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of petrol pumps: ");
        int n = scanner.nextInt();
        int[] petrol = new int[n];
        int[] distance = new int[n];
        System.out.print("Enter petrol at each pump (space-separated): ");
        for (int i = 0; i < n; i++) {
            petrol[i] = scanner.nextInt();
        }
        System.out.print("Enter distance to next pump (space-separated): ");
        for (int i = 0; i < n; i++) {
            distance[i] = scanner.nextInt();
        }
        int start = findStartPoint(petrol, distance, n);
        if (start == -1) {
            System.out.println("Tour not possible");
        } else {
            System.out.println("Start at pump " + start);
        }
    }
}
