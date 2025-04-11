/*
Problem 1
public class StringBufferProblems {
    public static void main(String[] args) {
        String[] strings = {"Hello", "World", "Java", "Programming"};
        StringBuffer sb = new StringBuffer();
        for (String str : strings) {
            sb.append(str);
        }
        System.out.println(sb.toString());
    }
}
*/

/*
Problem 2
public class StringBufferProblems {
    public static void main(String[] args) {
        long start, end;

        StringBuffer stringBuffer = new StringBuffer();
        start = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            stringBuffer.append("hello");
        }
        end = System.nanoTime();
        System.out.println("StringBuffer time: " + (end - start) + " ns");

        StringBuilder stringBuilder = new StringBuilder();
        start = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            stringBuilder.append("hello");
        }
        end = System.nanoTime();
        System.out.println("StringBuilder time: " + (end - start) + " ns");
    }
}
*/