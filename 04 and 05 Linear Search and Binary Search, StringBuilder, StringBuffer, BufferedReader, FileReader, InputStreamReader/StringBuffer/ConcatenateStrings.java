public class ConcatenateStrings {
    public static void main(String[] args) {
        String[] strings = {""Hello"", ""World"", ""Java"", ""Programming""};
        StringBuffer sb = new StringBuffer();
        for (String str : strings) {
            sb.append(str);
        }
        System.out.println(sb.toString());
    }
}
