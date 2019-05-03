/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loops;

import java.util.Scanner;

/**
 *
 * @author pivanovs3
 */
public class Loops2 {
       
    public static void main(String[] args) {
        
        Scanner keyIn = new Scanner(System.in);
        System.out.print("Please enter the a: ");
        int a = keyIn.nextInt();
        System.out.print("Please enter the b (a<b): ");
        int b = keyIn.nextInt();
        
        if (a % 2 != 0) {
            a++;
        }
        for (int i = a; i <= b; i += 2) {
            System.out.print(i+" ");
        }
        
    }
    
}
