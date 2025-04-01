import java.io.*;
public class ReadUserInputWriteToFile {
    public static void main(String[] args) {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            FileWriter fileWriter = new FileWriter(""user_input.txt"");
            String line;
            System.out.println(""Enter text (type 'exit' to finish):"");
            while (!(line = bufferedReader.readLine()).equalsIgnoreCase(""exit"")) {
                fileWriter.write(line + ""\n"");
            }
            fileWriter.close();
            bufferedReader.close();
            inputStreamReader.close();
            System.out.println(""Input saved to user_input.txt"");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
