
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Nava {

    String abc = "abcdefghijklmnoprstuvz";
    String minSub = "";
    static int N;
    static String X;

    private int isThere(char ch, String x) {
        for (int i = 0; i < x.length(); i++) {
            if (ch == x.charAt(i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean contains(String subS, String base) {
        for (int i = 0; i < subS.length(); i++) {
            int index = isThere(subS.charAt(i), base);
            if (index < 0) {
                return false;
            }
            base = base.substring(index + 1);
        }
        return true;

    }

    private void findMin(int i, String subS) {

        if (i == 0 && !subS.isEmpty()) {
            if (!contains(subS, X)) {
                if (minSub.isEmpty()) {
                    minSub = subS;
                } else {
                    if (subS.compareTo(minSub) < 0) {
                        minSub = subS;
                    }
                }
            }
        } else {
            for (int j = 0; j < N; j++) {
                findMin(i - 1, subS + abc.charAt(j));
            }
        }

    }

    private void process(int N, int G, String X) {
        int i = 1;
        while (minSub.isEmpty()) {
            findMin(i, "");
            i++;
        }
        System.out.println(minSub);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = in.readLine();
        N = Integer.parseInt(firstLine.split(" ")[0]);
        int G = Integer.parseInt(firstLine.split(" ")[1]);
        X = in.readLine().toLowerCase();
        new Nava().process(N, G, X);
    }
}
