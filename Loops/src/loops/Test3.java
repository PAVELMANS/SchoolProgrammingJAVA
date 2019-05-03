/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loops;

/**
 *
 * @author pivanovs3
 */
public class Test3 {
    
    public static void main(String[] args) {
    
        //astotais
        int a = 10000000;
        int count = 0;
        do {
            a = a + 1;
            if (Math.sqrt(a) % 1 == 0) {
                System.out.println(a);
                count++;
            }
        } while (count < 10);
        
    }
    
}
