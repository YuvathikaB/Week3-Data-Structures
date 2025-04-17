package Day4.StringBuffer;
import java.util.Scanner;
public class StringConcatPerformance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of times to concatenate: ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter the string to concatenate: ");
        String input = sc.nextLine();
        StringBuffer stringBuffer = new StringBuffer();
        long startTimeBuffer = System.nanoTime();
        for (int i = 0; i < n; i++) {
            stringBuffer.append(input);
        }
        long endTimeBuffer = System.nanoTime();
        long durationBuffer = endTimeBuffer - startTimeBuffer;
        StringBuilder stringBuilder = new StringBuilder();
        long startTimeBuilder = System.nanoTime();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(input);
        }
        long endTimeBuilder = System.nanoTime();
        long durationBuilder = endTimeBuilder - startTimeBuilder;
        System.out.println("Time taken by StringBuffer: " + durationBuffer + " nanoseconds");
        System.out.println("Time taken by StringBuilder: " + durationBuilder + " nanoseconds");
        sc.close();
    }
}
