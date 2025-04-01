import java.io.*;
public class ReadBinaryAsCharacters {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream(""data.txt"");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, ""UTF-8"");
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
