/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author pivanovs3
 */
public class Koks {
    
//    class Pilseeta {
//        private String pilseeta;
//        private int counter;
//        
//        Pilseeta(String x) {
//           
//        }
//    }

    public static void main(String[] args) throws IOException {
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        TreeMap tm = new TreeMap();
        
        System.out.println("Lūdzu ievadiet pilsētas nosaukumu");
        System.out.println("Lai pabeigtu, ievadiet \"0\"");
        System.out.println("");
        
        do {
            String s = bf.readLine();
            if (s.equals("0")) break;
            if (tm.containsKey(s)) tm.replace(s, ((int)tm.get(s) + 1));
            else tm.put(s, 1);
        } while (true);
        
        Set set = tm.entrySet();
        Iterator i = set.iterator();
        
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            System.out.println(me.getKey() + ": " + me.getValue());
        }
        
        // TODO code application logic here
    }
    
}
