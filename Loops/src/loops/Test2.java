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
public class Test2 {
    
    public static void main(String[] args) {
    
        //septītais
        int a = 10000000;
        do {
            a = a + 1;
        } while (Math.sqrt(a) % 1 != 0);
        System.out.println(a);
        
    }
    
}
