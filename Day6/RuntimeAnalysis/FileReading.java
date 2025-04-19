import java.io.*;
import java.util.Random;
public class FileReading {
    public static void main(String[] args) throws IOException {
        generateFile("1MB.txt", 1 * 1024 * 1024);
        generateFile("100MB.txt", 100 * 1024 * 1024);
        testFile("1MB.txt");
        testFile("100MB.txt");
    }
    public static void generateFile(String fileName, int sizeInBytes) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        byte[] buffer = new byte[1024];
        Random random = new Random();
        int bytesWritten = 0;
        while (bytesWritten < sizeInBytes) {
            random.nextBytes(buffer);
            int bytesToWrite = Math.min(buffer.length, sizeInBytes - bytesWritten);
            fos.write(buffer, 0, bytesToWrite);
            bytesWritten += bytesToWrite;
        }
        fos.close();
        System.out.println(fileName + " created with size: " + sizeInBytes / (1024 * 1024) + " MB");
    }
    public static void testFile(String filePath) throws IOException {
        System.out.println();
        System.out.println("Testing with file: " + filePath);
        long startTime = System.nanoTime();
        FileReader fr = new FileReader(filePath);
        while (fr.read() != -1);
        long endTime = System.nanoTime();
        System.out.println("FileReader Time (Character Stream) for " + filePath + ": " + (endTime - startTime) / 1_000_000 + " ms");
        fr.close();
        startTime = System.nanoTime();
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath));
        while (isr.read() != -1);
        endTime = System.nanoTime();
        System.out.println("InputStreamReader Time (Byte Stream) for " + filePath + ": " + (endTime - startTime) / 1_000_000 + " ms");
        isr.close();
    }
}

