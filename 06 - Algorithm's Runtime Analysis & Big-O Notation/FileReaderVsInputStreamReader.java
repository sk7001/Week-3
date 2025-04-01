import java.io.*;

public class FileReaderVsInputStreamReader {
    public static void main(String[] args) throws Exception {
        File file = new File("largefile.txt"); // Replace with actual 500MB file path

        long start = System.nanoTime();
        FileReader fr = new FileReader(file);
        while (fr.read() != -1) {}
        fr.close();
        System.out.println("FileReader Time: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
        while (isr.read() != -1) {}
        isr.close();
        System.out.println("InputStreamReader Time: " + (System.nanoTime() - start) + " ns");
    }
}
