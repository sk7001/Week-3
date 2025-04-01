import java.io.*;
import java.util.StringTokenizer;
public class ChallengeProblem {
    public static void main(String[] args) throws Exception {
        compareStringBuilderAndBuffer();
        readFileUsingFileReader(""largefile.txt"");
        readFileUsingInputStreamReader(""largefile.txt"");
    }
    public static void compareStringBuilderAndBuffer() {
        String text = ""hello"";
        int repeat = 1_000_000;
        long startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < repeat; i++) {
            sb.append(text);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(""Time taken by StringBuilder: "" + (endTime - startTime) + "" ms"");
        startTime = System.currentTimeMillis();
        StringBuffer sf = new StringBuffer();
        for (int i = 0; i < repeat; i++) {
            sf.append(text);
        }
        endTime = System.currentTimeMillis();
        System.out.println(""Time taken by StringBuffer: "" + (endTime - startTime) + "" ms"");
    }
    public static void readFileUsingFileReader(String filename) {
        long startTime = System.currentTimeMillis();
        int wordCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line);
                wordCount += tokenizer.countTokens();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(""Word count using FileReader: "" + wordCount);
        System.out.println(""Time taken with FileReader: "" + (endTime - startTime) + "" ms"");
    }
    public static void readFileUsingInputStreamReader(String filename) {
        long startTime = System.currentTimeMillis();
        int wordCount = 0;
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(filename), ""UTF-8""))) {
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line);
                wordCount += tokenizer.countTokens();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(""Word count using InputStreamReader: "" + wordCount);
        System.out.println(""Time taken with InputStreamReader: "" + (endTime - startTime) + "" ms"");
    }
}
