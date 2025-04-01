public class StringConcatenationPerformance {
    public static void main(String[] args) {
        int N = 100000;

        long start = System.nanoTime();
        String s = "";
        for (int i = 0; i < N; i++) s += "a";
        System.out.println("String Time: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) sb.append("a");
        System.out.println("StringBuilder Time: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        StringBuffer sf = new StringBuffer();
        for (int i = 0; i < N; i++) sf.append("a");
        System.out.println("StringBuffer Time: " + (System.nanoTime() - start) + " ns");
    }
}
