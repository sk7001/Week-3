public class SearchWordInSentences {
    public static void main(String[] args) {
        String[] sentences = {
            ""Java is fun."",
            ""We are learning programming."",
            ""This is a search example."",
            ""Binary search is powerful.""
        };
        String word = ""search"";
        String result = ""Not Found"";
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                result = sentence;
                break;
            }
        }
        System.out.println(""Result: "" + result);
    }
}
