package Day4.FileReader;
import java.io.*;
import java.util.Scanner;
public class WordCount {
    public static void main(String[] args) {
        String fileName = "src/Day4/FileReader/Sample.txt";
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the word you want to count: ");
        String targetWord = scanner.nextLine();
        scanner.close();
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }
            bufferedReader.close();
            System.out.println("The word '" + targetWord + "' appears " + count + " times in the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}
