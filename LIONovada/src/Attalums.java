/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pivanovs3
 */
public class Attalums {
    
    static class Frac {
        long a;
        long b;
        Frac(long a, long b) {
            this.a = a;
            this.b = b;
        }
    }
//
    private static long gcd(long a, long b) {
        if (a > b) {
            long c = a;
            a = b;
            b = c;
        }
        if (b % a == 0) {
            return a;
        }
        return gcd(b - a * (b / a), a);
    }

    public static void main(String args[]) throws java.io.IOException {
        java.io.BufferedReader bf = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        java.util.StringTokenizer tok = new java.util.StringTokenizer(bf.readLine());
        long p = Long.parseLong(tok.nextToken());
        long q = Long.parseLong(tok.nextToken());
        long r = Long.parseLong(tok.nextToken());
        long s = Long.parseLong(tok.nextToken());
        if (gcd(p, q) != 1) {
            long x = gcd(p, q);
            p /= x;
            q /= x;
        }
        if (gcd(r, s) != 1) {
            long x = gcd(r, s);
            r /= x;
            s /= x;
        }
        System.out.println(r +" " + s);
        java.util.ArrayList<Frac> d1 = new java.util.ArrayList<>();
        d1.add(new Frac(p, q));
        while (p != q) {
            if (p > q) p -= q;
            else q -= p; 
            d1.add(new Frac(p, q));
        }
        Frac f2 = new Frac(r, s);
        int count = 0;
        System.out.println(d1.contains(new Frac(1, 3)));
        while (!d1.contains(f2)) {
            if (f2.a > f2.b) f2 = new Frac(f2.a - f2.b, f2.b);
            else f2 = new Frac(f2.a, f2.b - f2.a);
            count++;
            System.out.println(f2.a + " " + f2.b);
        }
        count += d1.indexOf(f2);
        java.io.PrintWriter pw = new java.io.PrintWriter(System.out);
        pw.println(count);
        pw.flush();
    }
    
//    public static void main(String args[]) {
//        java.io.BufferedReader bf = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
//        java.util.StringTokenizer tok = new java.util.StringTokenizer(bf.readLine());
//        long p = Long.parseLong(tok.nextToken());
//        long q = Long.parseLong(tok.nextToken());
//        long r = Long.parseLong(tok.nextToken());
//        long s = Long.parseLong(tok.nextToken());
//        if (gcd(p, q) != 1) {
//            long x = gcd(p, q);
//            p /= x;
//            q /= x;
//        }
//        if (gcd(r, s) != 1) {
//            long x = gcd(r, s);
//            r /= x;
//            s /= x;
//        }
//        long counter = 0;
//        if (p == r && q == s) counter = 0;
//        
//    }
    
}
