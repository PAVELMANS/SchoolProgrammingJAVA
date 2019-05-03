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
public class Test4 {
    
    public static void main(String[] args) {
    
        //desmitais
        Scanner keyIn = new Scanner(System.in);
        System.out.print("  Please enter the amount of rocks: ");
        int rocks = keyIn.nextInt();
        System.out.println("1 <= MOVE <= 3");
        
        int move1, move2;
        do {
            
            do {
                System.out.print("Player 1: ");
                move1 = keyIn.nextInt();
            } while (move1 < 1 || move1 > 3);
            rocks -= move1;
            if (rocks <= 0) {
                System.out.println("Player 2 wins!");
                break;    
            }
            
            do {
                System.out.print("Player 2: ");
                move2 = keyIn.nextInt();
            } while (move2 < 1 || move2 > 3);
            rocks -= move2;
            if (rocks <= 0) {
                System.out.println("Player 1 wins!");
                break;
            }
            
            System.out.println("THE AMOUNT OF ROCKS: "+ rocks);
            
        } while (true);
        System.out.println("THE GAME HAS ENDED");
    }
    
}
