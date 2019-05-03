

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pivanovs3
 */
public class Kastes {

    public static void main(String args[]) throws java.io.IOException {
        java.io.BufferedReader bf = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        bf.readLine(); // nav jeegas glabaat N
        java.util.StringTokenizer tok = new java.util.StringTokenizer(bf.readLine());
        long height = 0;
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        int a = Integer.parseInt(tok.nextToken());
        height += a;
        stack.add(Integer.MAX_VALUE);
        stack.add(a);
        do {
            int x = Integer.parseInt(tok.nextToken());
            if (x <= a) {
                height += x;
                stack.add(x);
                a = x;
            } else {
                long tempH = 0;
                while (!stack.empty() && x > stack.peek()) {
                    tempH += stack.pop();
                }
                if (tempH < x) {
                    height -= tempH;
                    height += x;
                } else {
                    stack.add((int)(tempH - x));
                }
                stack.add(x);
            }
        } while (tok.hasMoreTokens());

        java.io.PrintWriter pw = new java.io.PrintWriter(System.out);
        pw.println(height);
        
        pw.flush();
    }

}
