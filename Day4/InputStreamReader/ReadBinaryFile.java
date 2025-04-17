package Day4.InputStreamReader;
import java.io.*;
public class ReadBinaryFile {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("src/Day4/InputStreamReader/Sample_UTF.txt");
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
            isr.close();
            fis.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
