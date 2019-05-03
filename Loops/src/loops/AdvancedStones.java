/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loops;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author pivanovs3
 */
public class AdvancedStones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //desmitais
        Scanner keyIn = new Scanner(System.in);
        System.out.print("  Please enter the amount of rocks: ");
        int rocks = keyIn.nextInt();
        System.out.println("1 <= MOVE <= 3");
        
        int moveP, moveC;
        do {
            
            do {
                System.out.print("Player: ");
                moveP = keyIn.nextInt();
            } while (moveP < 1 || moveP > 3);
            rocks -= moveP;
            if (rocks <= 0) {
                System.out.println("Computer wins!");
                break;    
            }
            
            moveC = computerMove(rocks);
            System.out.println("Computer's move: "+moveC);
            rocks -= moveC;
                        
            System.out.println("THE AMOUNT OF ROCKS: "+ rocks);
            
        } while (true);
        System.out.println("THE GAME HAS ENDED");
        
    }

    private static int computerMove(int rocks) {
        
        int move = 0;
    
        int left = rocks % 4;
        Random rand = new Random();
        switch (left) {
            case 1: move = 1 + rand.nextInt(3);
                    break;
            case 2: move = 1;
                    break;
            case 3: move = 2;
                    break;
            case 0: move = 3;
                    break;
        }
        
        return move;
    }
    
}
