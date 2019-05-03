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
public class Test1 {
       
    public static void main(String[] args) {
        
        
        //trešais uzdevums
        Scanner keyIn = new Scanner(System.in);
        System.out.println("Please enter the n: ");
        
        int sum = 0; 
        do {
            int n = keyIn.nextInt();
            sum += n;
        } while (sum < 100);
        
    }
    
}
