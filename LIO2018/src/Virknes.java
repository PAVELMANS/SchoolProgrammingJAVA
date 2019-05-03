
import java.io.IOException;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Pivanovs3
 */
public class Virknes {

    public static void main(String args[]) throws IOException {
        java.io.BufferedReader bf = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        java.io.PrintWriter pw = new java.io.PrintWriter(System.out);

        bf.readLine();

        java.util.TreeMap<Long, Integer> map = new java.util.TreeMap<>();
        int s1 = 0;
        int s2 = 0;
        int s3 = 0;
        java.util.StringTokenizer tok = new java.util.StringTokenizer(bf.readLine());
        do {
            s1++;
            map.put(Long.parseLong(tok.nextToken()), 1);
        } while (tok.hasMoreTokens());
        tok = new java.util.StringTokenizer(bf.readLine());
        do {
            long x = Long.parseLong(tok.nextToken());
            if (map.containsKey(x)) {
                s1--;
                s2++;
                map.put(x, map.get(x) + 1);
            } else {
                map.put(x, 1);
                s1++;
            }
        } while (tok.hasMoreTokens());
        tok = new java.util.StringTokenizer(bf.readLine());
        do {
            long x = Long.parseLong(tok.nextToken());
            if (map.containsKey(x)) {
                if (map.get(x) == 1) {
                    s1--;
                    s2++;
                } else {
                    s2--;
                    s3++;
                }
            } else {
                s1++;
            }
        } while (tok.hasMoreTokens());
        pw.println(s3 + " " + s2 + " " + s1);
        pw.flush();
    }

}
