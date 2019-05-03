/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serveri;

/**
 *
 * @author pivanovs3
 */
public class Serveri {

    /**
     * @param args the command line arguments
     */
    
    public void printodd() {
        for (int i = 0; i <= 100; i++) {
            if (i%2 != 0) {
                System.out.print(i+" ");
            }
        }
    }
    
    public void printEven() {
        for (int i = 0; i <= 100; i++) {
            if ((i%2)==0) {
                System.out.print(i+" ");
            }
        }
    }
    
    public void fibNum() {
        long a = 1;
        System.out.print(a+" ");
        long b = 1;
        long oldb = b;
        for (int i = 0; i < 99; i++) {
            System.out.print(b+" ");
            oldb= b;
            b+= a;
            a = oldb;
        }
    }
    
    public void primePrint() {
        boolean isPrime = true;
        for (int i = 1; i <= 1000; i++) {
            isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) System.out.print(i+" ");
        }
    }
    
    public void palindromePrint () {
        String num = "";
        boolean isPali = true;
        for (int i = 1; i <= 1000; i++) {
            num = "" + i;
            isPali = true;
            for (int j = 0; j <= num.length() / 2; j++) {
                if (num.charAt(j) != num.charAt(num.length()-(j+1))) {
                    isPali = false;
                    break;
                }
            }
            if (isPali) System.out.print(i+" ");
            
        }
    }
    
    public void printGolomb() {
        int n = 1;
        for (int i = 1; i <= 100; i++) {
            
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        new Serveri().printodd();
        System.out.println("");
        new Serveri().printEven();
        System.out.println("");
        new Serveri().fibNum();
        System.out.println("");
        new Serveri().primePrint();
        System.out.println("");
        new Serveri().palindromePrint();
        System.out.println("");
        new Serveri().printGolomb();
    }
    
}
