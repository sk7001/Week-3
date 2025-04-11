/*
import java.io.*;

public class InputStreamReaderProblems {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("data.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
 */

/*
Problem 2
import java.io.*;

public class InputStreamReaderProblems {
    public static void main(String[] args) {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            FileWriter fileWriter = new FileWriter("user_input.txt");

            String line;
            System.out.println("Enter text (type 'exit' to finish):");
            while (!(line = bufferedReader.readLine()).equalsIgnoreCase("exit")) {
                fileWriter.write(line + "\n");
            }

            fileWriter.close();
            bufferedReader.close();
            inputStreamReader.close();

            System.out.println("Input saved to user_input.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
 */

/*
Challenge Problem
import java.io.*;
import java.util.StringTokenizer;

public class InputStreamReaderProblems {

    public static void main(String[] args) throws Exception {
        compareStringBuilderAndBuffer();
        readFileUsingFileReader("largefile.txt");
        readFileUsingInputStreamReader("largefile.txt");
    }

    public static void compareStringBuilderAndBuffer() {
        String text = "hello";
        int repeat = 1_000_000;

        long startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < repeat; i++) {
            sb.append(text);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken by StringBuilder: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        StringBuffer sf = new StringBuffer();
        for (int i = 0; i < repeat; i++) {
            sf.append(text);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time taken by StringBuffer: " + (endTime - startTime) + " ms");
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
        System.out.println("Word count using FileReader: " + wordCount);
        System.out.println("Time taken with FileReader: " + (endTime - startTime) + " ms");
    }

    public static void readFileUsingInputStreamReader(String filename) {
        long startTime = System.currentTimeMillis();
        int wordCount = 0;

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(filename), "UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line);
                wordCount += tokenizer.countTokens();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Word count using InputStreamReader: " + wordCount);
        System.out.println("Time taken with InputStreamReader: " + (endTime - startTime) + " ms");
    }
}
 */

