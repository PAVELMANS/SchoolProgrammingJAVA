
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pivanovs3
 */
public class Senes {
    
//    class Tulip implements Comparable<Object> {
//        long x, y;
//        int m;
//        Tulip(long x, long y, int m) {
//            this.x = x;
//            this.y = y;
//            this.m = m;
//        }
//        
//                }
    
    public static void main(String args[]) throws java.io.IOException {
        java.io.BufferedReader bf = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        java.util.StringTokenizer tok;
        int n = Integer.parseInt(bf.readLine());
        //Tulip[] lauk = new Tulip[n];
        int[][] lauk = new int[n][3];
        for (int i = 0; i < n; i++) {
            tok = new java.util.StringTokenizer(bf.readLine());
            for (int j = 0; j < 3; j++) lauk[i][j] = Integer.parseInt(tok.nextToken());
        }
       
    }
    
}
