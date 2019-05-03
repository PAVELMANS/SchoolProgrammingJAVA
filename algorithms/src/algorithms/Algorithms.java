/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 *
 * @author pivanovs3
 */
public class Algorithms {

    /**
     * @param x
     * @return 
     */
    
    public double f(double x) {
        x = (156.25 * x) - (156.25 * Math.sin(x)) - 320;
        return x;
    }
    
    double e = Math.pow(10, -5);
    public void intervalMeth(double a, double b){
        int iterations = 0;
       
        double c;
        do {
            iterations++;
            c = ( a + b )/2;
            if (f(c)*f(a) > 0) {
                a = c;
            } else {
                b = c;
            }
        } while (Math.abs(f(c)) > e); 
                
        System.out.println(iterations);
        System.out.println(Math.toDegrees((a+b)/2));
            
    }
    
    public void hordeMeth(double a, double b) {
        int iterations = 0;
        double c;
        
        do{
            iterations++;
            c = (b*f(a) - a*f(b)) / (f(a)-f(b));
            if (f(a)*f(c) > 0) a = c;
                    else b = c;
            
        } while (Math.abs(f(c)) > e);
        
        System.out.println(iterations);
        System.out.println(Math.toDegrees(c));
        
    }
    
    public double g(double x) {
        return (320 + 156.25 * Math.sin(x))/156.25;
    }
    
    public void iterMeth(double a, double b) {
        int i = 0;
        double c;
        
        c = a;
        while (Math.abs(g(c)-c) >= e) {
            c = g(c);
            i++;
        }
        System.out.println(i);
        System.out.println(Math.toDegrees(c));
    }
    
    public static void main(String[] args) {
        /**
        *
         * @param args
        */
        double a = 0;
        double b = Math.PI;
        new Algorithms().intervalMeth(a, b);
        new Algorithms().hordeMeth(a, b);
        new Algorithms().iterMeth(a,b);
    }
    
}
