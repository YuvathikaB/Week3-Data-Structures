package Day4.InputStreamReader;
import java.io.*;
public class WriteToFile {
    public static void main(String[] args) {
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            FileWriter fw = new FileWriter("src/Day4/InputStreamReader/output.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            String userInput;
            System.out.println("Enter text to write to the file (type 'exit' to stop):");
            while (true) {
                userInput = br.readLine();
                if (userInput.equalsIgnoreCase("exit")) {
                    break;
                }
                bw.write(userInput);
                bw.newLine();
            }
            br.close();
            bw.close();
            System.out.println("User input has been written to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
