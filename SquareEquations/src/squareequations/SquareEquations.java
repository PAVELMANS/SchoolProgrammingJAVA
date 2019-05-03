/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package squareequations;

import java.util.Scanner;


/**
 *
 * @author pivanovs3
 */
//import java.util.Scanner;
//import java.math.*;
public class SquareEquations {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner keyIn = new Scanner(System.in);
        System.out.println("  Hello, this program solves");
        System.out.println("  squere equations such as ax^2 + bx + c = 0");
        System.out.print("Please enter the a: ");
        double a = keyIn.nextDouble();
        
        if (a == 0) {
            System.out.println("  The a can't be zero!!!");
        } else {
            System.out.print("Please enter the b: ");
            Double b = keyIn.nextDouble();
            System.out.print("Please enter the c: ");
            Double c = keyIn.nextDouble();

            Double D = b*b - 4 * a * c;
            if (D < 0){
                System.out.println("There are no roots!");    
            } else {
                if (D > 0) {
                    Double x1 = (-b - Math.sqrt(D))/(2*a);
                    Double x2 = (-b + Math.sqrt(D))/(2*a);
                    System.out.println("There are two roots: "+x1+" "+x2);
                } else {
                    System.out.println("The root is: " + (-b)/(2*a));
                }
            }
        }
        
    }
    
}
