package Day5.LinearSearch;
import java.util.Scanner;
public class SentenceSearch {
    public static String findSentence(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of sentences: ");
        int n = Integer.parseInt(sc.nextLine());
        String[] sentences = new String[n];
        System.out.println("Enter sentences:");
        for (int i = 0; i < n; i++) {
            sentences[i] = sc.nextLine();
        }
        System.out.print("Enter word to search: ");
        String word = sc.nextLine();
        String result = findSentence(sentences, word);
        System.out.println("Result: " + result);
        sc.close();
    }
}
