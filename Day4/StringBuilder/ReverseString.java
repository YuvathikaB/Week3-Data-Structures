package Day4.StringBuilder;
import java.util.*;
public class ReverseString {
    public static String reverse(String input) {
        StringBuilder sb = new StringBuilder();
        sb.append(input);
        sb.reverse();
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        String reversed = reverse(input);
        System.out.println("Reversed string: " + reversed);
        sc.close();
    }
}