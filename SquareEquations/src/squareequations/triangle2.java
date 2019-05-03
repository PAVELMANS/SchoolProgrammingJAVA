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
public class triangle2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        double a, b;
        Scanner scan = new Scanner(System.in);
        do { 
            System.out.print("  Hello, please enter the length of a side: ");
            a = scan.nextDouble();
            System.out.print("  And then enter the length of b side: ");
            b = scan.nextDouble();
        } while ((a<0) && (b<0));
        
        double area, perimeter;
        area = (a * b) / 2;
        perimeter = a + b + (Math.sqrt(a*a + b*b));
        
        System.out.println("  -----------------------------");
        System.out.println("  The area: " + area);
        System.out.println("  The perimeter: " + perimeter);
        
    }
    
}
