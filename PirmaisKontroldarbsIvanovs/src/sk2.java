
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
public class sk2 {
 
    public static void main(String[] args) {
        
        Scanner keyIn = new Scanner(System.in);        
        int a, b;
        
        System.out.print("  Please enter the number a: ");
        a = keyIn.nextInt();
        System.out.print("  Please enter the number b: ");
        b = keyIn.nextInt();
        int numberOfFolds = 0;
        
        while (true) {
            if (a % 2 == 0) {
                numberOfFolds++;
                a /= 2;
                continue;
            }
            if (b % 2 == 0) {
                numberOfFolds++;
                b /= 2;
            } else break;
        }
        
        System.out.println("    There were made "+numberOfFolds+" fold(s)");
        
    }    
    
}
