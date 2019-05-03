
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
//import java.util.Collections;
//import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pivanovs3
 */
class RNDPAIR {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(in.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(in.readLine());
            int[] numbers = new int[n];
            String num = in.readLine();
            for (int j = 0; j < n; j++) {
                numbers[j] = Integer.parseInt(num.split(" ")[j]);
            }
            double randomProb = n * (n - 1) / 2;
            //System.out.println(randomProb);
            int j = n - 1;
            while (j >= 0 && numbers[j] == numbers[n - 1]) {
                j--;
            }
            int amountMax = n - 1 - j;
            double maxProb;
            if (amountMax == 1) {
                int k = j;
                while (k >= 0 && numbers[j] == numbers[k]) {
                    k--;
                }
                maxProb = j - k;
            } else {
                maxProb = amountMax * (amountMax - 1) / 2;
            }
            //System.out.println(maxProb);
            System.out.println(maxProb / randomProb);
        }
    }

}
