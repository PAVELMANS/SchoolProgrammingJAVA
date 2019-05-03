
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pelk {

    private static class Pelke {

        long x, y;

        Pelke(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    static Pelke[] pelkes;
    static int N;
    long minX;
    long minY;
    long maxX;
    long maxY;

    private void calculate() {
        //first of all, let us find the height and width of the whole area
        minX = pelkes[0].x;
        minY = pelkes[0].x;
        maxX = pelkes[0].x;
        maxY = pelkes[0].x;
        for (int i = 0; i < N; i++) {
            if (pelkes[i].x < minX) {
                minX = pelkes[i].x;
            } else if (pelkes[i].x > maxX) {
                maxX = pelkes[i].x;
            }
            if (pelkes[i].y < minY) {
                minY = pelkes[i].y;
            } else if (pelkes[i].y > maxY) {
                maxY = pelkes[i].y;
            }
        }
        long height = maxY - minY + 1;
        long width = maxX - minX + 1;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        pelkes = new Pelke[N];
        for (int i = 0; i < N; i++) {
            String[] line = in.readLine().split(" ");
            pelkes[i] = new Pelke(Long.parseLong(line[0]), Long.parseLong(line[1]));
        }
        new Pelk().calculate();
    }

}
