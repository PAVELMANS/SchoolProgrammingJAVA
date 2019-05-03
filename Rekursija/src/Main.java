
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pivanovs3
 */
public class Main {

    public static int fib(int n) {
        if (n > 2) {
            return n + fib(n-1);
        } else {
            return 1;
        }
    }
    
    public static void main (String args[]) {
        System.out.print("Please enter the n: ");
        Scanner inPut = new Scanner(System.in);
        int n = inPut.nextInt();
        System.out.println(fib(n));
    }
    
}
