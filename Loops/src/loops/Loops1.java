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
public class Loops1 {

    public static void main(String[] args) {        
        
        Scanner keyIn = new Scanner(System.in);
        System.out.print("Please enter the i: ");
        int a = keyIn.nextInt();
        
        for (int i = 1; i <= a; i++) {
            if (a % i == 0) {
                System.out.print(i+" ");
            }
        }
        
    }
    
}
