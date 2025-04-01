import java.io.*;
public class CountWordOccurrences {
    public static void main(String[] args) {
        String target = ""am"";
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(""sample.txt""))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(""\\s+"");
                for (String word : words) {
                    if (word.equalsIgnoreCase(target)) {
                        count++;
                    }
                }
            }
            System.out.println(""Occurrences: "" + count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
