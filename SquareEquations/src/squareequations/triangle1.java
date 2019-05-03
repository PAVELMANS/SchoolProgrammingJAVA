/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package squareequations;

/**
 *
 * @author pivanovs3
 */
import java.util.Scanner;
public class triangle1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        double a;
        Scanner scan = new Scanner(System.in);
        do { 
            System.out.print("  Hello, please enter the length of a side: ");
            a = scan.nextDouble();
        } while (a<0);
        
        double area, perimeter;
        area = ( a*a * Math.sqrt(3) ) / 4;
        perimeter = a * 3;  
        
        System.out.println("    ---------------------");
        System.out.println("    The are of triangle is " + area);
        System.out.println("    The perimeter of triangle is " + perimeter);
        
    }
    
}
