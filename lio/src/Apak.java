
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Apak {

    static int N;
    static int M;
    static int A;
    static int B;
    static int[][] matrix;

    private int doMagic(int iP, int jP) {
        int counter = 0;
        for (int i = iP; i < N; i++) {
            for (int j = jP; j < M; j++) {
                long sum = calculateSum(iP, jP, i, j);
                if (sum >= A && sum <= B) {
                    counter++;
                }

            }
        }
        return counter;
    }

    private void calculate() {
        int SUM = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                SUM += doMagic(i, j);
            }
        }
        System.out.println(SUM);
    }

    private int calculateSum(int i1, int j1, int i2, int j2) { //remember that point 1 is upper and lefter
        int sum = 0;
        for (int i = i1; i <= i2; i++) {
            for (int j = j1; j <= j2; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //String firstLine = in.readLine();
        String[] initLine = in.readLine().split(" ");
        N = Integer.parseInt(initLine[0]);
        M = Integer.parseInt(initLine[1]);
        A = Integer.parseInt(initLine[2]);
        B = Integer.parseInt(initLine[3]);
        matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] line = in.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }
        new Apak().calculate();
    }

}
